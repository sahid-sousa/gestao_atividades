package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.StatusEstagioSupervisionado
import com.ufra.gestao.atividades.enums.TipoDocumentoEstagio

class DocumentacaoEstagioSupervisionado extends Documentacao{

    TipoDocumentoEstagio tipoDocumentoEstagio
    StatusEstagioSupervisionado statusEstagio = StatusEstagioSupervisionado.PENDENTE_ANALISE

    static constraints = {
    }

}
