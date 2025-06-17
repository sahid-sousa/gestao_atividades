package com.ufra.gestao.atividades.enums

enum TipoCategoriaAtividade {
    ESTAGIO_SUPERVISIONADO('Estágio Supervisionado'),
    ATIVIDADE_COMPLEMENTAR('Atividade Complementar')

    String descricao

    TipoCategoriaAtividade(String descricao){
        this.descricao = descricao
    }

    String toString(){
        descricao
    }
}