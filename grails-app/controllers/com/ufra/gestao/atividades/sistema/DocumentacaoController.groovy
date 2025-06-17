package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoDocumentoEstagio
import com.ufra.gestao.atividades.security.User
import grails.converters.JSON
import org.apache.tomcat.util.http.fileupload.FileUploadException

import static org.springframework.http.HttpStatus.*

class DocumentacaoController {

    def atividadeService
    def documentacaoService
    def documentoService
    def springSecurityService

    def index() {
        redirect(action: 'list', params: params)
    }

    def list(){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        User user = springSecurityService.getCurrentUser()
        CategoriaAtividadeAluno categoria = CategoriaAtividadeAluno.get(params.long('id'))
        if(!categoria){
            notFound()
            return
        }
        List<Documentacao> documentacoes = documentacaoService.listDocumentacao(user.pessoa, params)
        Long countDocumentacao = documentacaoService.countDocumentacao(user.pessoa, params)
        List<Atividade> atividades = atividadeService.listAtividade()
        [
                documentacoes: documentacoes,
                categoria: categoria,
                atividades: atividades,
                countDocumentacao: countDocumentacao,
                user: user
        ] + params
    }

    def show(Documentacao documentacao){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        List<Atividade> atividades = atividadeService.listAtividade()
        User user = springSecurityService.getCurrentUser()
        if(!documentacao){
            notFound()
            return
        }
        List<Documento> documentos = documentoService.listDocumento(documentacao, params)
        Long countDocumentos = documentoService.countDocumento(documentacao)
        [
                user: user,
                atividades: atividades,
                documentacao: documentacao,
                documentos: documentos,
                countDocumentos: countDocumentos
        ] + params
    }

    def edit(Documentacao documentacao){
        List<Atividade> atividades = atividadeService.listAtividade()
        User user = springSecurityService.getCurrentUser()
        if(!documentacao){
            notFound()
            return
        }
        [
                user: user,
                atividades: atividades,
                documentacao: documentacao
        ]
    }

    def deleteArquivo(){
        documentoService.delete(Documento.get(params.long('idDoc')))
        Documentacao documentacao = Documentacao.get(params.long('idDocumentacao'))
        List<Documento> documentos = documentoService.listDocumento(documentacao)
        def countDocumentos = documentoService.countDocumento(documentacao)
        render(template: 'documentos', model: [documentos: documentos, documentacao: documentacao, countDocumentos: countDocumentos])
    }

    def deleteDocumentacao(){
        User user = springSecurityService.getCurrentUser()
        Documentacao documentacao = Documentacao.get(params.long('idDocumentacao'))
        documentacaoService.delete(documentacao)
        def documentacoes = documentacaoService.listDocumentacao(user.pessoa, documentacao.categoriaAtividade, params)
        def countDocumentacao = documentacaoService.countDocumentacao(user.pessoa, documentacao.categoriaAtividade)
        if(documentacao instanceof DocumentacaoAtividadeComplementar)
            render(template: 'documentacoesAtividade', model: [documentacoes: documentacoes, countDocumentacao: countDocumentacao])
        else
            render(template: 'documentacoesEstagio', model: [documentacoes: documentacoes, countDocumentacao: countDocumentacao])
    }

    def delete(){
        def documentacao = Documentacao.get(params.long('idDocumentacao'))
        documentacaoService.delete(documentacao)
        def url = g.createLink(controller: 'documentacao', action: 'list', id: documentacao.categoriaAtividadeAluno.id, absolute: true)
        flash.message = "Documentacao ${documentacao.nome} excluída!"
        render([redirect: url] as JSON)
    }

    def upload(){
        Documentacao documentacao = Documentacao.get(params.long('idDocumentacao'))
        try{
            def files = params.list('file')
            for(file in files){
                documentoService.uploadFile(file, documentacao)
            }
            flash.message = 'Upload realizado com sucesso!'
        }catch(FileUploadException e){
            flash.error = e.message
        }
        redirect(action: 'show', id: documentacao.id)
    }

    def download(Documento documento){
        if(!documento){
            notFound()
            return
        }
        def file = new File(documento.fullPath)
        if (file.exists()) {
            response.setContentType("application/octet-stream")
            response.setHeader("Content-disposition", "filename=${file.name}")
            response.outputStream << file.bytes
        }
    }

    def getDocumentacao(){
        def model = [:]
        Documentacao documentacao = Documentacao.get(params.long('idDocumentacao'))
        if(!documentacao){
            model.status = false
        }
        if(documentacao instanceof DocumentacaoAtividadeComplementar){
            model.tipo = 'ATIVIDADE_COMPLEMENTAR'
        }
        if(documentacao instanceof DocumentacaoEstagioSupervisionado){
            model.tipo = 'ESTAGIO_SUPERVISIONADO'
        }
        model.status = true
        model.documentacao = documentacao
        render(model as JSON)
    }


    def salvarAtividadeComplementar(){
        Documentacao documentacao = documentacaoService.salvarAtividadeComplementar(params)
        redirect(action: 'show', id: documentacao.id)
    }

    def salvarAtividadeEstagioSupervisionado(){
        def tipo = TipoDocumentoEstagio.valueOf(params.nome)
        Documentacao documentacao = DocumentacaoEstagioSupervisionado.findByTipoDocumentoEstagio(tipo)
        if(!documentacao){
            documentacao = documentacaoService.salvarAtividadeEstagioSupervisionado(params)
        }else{
            flash.error = "Documentação ${documentacao.nome} já está cadastrado."
            redirect(action: 'list', id: documentacao.categoriaAtividadeAluno.id)
            return
        }
        redirect(action: 'show', id: documentacao.id)
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentacao.label', default: 'Documentacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
