package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User
import static org.springframework.http.HttpStatus.*


class AlunoController {
    def atividadeService
    def springSecurityService

    def index(){
        User user = springSecurityService.getCurrentUser()

        if(!user){
            notFound()
            return
        }

        List<Atividade> atividades = atividadeService.listAtividade()

        [atividades: atividades, user: user]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aluno.label', default: 'Aluno'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
