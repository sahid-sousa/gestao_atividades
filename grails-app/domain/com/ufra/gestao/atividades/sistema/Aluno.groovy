package com.ufra.gestao.atividades.sistema


class Aluno extends Pessoa{

    String matricula

    static hasMany = [
            categoriaAtividadeAluno: CategoriaAtividadeAluno,
    ]

    static constraints = {
        matricula nullable: false, blank: false, unique: true
    }
}
