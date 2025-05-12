package com.ufra.gestao.atividades.security


import grails.gorm.transactions.Transactional

@Transactional
class EnviarEmailService {

    def grailsApplication
    def asynchronousMailService

    /**
     * Envia um email com link um de ativação de conta
     * @param para
     * @param link
     * @return
     */

    def emailConfirmacaoConta(String para, String link) {
        String apartir = grailsApplication.config.notificacao.mail.from
        asynchronousMailService.sendAsynchronousMail {
            to para
            from apartir
            subject 'Confirmação de Conta'
            html "<div class='text-center'> </br> </br> <p>Olá!, Seja bem vindo;,</br> </p> <p> para prosseguir e ativar a sua conta clique no link que se encontra logo abaixo!. </p> </br> <div> <a href='${link}'>Clique aqui para confirmar a sua conta!</a> </div> </br> </br> </br> </br> </div>"
            delete true   // Marks the message for deleting after sent
            immediate true    // Run the send job after the message was created
            priority 10   // If priority is greater then message will be sent faster
        }
    }

    /**
     * Envia um email com um link para a recuperação de senha da conta
     * @param para
     * @param link
     * @return
     */

    def emailRecuperarSenha(String para, String link) {
        String apartir = grailsApplication.config.notificacao.mail.from
        asynchronousMailService.sendAsynchronousMail {
            to para
            from apartir
            subject 'Redefinir Senha'
            html "<div class='text-center'> </br> </br> <p>Olá!;,</br> </p> <p> Para redefinir a sua senha clique no link que se encontra logo abaixo!. </p> </br> <div> <a href='${link}'>Clique aqui para redefinir a sua senha!</a> </div> </br> </br> </br> </br> </div>"
            delete true   // Marks the message for deleting after sent
            immediate true    // Run the send job after the message was created
            priority 10   // If priority is greater then message will be sent faster
        }
    }


}
