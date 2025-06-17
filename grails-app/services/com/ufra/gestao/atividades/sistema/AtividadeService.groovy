package com.ufra.gestao.atividades.sistema

import grails.gorm.transactions.Transactional

@Transactional
class AtividadeService {

    /**
     * Listagem de atividades
     * @return
     */
    List<Atividade> listAtividade() {
        Atividade.createCriteria().list {
            order('nome', 'asc')
        }
    }
}
