package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User

class RecuperarSenhaController {

    def userService

    def recuperar() { }

    //TODO implementar via ajax
    def conferirDados(){
        Pessoa pessoa = Aluno.findByEmail(params.email.toString())
        if(pessoa == null){
            flash.message = 'Email não se encontra cadastrado!'
            redirect(controller: 'recuperarSenha', action: 'recuperar')
            return
        }
        userService.recuperarSenha(User.findByPessoa(pessoa))
        flash.message = 'Um email foi enviado!'
        redirect(controller: 'login', action: 'auth')
    }

    def redefinir(String key){
        User user = User.findByKey(key)
        if(user == null){
            flash.message = 'Ops! esse Link não está mais válido!'
            return
        }else if(!user.enabled){
            flash.message = 'Você ainda não confirmou o seu cadastro'
            return
        }
        [user: user]
    }

    //TODO implementar via ajax
    def alterarSenha(){
        User user = User.get(params.long('id'))
        if(params.password != params.passwordconfirm){
            flash.error = 'Senha diferentes!'
            redirect(action: 'redefinir', params : [key: user.key])
            return
        }
        user.key = null
        user.password = params.password
        user.save(flush: true, failOnError: true)
        redirect(controller: 'login', action: 'auth')
    }
}
