package gestao.atividades

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'telaPrincipal', action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
