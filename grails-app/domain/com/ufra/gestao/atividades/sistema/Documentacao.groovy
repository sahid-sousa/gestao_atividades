package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.StatusDocumentacao
import com.ufra.gestao.atividades.enums.TipoCategoriaAtividade

class Documentacao {

    Date dateCreated
    String nome
    String comentario

    StatusDocumentacao statusDocumentacao = StatusDocumentacao.PENDENTE_ANALISE

    static belongsTo = [
            pessoa : Pessoa,
            categoriaAtividadeAluno: CategoriaAtividadeAluno
    ]

    static hasMany = [documentos: Documento]
    static mapping = {
        documentos cascade: 'all-delete-orphan'
    }

    static constraints = {
        comentario nullable: true
    }

    TipoCategoriaAtividade getCategoriaAtividade(){
        this.categoriaAtividadeAluno.categoriaAtividade.tipoCategoriaAtividade
    }
}
