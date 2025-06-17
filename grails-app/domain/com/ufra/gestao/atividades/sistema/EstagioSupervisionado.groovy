package com.ufra.gestao.atividades.sistema

class EstagioSupervisionado extends Atividade{

    static constraints = {
    }

    static init(){
        withTransaction {
            [
                    findOrSaveWhere('nome': 'Estágio Supervisionado', codigo: 'ESO',cargaHorariaTotal: 400)
            ]
        }
    }
}
