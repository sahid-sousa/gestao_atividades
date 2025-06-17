package gestao.atividades

import com.ufra.gestao.atividades.enums.TipoGenero
import com.ufra.gestao.atividades.security.Role
import com.ufra.gestao.atividades.security.User
import com.ufra.gestao.atividades.sistema.AtividadeComplementar
import com.ufra.gestao.atividades.sistema.CategoriaAtividade
import com.ufra.gestao.atividades.sistema.Estado
import com.ufra.gestao.atividades.sistema.EstagioSupervisionado
import com.ufra.gestao.atividades.sistema.Pessoa
import grails.core.GrailsApplication

class BootStrap {

    def userService
    def secretariaService
    def documentoService
    GrailsApplication grailsApplication

    def init = { servletContext ->
        documentoService.criaDiretorioUpload()
        Role.init()
        Estado.init()
        EstagioSupervisionado.init()
        AtividadeComplementar.init()
        if(!CategoriaAtividade.list()){
            CategoriaAtividade.init()
        }
        if (!User.findByUsername('secretaria')) {
            def nascimento = new Date().parse("dd/MM/yyyy", '19/08/1997')
            Pessoa pessoa = secretariaService.save('Elza Lara Brenda Rocha', '774.329.537-08', '48.216.901-1', 'elza.rocha@email.com', nascimento, TipoGenero.FEMININO)
            userService.createUser('secretaria', pessoa,'123456', ['ROLE_SECRETARIA'], true)
        }
    }
    def destroy = {
    }
}
