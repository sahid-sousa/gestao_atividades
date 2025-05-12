package com.ufra.gestao.atividades.sistema

class Telefone {

    String ddd
    String numero

    static constraints = {
        ddd nullable: false
        numero nullable: false
    }
}
