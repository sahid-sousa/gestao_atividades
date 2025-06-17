package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User

class UsuarioController {

    def springSecurityService
    def atividadeService

    def index() {
        User user = springSecurityService.getCurrentUser()
        List<Atividade> atividades = atividadeService.listAtividade()

        [atividades: atividades, user: user]
    }
}
