package com.ufra.gestao.atividades.enums

enum StatusDocumentacao {
    PENDENTE_ANALISE('Em Análise'),
    VALIDADO('Validado'),
    INVALIDO('Inválido'),
    DEFERIDO('Deferido'),
    INDEFERIDO('Indeferido')

    String descricao

    StatusDocumentacao(String descricao){
        this.descricao = descricao
    }

    String toString(){
        descricao
    }

    String getKey() {
        name()
    }

    static def secretaria(){
        [PENDENTE_ANALISE, VALIDADO, INVALIDO]
    }

}