package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.StatusDocumentacao
import com.ufra.gestao.atividades.enums.TipoAtividadeComplementar
import com.ufra.gestao.atividades.enums.TipoCategoriaAtividade
import com.ufra.gestao.atividades.enums.TipoDocumentoEstagio
import grails.gorm.transactions.Transactional

@Transactional
class DocumentacaoService {

    def documentoService
    /**
     * Esse método salva uma instancia de AtividadeComplementar
     * @param params
     * @return
     */

    DocumentacaoAtividadeComplementar salvarAtividadeComplementar(Map params){
        def documentacao = params.documentacaoId ? DocumentacaoAtividadeComplementar.get(params.long('documentacaoId')): new DocumentacaoAtividadeComplementar()
        documentacao.nome = params.nome
        documentacao.descricao = params.descricao
        documentacao.dataEvento = new Date(params.dataEvento)
        documentacao.tipoAtividade = TipoAtividadeComplementar.valueOf(params.tipoDocumentacao)
        documentacao.cargaHoraria = new Integer(params.cargaHoraria)
        documentacao.pessoa = Pessoa.get(params.long('pessoa'))
        documentacao.categoriaAtividadeAluno = CategoriaAtividadeAluno.get(params.long('categoriaAtividadeAluno'))
        documentacao.save(flush: true, failOnError: true)
    }

    /**
     * Esse método salva uma instacia de EstagioSupervisionado
     * @param params
     * @return
     */

    DocumentacaoEstagioSupervisionado salvarAtividadeEstagioSupervisionado(Map params){
        def documentacao = params.documentacaoId ? DocumentacaoEstagioSupervisionado.get(params.long('documentacaoId')): new DocumentacaoEstagioSupervisionado()
        documentacao.nome = TipoDocumentoEstagio.valueOf(params.nome).descricao
        documentacao.tipoDocumentoEstagio = TipoDocumentoEstagio.valueOf(params.nome)
        documentacao.pessoa = Pessoa.get(params.long('pessoa'))
        documentacao.categoriaAtividadeAluno = CategoriaAtividadeAluno.get(params.long('categoriaAtividadeAluno'))
        documentacao.save(flush: true, failOnError: true)
    }

    /**
     * Esse método dele uma instancia de Documentacao.
     * @param documentacao
     * @return
     */

    def delete(Documentacao documentacao){
        List<Documento> documentos = documentoService.listDocumento(documentacao)
        documentos.each{ documento ->
            documentoService.delete(documento)
        }
        documentacao.delete(flush: true, failOnError: true)
    }

    /**
     * Listagem de Documentacao
     * @param pessoa
     * @param params
     * @return
     */

    List<Documentacao> listDocumentacao(Pessoa pessoa, Map params){
        def criteria = {
            eq('categoriaAtividadeAluno', CategoriaAtividadeAluno.get(params.long('id')))
            eq('pessoa', pessoa)
        }
        Documentacao.createCriteria().list(params, criteria)
    }

    /**
     * Listagem de Documentacao por tipo de categoria
     * @param pessoa
     * @param tipoCategoriaAtividade
     * @return
     */

    List<Documentacao> listDocumentacao(Pessoa pessoa, TipoCategoriaAtividade tipoCategoriaAtividade, Map params){
        def criteria = {
            eq('pessoa', pessoa)
            categoriaAtividadeAluno{
                categoriaAtividade{
                    eq('tipoCategoriaAtividade', tipoCategoriaAtividade)
                }
            }
        }
        Documentacao.createCriteria().list(params, criteria)
    }

    /**
     * Listagem de Documentacao por tipo de categoria e status documentacao
     * @param tipoCategoriaAtividade
     * @param statusDocumentacao
     * @return
     */
    List<Documentacao> listDocumentacao(TipoCategoriaAtividade tipoCategoriaAtividade, StatusDocumentacao statusDocumentacao, Map params){
        def criteria = {
            if(params.nome){
                ilike('nome',"%${params.nome}%")
            }
            pessoa{
                if(params.aluno){
                    ilike('nome', "%${params.aluno}%")
                }
            }
            eq('statusDocumentacao', statusDocumentacao)
            categoriaAtividadeAluno{
                categoriaAtividade{
                    eq('tipoCategoriaAtividade', tipoCategoriaAtividade)
                }
            }
        }
        Documentacao.createCriteria().list(params, criteria)
    }

    /**
     * Conta a quantidade de Documentacao por pessoa e categoria de atividade
     * @param pessoa
     * @param tipoCategoriaAtividade
     * @return
     */
    Long countDocumentacao(Pessoa pessoa, TipoCategoriaAtividade tipoCategoriaAtividade){
        def criteria = {
            eq('pessoa', pessoa)
            categoriaAtividadeAluno{
                categoriaAtividade{
                    eq('tipoCategoriaAtividade', tipoCategoriaAtividade)
                }
            }
            projections {
                count()
            }

        }
        Documentacao.createCriteria().count(criteria)
    }

    /**
     * Conta a quatidade de Documentacao por tipo de categoria e status da documentacao
     * @param tipoCategoriaAtividade
     * @return
     */

    Long countDocumentacao(TipoCategoriaAtividade tipoCategoriaAtividade, StatusDocumentacao statusDocumentacao, Map params){
        def criteria = {
            if(params.nome){
                ilike('nome',"%${params.nome}%")
            }
            pessoa{
                if(params.aluno){
                    ilike('nome', "%${params.aluno}%")
                }
            }
            eq('statusDocumentacao', statusDocumentacao)
            categoriaAtividadeAluno{
                categoriaAtividade{
                    eq('tipoCategoriaAtividade', tipoCategoriaAtividade)
                }
            }
            projections {
                count()
            }
        }
        Documentacao.createCriteria().count(criteria)
    }

    /**
     * Conta a quantidade de documentos por pessoas
     * @param pessoa
     * @param params
     * @return
     */
    Long countDocumentacao(Pessoa pessoa, Map params){
        def criteria = {
            eq('categoriaAtividadeAluno', CategoriaAtividadeAluno.get(params.long('id')))
            eq('pessoa', pessoa)
        }
        Documentacao.createCriteria().count(criteria)
    }

}
