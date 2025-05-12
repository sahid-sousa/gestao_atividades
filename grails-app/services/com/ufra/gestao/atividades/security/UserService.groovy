package com.ufra.gestao.atividades.security

import com.ufra.gestao.atividades.sistema.Pessoa
import grails.gorm.transactions.Transactional
import grails.web.mapping.LinkGenerator

@Transactional
class UserService {

    def enviarEmailService
    LinkGenerator grailsLinkGenerator

    /**
     * Salva um instancia de User.
     * @param username
     * @param pessoa
     * @param pass
     * @param roles
     * @param enabled
     * @return
     */

    User createUser(String username, Pessoa pessoa, String pass, List<String> roles, boolean  enabled) {
        def user = new User()
        user.username = username
        user.password = pass
        user.enabled = enabled
        user.pessoa = pessoa
        user.key = UUID.randomUUID().toString()
        user.save()
        roles.each {
            def role = Role.findByAuthority(it)
            UserRole.create(user, role)
        }
        user
    }

    /**
     * Envia email de recuperação de senha
     * @param user
     * @return
     */

    def recuperarSenha(User user){
        user.key = UUID.randomUUID().toString()
        user.save(flush: true, failOnError: true)
        String link = grailsLinkGenerator.link(controller: 'recuperarSenha', action: 'redefinir', params:[key: user.key], absolute: true)
        enviarEmailService.emailRecuperarSenha(user.pessoa.email, link)
    }

}
