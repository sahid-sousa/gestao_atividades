package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User

class TelaPrincipalController {

    def springSecurityService

    def index() {
        if(!springSecurityService.isLoggedIn()){
            redirect(controller : 'login', action : 'auth')
            return
        }else if(springSecurityService.isLoggedIn()){
            User user = springSecurityService.getCurrentUser()
            if(user.pessoa.instanceOf(Aluno)){
                redirect(controller: 'aluno', action: 'index')
                return
            }else if(user.pessoa.instanceOf(Administrador)){
                render('Dashboard Administrador')
                return
            }else if(user.pessoa.instanceOf(Secretaria)){
                redirect(controller: 'secretaria', action: 'index')
                return
            }
        }else{
            redirect(controller : 'login', action : 'auth')
            return
        }

    }
}
