package com.ufra.gestao.atividades.sistema

class Estado {

    String nome
    String sigla

    static hasMany = [cidades: Cidade]

    static mapping = {
        cidades cascade: 'all-delete-orphan'
    }

    static constraints = {
        nome nullable: false
        sigla nullable: true
    }

    static init(){
        withTransaction {
            [
                    findOrSaveWhere(nome: 'Acre', sigla: 'AC'),
                    findOrSaveWhere(nome: 'Alagoas', sigla: 'AL'),
                    findOrSaveWhere(nome: 'Amazonas', sigla: 'AM'),
                    findOrSaveWhere(nome: 'Amapá', sigla: 'AP'),
                    findOrSaveWhere(nome: 'Bahia', sigla: 'BA'),
                    findOrSaveWhere(nome: 'Ceará', sigla: 'CE'),
                    findOrSaveWhere(nome: 'Distrito Federal', sigla: 'DF'),
                    findOrSaveWhere(nome: 'Espírito Santo', sigla: 'ES'),
                    findOrSaveWhere(nome: 'Goiás', sigla: 'GO'),
                    findOrSaveWhere(nome: 'Maranhão', sigla: 'MA'),
                    findOrSaveWhere(nome: 'Minas Gerais', sigla: 'MG'),
                    findOrSaveWhere(nome: 'Mato Grosso do Sul', sigla: 'MS'),
                    findOrSaveWhere(nome: 'Mato Grosso', sigla: 'MT'),
                    findOrSaveWhere(nome: 'Pará', sigla: 'PA'),
                    findOrSaveWhere(nome: 'Paraíba', sigla: 'PB'),
                    findOrSaveWhere(nome: 'Pernambuco', sigla: 'PE'),
                    findOrSaveWhere(nome: 'Piauí', sigla: 'PI'),
                    findOrSaveWhere(nome: 'Paraná', sigla: 'PR'),
                    findOrSaveWhere(nome: 'Rio de Janeiro', sigla: 'RJ'),
                    findOrSaveWhere(nome: 'Rio Grande do Norte', sigla: 'RN'),
                    findOrSaveWhere(nome: 'Rondônia', sigla: 'RO'),
                    findOrSaveWhere(nome: 'Roraima', sigla: 'RR'),
                    findOrSaveWhere(nome: 'Rio Grande do Sul', sigla: 'RS'),
                    findOrSaveWhere(nome: 'Santa Catarina', sigla: 'SC'),
                    findOrSaveWhere(nome: 'Sergipe', sigla: 'SE'),
                    findOrSaveWhere(nome: 'São Paulo', sigla: 'SP'),
                    findOrSaveWhere(nome: 'Tocantins', sigla: 'TO')
            ]
        }
    }
}
