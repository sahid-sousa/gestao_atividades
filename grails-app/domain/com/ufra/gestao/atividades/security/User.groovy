package com.ufra.gestao.atividades.security

import com.ufra.gestao.atividades.sistema.Pessoa
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String key
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    Pessoa pessoa


    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    String getTipoAcesso() {
        def roles = authorities
        if (roles.find { it.authority == 'ROLE_USER' }) {
            return 'Aluno'
        } else if (roles.find { it.authority == 'ROLE_ADMIN' }) {
            return 'Administrador'
        } else if (roles.find { it.authority == 'ROLE_SECRETARIA' }) {
            return 'Secretaria'
        } else if (roles.find { it.authority == 'ROLE_SUPORTE' }) {
            return 'Suporte'
        }
    }

    String getNomeAbreviado() {
        String[] nome = this.pessoa.nome.split(" ")
        if(nome.size() > 1){
            return "${nome[0]} ${nome[nome.size() - 1]}"
        }else{
            return "${this.pessoa.nome}"
        }
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        key nullable: true, blank: true, unique: false
        pessoa nullable: true
    }

    static mapping = {
        table '`users`'
        password column: '`password`'
    }
}
