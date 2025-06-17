package com.ufra.gestao.atividades.sistema

class Documento {

    Date dateCreated = new Date()
    String fileName
    String fullPath
    String originalFileName

    static belongsTo = [
            documentacao: Documentacao,
    ]

    static constraints = {
        fileName nullable: false
        fullPath nullable: false
        originalFileName nullable: false
    }
}
