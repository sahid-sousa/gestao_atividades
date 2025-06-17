package com.ufra.gestao.atividades.sistema

class Endereco {

    String cep
    String logradouro
    String complemento
    String numero
    String bairro
    Estado estado
    Cidade cidade

    static constraints = {
        complemento nullable: true
    }
}
