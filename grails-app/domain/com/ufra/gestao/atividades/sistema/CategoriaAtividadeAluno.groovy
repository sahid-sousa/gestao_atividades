package com.ufra.gestao.atividades.sistema

class CategoriaAtividadeAluno {


    static belongsTo = [pessoa: Pessoa, categoriaAtividade : CategoriaAtividade]
    static hasMany = [
            documentacao : Documentacao,
    ]

    static mapping = {
        documentacao cascade: 'all-delete-orphan'
    }

    static constraints = {
    }
}
