package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoAtividadeComplementar


class DocumentacaoAtividadeComplementar extends Documentacao{

    Date dataEvento
    String descricao
    Integer cargaHoraria
    TipoAtividadeComplementar tipoAtividade

    static constraints = {
        dataEvento nullable: false
        descricao nullable: false
        cargaHoraria nullable: false
        cargaHoraria min: 0
    }
}
