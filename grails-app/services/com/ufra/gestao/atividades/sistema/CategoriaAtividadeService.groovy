package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoCategoriaAtividade
import grails.gorm.transactions.Transactional

@Transactional
class CategoriaAtividadeService {


    /**
     * Listage de categorias por atividade
     * @param atividade
     * @return
     */
    List<CategoriaAtividade> listCategoriasAtividade(Atividade atividade){
        CategoriaAtividade.createCriteria().list {
            eq ('atividade', atividade)
            order("id", "asc")
        }
    }

    /**
     * Listage de categorias por tipo de categoria atividade
     * @param tipoCategoriaAtividade
     * @return
     */
    List<CategoriaAtividade> listCategoriasAtividade(TipoCategoriaAtividade tipoCategoriaAtividade){
        CategoriaAtividade.createCriteria().list {
            eq('tipoCategoriaAtividade', tipoCategoriaAtividade)
            order("id", "asc")
        }
    }

    /**
     * Listagem de categoria por atividade e pessoa
     * @param atividade
     * @param pessoa
     * @return
     */

    List<CategoriaAtividadeAluno> listCategoriaAtividadeAluno(Atividade atividade, Pessoa pessoa){
        CategoriaAtividadeAluno.createCriteria().list {
            categoriaAtividade{
                eq('atividade', atividade)
            }
            eq('pessoa', pessoa)
        }
    }

    /**
     * Cria uma instancia de categoria por pessoa e tipos de categorias
     * @param pessoa
     * @param tiposCategoriaAtividade
     */

    void createCategoriaAtividadeAluno(Pessoa pessoa, List<TipoCategoriaAtividade> tiposCategoriaAtividade){
        tiposCategoriaAtividade.each{ tipoCategoriaAtividade ->
            createCategoriaAtividadeAluno(pessoa, tipoCategoriaAtividade)
        }
    }

    /**
     * Cria as instancias de categoria por pessoa e tipos de categorias
     * @param pessoa
     * @param tiposCategoriaAtividade
     */

    void createCategoriaAtividadeAluno(Pessoa pessoa, TipoCategoriaAtividade tipoCategoriaAtividade){
        List<CategoriaAtividade> categoriaAtividades = listCategoriasAtividade(tipoCategoriaAtividade)
        switch (tipoCategoriaAtividade){
            case TipoCategoriaAtividade.ESTAGIO_SUPERVISIONADO:
                categoriaAtividades.each { categoriaAtividade ->
                    new CategoriaAtividadeAlunoEso(
                            pessoa: pessoa,
                            categoriaAtividade: categoriaAtividade
                    ).save(flush: true, failOnError: true)
                }
                break
            case TipoCategoriaAtividade.ATIVIDADE_COMPLEMENTAR:
                categoriaAtividades.each { categoriaAtividade ->
                    new CategoriaAtividadeAlunoAtic(
                            pessoa: pessoa,
                            categoriaAtividade: categoriaAtividade
                    ).save(flush: true, failOnError: true)
                }
                break
        }
    }
}
