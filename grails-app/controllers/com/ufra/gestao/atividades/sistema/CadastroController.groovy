package com.ufra.gestao.atividades.sistema


import com.ufra.gestao.atividades.security.User
import grails.converters.JSON

import static org.springframework.http.HttpStatus.*

class CadastroController {
    def alunoService
    def springSecurityService

    def create() {}

    //TODO implementar via ajax
    def save(){
        Map response = [
                status: true,
                title: 'Cadastro realizado com sucesso!',
                text : 'Um email foi enviado para você!',
                url : g.createLink(controller: 'login', action: 'auth', absolute: true)
        ]
        try{
            alunoService.create(params)
        }catch (RuntimeException e){
            response.status = false
            response.title = "Ops!"
            response.text = e.message
        }
        render response as JSON
    }

    def ativar(String value){
        User user = User.findByKey(value)
        if(user == null || user.enabled){
            flash.message = 'Ops! esse Link não está mais válido!'
            return
        }
        [user : user]
    }

    def confirmarConta(){
        User user = User.get(params.long('id'))
        user.enabled = true
        user.key = null
        user.save(flush: true, failOnError: true)
        springSecurityService.reauthenticate(user.username, user.password)
        redirect(controller: 'telaPrincipal', action: 'index')
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
