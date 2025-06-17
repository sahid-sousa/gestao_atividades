package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User
import static org.springframework.http.HttpStatus.*

class DocumentoController {

    def documentoService
    def springSecurityService
    def atividadeService

    def index() {
        redirect(action: 'list')
    }

    def list(){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        User user = springSecurityService.getCurrentUser()
        CategoriaAtividadeAluno categoria = CategoriaAtividadeAluno.get(params.long('id'))
        if(!categoria){
            notFound()
            return
        }
        List<Documento> documentos = documentoService.listDocumento(user.pessoa, params)
        List<Atividade> atividades = atividadeService.listAtividade()
        Long countDocumentos = documentoService.countDocumento(user.pessoa, params)
        [
                documentos: documentos,
                categoria: categoria,
                countDocumentos: countDocumentos,
                atividades: atividades,
                user: user
        ] + params
    }

    def create(){}

    def edit(){}

    def delete(){}

    def save(){}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documento.label', default: 'Documento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
