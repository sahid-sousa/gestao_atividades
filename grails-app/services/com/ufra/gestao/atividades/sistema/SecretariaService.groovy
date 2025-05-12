package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.enums.TipoGenero
import grails.gorm.transactions.Transactional

@Transactional
class SecretariaService {

    /**
     * Salva ums intancia de secretaria
     * @param nome
     * @param cpf
     * @param rg
     * @param email
     * @param nascimento
     * @param genero
     * @return
     */
    Secretaria save(String nome, String cpf, String rg, String email, Date nascimento, TipoGenero genero){
        save([
                nome: nome,
                cpf: cpf,
                rg: rg,
                email: email,
                dataNascimento: nascimento,
                genero: genero
        ])
    }

    /**
     * Salva ums intancia de secretaria
     * @param nome
     * @param cpf
     * @param rg
     * @param email
     * @param nascimento
     * @param genero
     * @return
     */
    Secretaria save(Map params) {
        Secretaria secretaria = params.id ? Secretaria.get(params.long('id')): new Secretaria()
        secretaria.properties = params
        secretaria.save(flush: true, failOnError: true)
    }
}

