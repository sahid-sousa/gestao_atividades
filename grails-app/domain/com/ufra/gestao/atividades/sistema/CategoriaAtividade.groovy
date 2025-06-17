package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoCategoriaAtividade

class CategoriaAtividade {

    String nome
    String sigla
    String descricao
    Integer cargaHoraria

    TipoCategoriaAtividade tipoCategoriaAtividade

    static belongsTo = [atividade: Atividade]
    static hasMany = [categoriaAtividadeAluno: CategoriaAtividadeAluno]

    static mapping = {
        descricao type: 'text'
    }

    static constraints = {
        nome nullable: false, maxSize: 200
        descricao nullable: true, maxSize: 255
        sigla nullable: true
        cargaHoraria nullable: false
        tipoCategoriaAtividade nullable: false
    }

    String toString(){
        nome
    }

    static init(){
        Atividade eso = Atividade.findByCodigo('ESO')
        Atividade atic = Atividade.findByCodigo('ATIC')
        TipoCategoriaAtividade estagio = TipoCategoriaAtividade.ESTAGIO_SUPERVISIONADO
        TipoCategoriaAtividade atividade = TipoCategoriaAtividade.ATIVIDADE_COMPLEMENTAR

        withTransaction {
            [
                    //CATEGORIAS ESO
                    findOrSaveWhere(nome: 'Estágio Supervisionado I', sigla: 'ESO1', descricao: '', tipoCategoriaAtividade: estagio,cargaHoraria: 100, atividade: eso),
                    findOrSaveWhere(nome: 'Estágio Supervisionado II', sigla: 'ESO2', descricao: '', tipoCategoriaAtividade: estagio,cargaHoraria: 100, atividade: eso),
                    findOrSaveWhere(nome: 'Estágio Supervisionado III', sigla: 'ESO3', descricao: '', tipoCategoriaAtividade: estagio,cargaHoraria: 100, atividade: eso),
                    findOrSaveWhere(nome: 'Estágio Supervisionado IV', sigla: 'ESO4', descricao: '', tipoCategoriaAtividade: estagio,cargaHoraria: 100, atividade: eso),

                    //CATEGORIAS ATIVIDADE COMPLEMENTAR
                    findOrSaveWhere(nome: 'Eventos Técnicos, Científicos e Culturais', sigla: '', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 20, atividade: atic),
                    findOrSaveWhere(nome: 'Estágios Extracurriculares', sigla: '', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 80, atividade: atic),
                    findOrSaveWhere(nome: 'Programas de Estímulo à Docência, Pesquisa e Extensão', sigla: '', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 80, atividade: atic),
                    findOrSaveWhere(nome: 'Cursos de Formação Complementar', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 80, atividade: atic),
                    findOrSaveWhere(nome: 'Publicação de Trabalhos Técnico-Científicos', sigla: '', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 20, atividade: atic),
                    findOrSaveWhere(nome: 'Monitorias e Tutorias', sigla: '', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 80, atividade: atic),
                    findOrSaveWhere(nome: 'Administração Acadêmica', sigla: '', descricao: '', tipoCategoriaAtividade: atividade, cargaHoraria: 20, atividade: atic),
            ]
        }
    }

}
