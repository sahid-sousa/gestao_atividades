package com.ufra.gestao.atividades.sistema

class AtividadeComplementar extends  Atividade{

    static constraints = {
    }

    static init(){
        withTransaction {
            [
                    findOrSaveWhere('nome': 'Atividade Complementar', codigo: 'ATIC', cargaHorariaTotal: 350)
            ]
        }
    }
}
