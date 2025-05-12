package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.StatusDocumentacao

class CategoriaAtividadeAlunoAtic extends CategoriaAtividadeAluno{
    static transients = ['cargaHorariaTotal']
    static constraints = {
    }
    Integer getCargaHorariaTotal(){
        DocumentacaoAtividadeComplementar.createCriteria().get {
            eq('categoriaAtividadeAluno', this)
            eq('statusDocumentacao', StatusDocumentacao.DEFERIDO)
            projections{
                sum('cargaHoraria')
            }
        } ?: 0
    }
}
