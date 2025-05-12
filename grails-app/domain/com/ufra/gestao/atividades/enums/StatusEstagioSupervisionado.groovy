package com.ufra.gestao.atividades.enums

enum StatusEstagioSupervisionado {
    MATRICULADO('Matriculado'),
    APROVADO('Aprovado'),
    REPROVADO('Reprovado'),
    PENDENTE_ANALISE('Em Análise')

    String descricao

    StatusEstagioSupervisionado(String descricao){
        this.descricao = descricao
    }

    String toString(){
        descricao
    }
}