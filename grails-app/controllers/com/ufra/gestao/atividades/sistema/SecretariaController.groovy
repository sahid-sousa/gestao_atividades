package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.StatusDocumentacao
import com.ufra.gestao.atividades.enums.TipoCategoriaAtividade
import com.ufra.gestao.atividades.security.User

import static org.springframework.http.HttpStatus.NOT_FOUND

class SecretariaController {

    def springSecurityService
    def documentacaoService

    def index() {
        User user = springSecurityService.currentUser
        [
                user: user
        ]
    }

    def atividadeComplementarList(){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        User user = springSecurityService.currentUser
        def documentacoes = documentacaoService.listDocumentacao(TipoCategoriaAtividade.ATIVIDADE_COMPLEMENTAR, StatusDocumentacao.PENDENTE_ANALISE, params)
        def countDocumentacao = documentacaoService.countDocumentacao(TipoCategoriaAtividade.ATIVIDADE_COMPLEMENTAR, StatusDocumentacao.PENDENTE_ANALISE, params)
        [
                user: user,
                documentacoes: documentacoes,
                countDocumentacao: countDocumentacao
        ] + params
    }

    def estagioSupervisionadoList(){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        User user = springSecurityService.currentUser
        def documentacoes = documentacaoService.listDocumentacao(TipoCategoriaAtividade.ESTAGIO_SUPERVISIONADO, StatusDocumentacao.PENDENTE_ANALISE, params)
        def countDocumentacao = documentacaoService.countDocumentacao(TipoCategoriaAtividade.ESTAGIO_SUPERVISIONADO, StatusDocumentacao.PENDENTE_ANALISE, params)
        [
                user: user,
                documentacoes: documentacoes,
                countDocumentacao: countDocumentacao
        ] + params

    }

    def showAtividadeComplementar(Documentacao documentacao){
        User user = springSecurityService.currentUser
        if(!documentacao){
            notFound()
            return
        }
        [
                user: user,
                documentacao: documentacao
        ]
    }

    def showEstagioSupervisionado(Documentacao documentacao){
        User user = springSecurityService.currentUser
        if(!documentacao){
            notFound()
            return
        }
        [
                user: user,
                documentacao: documentacao
        ]
    }


    def editarAtividadeComplementar(Documentacao documentacao){
        def user = springSecurityService.currentUser
        if(!documentacao){
            notFound()
            return
        }
        [
                user: user,
                documentacao: documentacao
        ]
    }

    def update(){
        Documentacao documentacao = Documentacao.get(params.long('idDocumentacao'))
        if(!documentacao){
            notFound()
            return
        }
        documentacao.statusDocumentacao = StatusDocumentacao.valueOf(params.statusDocumentacao as String)
        documentacao.comentario = params.comentario
        documentacao.save(flush: true, failOnError: true)
        flash.message = "Documentacao ${documentacao.nome} atualizada com sucesso!"
        def action = documentacao.instanceOf(DocumentacaoAtividadeComplementar) ? 'showAtividadeComplementar' : 'showEstagioSupervisionado'
        redirect(action: action, id: "${documentacao.id}")
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
