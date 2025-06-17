package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.StatusEstagioSupervisionado

class CategoriaAtividadeAlunoEso extends CategoriaAtividadeAluno{

    String nomeOrientador
    String emailOrientador

    StatusEstagioSupervisionado statusEstagioSupervisionado

    static constraints = {
        statusEstagioSupervisionado nullable: true
        nomeOrientador nullable: true
        emailOrientador nullable: true
    }
}
