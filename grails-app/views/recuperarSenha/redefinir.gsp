<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recuperar Senha</title>
    <asset:stylesheet src="application.css" />
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
                    <h3 class="panel-title">${user?.id ? 'Informe uma nova senha' : 'Aviso'}</h3>
                </div>
                <div class="panel-body">
                    <g:if test='${flash.message}'>
                        <div class='alert alert-danger'>
                            <strong>${flash.message}</strong>
                        </div>
                        <g:link controller="login" class="text-uppercase btn btn-lg btn-info btn-block" action="auth">
                            Voltar
                        </g:link>
                    </g:if>
                    <g:else>
                        <g:if test="${flash.error}">
                            <div class='alert alert-danger'>
                                <strong>${flash.error}</strong>
                            </div>
                        </g:if>
                        <g:form name="form-rsenha" controller="recuperarSenha" action='alterarSenha' method="POST">
                            <g:hiddenField name="id" value="${user?.id}"/>
                            <div class="form-group">
                                <input type="password"
                                       placeholder="Senha"
                                       name='password' id='password'
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="password"
                                       placeholder="Confirmar senha"
                                       name='passwordconfirm' id='passwordconfirm'
                                       class="form-control form-control--placeholder">
                            </div>
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Alterar"/>
                            <g:link controller="login" class="text-uppercase btn btn-lg btn-light btn-block" action="auth">
                                Voltar
                            </g:link>
                            </fieldset>
                        </g:form>
                    </g:else>
                </div>
            </div>
        </div>
    </div>
</div>
<asset:javascript src="application.js"/>
</body>
</html>