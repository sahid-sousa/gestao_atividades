import grails.util.Environment
server.contextPath = '/gestao'
grails.databinding.dateFormats = ['MMddyyyy', 'yyyy-MM-dd HH:mm:ss.S', "yyyy-MM-dd'T'hh:mm:ss'Z'", "dd/MM/yyyy", "dd/MM/yyyy HH:mm"]
grails.plugin.console.enable = true
grails.plugin.console.csrfProtection.enabled = false
grails.server.port.http = 8089

notificacao.mail.from = System.getenv('MAIL_NOTIFICATION') ?: ''
upload.folder = "${System.getProperty('user.home')}/upload/"

// Added by the Spring Security Core plugin:

grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.ufra.gestao.atividades.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.ufra.gestao.atividades.security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.ufra.gestao.atividades.security.Role'
grails.plugin.springsecurity.logout.postOnly = false

asynchronous.mail.default.attempt.interval=300000l      // Five minutes
asynchronous.mail.default.max.attempts.count=1
asynchronous.mail.send.repeat.interval=60000l           // One minute
asynchronous.mail.expired.collector.repeat.interval=607000l
asynchronous.mail.messages.at.once=100
asynchronous.mail.send.immediately=true
asynchronous.mail.clear.after.sent=false
asynchronous.mail.disable=false
asynchronous.mail.useFlushOnSave=true
asynchronous.mail.persistence.provider='hibernate'     // Possible values are 'hibernate', 'hibernate4', 'mongodb'
asynchronous.mail.newSessionOnImmediateSend=false
asynchronous.mail.taskPoolSize=1

def smptHost     = System.getenv('SMTP_HOST') ?: ''
def smptPort     = System.getenv('SMTP_PORT') ?: ''
def smptUsername = System.getenv('SMTP_USERNAME') ?: ''
def smptPassword = System.getenv('SMTP_PASSWORD') ?: ''

grails {
    mail {
        host = smptHost
        port = smptPort
        username = smptUsername
        password = smptPassword
        props = ['mail.smtp.auth'                  : 'true',
                 'mail.smtp.socketFactory.port'    : smptPort,
                 'mail.smtp.socketFactory.class'   : 'javax.net.ssl.SSLSocketFactory',
                 'mail.smtp.socketFactory.fallback': 'false']
    }
}

def staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/recuperar.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/telaPrincipal/index', access: ['permitAll']],
        [pattern: '/recuperarSenha/**', access: ['permitAll']],
        [pattern: '/cadastro/create', access: ['permitAll']],
        [pattern: '/cadastro/save', access: ['permitAll']],
        [pattern: '/cadastro/ativar', access: ['permitAll']],
        [pattern: '/cadastro/confirmarConta', access: ['permitAll']],
        [pattern: '/recuperarSenha/redefinir', access: ['permitAll']],
        [pattern: '/aluno/save', access: ['permitAll']],
        [pattern: '/aluno/index', access: ['ROLE_USER']],
        [pattern: '/secretaria/**', access: ['ROLE_SECRETARIA']],
        [pattern: '/documento/**', access: ['ROLE_USER']],
        [pattern: '/documentacao/**', access: ['ROLE_USER']],
        [pattern: '/atividade/show', access: ['ROLE_USER']],
        [pattern: '/usuario/**', access: ['ROLE_USER', 'ROLE_SECRETARIA', 'ROLE_ADMIN', 'ROLE_SUPORTE']]

]

if(Environment.isDevelopmentMode()){
    staticRules << [pattern: '/console/**', access: ['permitAll']]
    staticRules << [pattern: '/static/console/**', access: ['permitAll']]
}else{
    staticRules << [pattern: '/console/**', access: ['ROLE_SUPORTE']]
    staticRules << [pattern: '/static/console/**', access: ['ROLE_SUPORTE']]
}

grails.plugin.springsecurity.controllerAnnotations.staticRules = staticRules
grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

