package com.ufra.gestao.atividades.sistema

class Atividade {

    String nome
    String codigo
    Integer cargaHorariaTotal

    static  hasMany = [categorias: CategoriaAtividade]

    static constraints = {
        nome nullable: false, maxSize: 200
        codigo nullable: false, maxSize: 6
        cargaHorariaTotal nullable: false, min: 0
    }
}
