package com.ufra.gestao.atividades.enums

enum TipoGenero {

    FEMININO('Feminino'),
    MASCULINO('Masculino')

    String tipo

    TipoGenero(String tipo) {
        this.tipo = tipo
    }

    @Override
    String toString() {
        tipo
    }

    String getKey() {
        name()
    }

    static TipoGenero getBy(String tipo){
        for(TipoGenero tg : TipoGenero.values()){
            if(tg.tipo == tipo){
                return tg
            }
        }
        return null
    }

}