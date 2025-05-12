<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recuperar Senha</title>
    <asset:stylesheet src="bootstrap.css" />
    <asset:stylesheet src="font-awesome/css/font-awesome.css" />
    <asset:stylesheet src="pace-theme-big-counter.css" />
    <asset:stylesheet src="style.css" />
    <asset:stylesheet src="main-style.css" />
</head>
<body class="body-Login-back">

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center logo-margin ">
            %{--<img src="${assetPath(src:'logo.png')}" alt="Logo"/>--}%
        </div>
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Recupere sua senha</h3>
                </div>
                <div class="panel-body">
                    <g:if test='${flash.message}'>
                        <div class='alert alert-danger'>
                            <strong>${flash.message}</strong>
                        </div>
                    </g:if>
                    <g:form name="form-rsenha" controller="recuperarSenha" action='conferirDados' method="POST">
                        <fieldset>
                            <div class="form-group">
                                <input type="email"
                                       placeholder="Infome o email cadastrado no sistema"
                                       name='email' id='email'
                                       required="required"
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <g:submitButton name="btn-recuperar"
                                            class="btn btn-lg btn-success btn-block"
                                            value="Recuperar"/>
                            <g:link controller="login" class="btn btn-lg btn-light btn-block" action="auth">
                                Voltar
                            </g:link>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>
<asset:javascript src="application.js"/>
</body>
</html>