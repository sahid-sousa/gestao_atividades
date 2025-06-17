<!doctype html>
<html>
<head>
    <title>Page Not Found</title>
    <asset:stylesheet src="application.css"/>
</head>

<body class="bg-body">
<g:if env="development">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>Oops!</h1>

                    <h2>404 Não Encontrado</h2>

                    <div class="error-details">
                        Desculpe, ocorreu um erro, a página solicitada não foi encontrada!
                    </div>

                    <div class="error-actions">
                        <ul class="list-group">
                            <li class="list-group-item list-group-item-danger">Error: Page Not Found (404)</li>
                            <li class="list-group-item list-group-item-danger">Path: ${request.forwardURI}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</g:if>
<g:else>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>Oops!</h1>

                    <h2>404 Não Encontrado</h2>

                    <div class="error-details">
                        Desculpe, ocorreu um erro, a página solicitada não foi encontrada!
                    </div>

                    <div class="error-actions">
                        <a href="http://www.jquery2dotnet.com" class="btn btn-primary btn-lg"><span
                                class="glyphicon glyphicon-home"></span>
                            Take Me Home</a><a href="http://www.jquery2dotnet.com" class="btn btn-default btn-lg"><span
                            class="glyphicon glyphicon-envelope"></span> Contact Support</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</g:else>
</body>
</html>
