package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoGenero

class Pessoa {

    String nome
    String cpf
    String rg
    String email
    Date dataNascimento
    TipoGenero genero

    static hasMany = [
            telefones: Telefone,
            enderecos: Endereco,
            documentos: Documentacao
    ]

    static mapping = {
        telefones cascade: 'all-delete-orphan'
        enderecos cascade: 'all-delete-orphan'
        documentos cascade: 'all-delete-orphan'
    }

    static constraints = {
        nome nullable: false
        cpf nullable: true, blank: true
        rg nullable: true, blank: true
        email nullable: true, blank: true, unique: true
        dataNascimento nullable: true, blank: true
        genero nullable: true, blank: true
    }
}
