package com.ufra.gestao.atividades.sistema

class Cidade {

    String nome

    static belongsTo = [estado: Estado]

    static constraints = {
        nome nullable: false
    }

    //http://samus.com.br/web/site/artigo-todas_as_cidades_do_brasil_atualizado_e_com_acentos
}
