package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User

import static org.springframework.http.HttpStatus.*

class AtividadeController {

    def atividadeService
    def categoriaAtividadeService
    def springSecurityService

    def show(Atividade atividade) {
        if(!atividade){
            notFound()
            return
        }
        User user = springSecurityService.getCurrentUser()
        Pessoa pessoa = user.pessoa
        List<Atividade> atividades = atividadeService.listAtividade()

        List<CategoriaAtividadeAluno> categorias = categoriaAtividadeService.listCategoriaAtividadeAluno(atividade, pessoa)
        [
                atividades: atividades,
                atividade: atividade,
                categorias: categorias,
                user: user
        ]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'atividade.label', default: 'Atividade'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
