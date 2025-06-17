package com.ufra.gestao.atividades.enums

enum TipoAtividadeComplementar {

    CONGRESSO('Congressos'),
    SIMPOSIO('Simpósios'),
    SEMINARIO('Seminário'),
    WORKSHOPS('Workshops'),
    ESTAGIO('Estágios'),
    COORDENADORIA('Coordenadoria'),
    PIBID('PIBID'),
    PRODOCENCIA('Prodocência'),
    LINGUAS('Línguas'),
    INFORMATICA('Informática'),
    ORATORIA('Oratória'),
    TEATRO('Teatro'),
    DANCA('Dança'),
    REVISTAS('Revistas'),
    JORNAIS('Jornais'),
    ANAIS_DE_EVENTOS('Anais de Eventos'),
    OUTROS('Outros')

    String descricao

    TipoAtividadeComplementar(String descricao){
        this.descricao = descricao
    }

    String toString() {
        descricao
    }

    String getKey() {
        name()
    }

    static TipoAtividadeComplementar fromString(String descricao) {
        for (TipoAtividadeComplementar t : TipoAtividadeComplementar.values()) {
            if (t.descricao == descricao) {
                return t
            }
        }
        return null
    }



}