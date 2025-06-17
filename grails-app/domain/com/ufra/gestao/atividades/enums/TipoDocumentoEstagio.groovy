package com.ufra.gestao.atividades.enums

enum TipoDocumentoEstagio {
    DECLARACAO_ORIENTACAO('Declaração de Orientação'),
    FICHA_FREQUENCIA('Ficha de Frequência'),
    RELATORIO_FINAL('Relatório Final'),
    TERMO_COMPROMISSO('Termo de Compromisso')

    String descricao

    TipoDocumentoEstagio(String descricao){
        this.descricao = descricao
    }

    String toString() {
        descricao
    }

    String getKey() {
        name()
    }

    static TipoDocumentoEstagio fromString(String descricao) {
        for (TipoDocumentoEstagio t : TipoDocumentoEstagio.values()) {
            if (t.descricao == descricao) {
                return t
            }
        }
        return null
    }

}