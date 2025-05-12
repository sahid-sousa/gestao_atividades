package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoCategoriaAtividade
import com.ufra.gestao.atividades.enums.TipoGenero
import com.ufra.gestao.atividades.security.User
import grails.gorm.transactions.Transactional
import grails.web.mapping.LinkGenerator


@Transactional
class AlunoService {
    def userService
    def enviarEmailService
    def categoriaAtividadeService
    LinkGenerator grailsLinkGenerator

    /**
     * Cria um instancia de aluno
     * @param params
     * @return
     */

    Aluno create(Map params){
        List<TipoCategoriaAtividade> tiposCategoriaAtividade = [
                TipoCategoriaAtividade.ESTAGIO_SUPERVISIONADO,
                TipoCategoriaAtividade.ATIVIDADE_COMPLEMENTAR
        ]

        if(Aluno.findByMatricula(params.matricula as String)){
            throw new RuntimeException("Já existe um cadastro com o número de matricula informado!")
        }

        if(Aluno.findByEmail(params.email as String)){
            throw new RuntimeException("Já existe um cadastro com o email informado!")
        }

        Aluno aluno = new Aluno(params)
        if(!aluno.validate()){
            throw new RuntimeException('Não foi possivel efetuar o cadastro!')
        }

        aluno.genero = TipoGenero.valueOf(params.genero.toString())
        aluno = aluno.save(flush: true)
        String username = params.email.toString()
        String password = params.password.toString()
        User user = userService.createUser(username, aluno , password, ['ROLE_USER'], false)
        String link = grailsLinkGenerator.link(controller:'cadastro', action:'ativar', params:[value: user.key], absolute: true)
        enviarEmailService.emailConfirmacaoConta(user.pessoa.email, link)
        categoriaAtividadeService.createCategoriaAtividadeAluno(aluno, tiposCategoriaAtividade)
        aluno
    }
}
