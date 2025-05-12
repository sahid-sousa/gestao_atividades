<%@ page import="com.ufra.gestao.atividades.enums.TipoGenero" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirma Cadastro</title>
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
                    <h3 class="panel-title">Confirmar Cadastro</h3>
                </div>
                <div class="panel-body">
                    <g:if test='${flash.message}'>
                        <div class='alert alert-danger'>
                            <strong>${flash.message}</strong>
                        </div>
                        <g:link controller="login" class="btn btn-lg btn-info btn-block" action="auth">
                            Voltar
                        </g:link>
                    </g:if>
                    <g:else>
                        <div class='alert alert-success'>
                            <p><strong>Estamos quase lá!</strong></p>
                            <p><strong>Clique no botão abaixo para confirma o seu cadastro!</strong></p>
                        </div>
                        <g:form controller="cadastro" action="confirmarConta" method="POST">
                            <fieldset>
                                <g:hiddenField name="id" value="${user.id}"/>
                                <g:submitButton name="confirmar" class="btn btn-lg btn-info btn-block" value="Confirmar Cadastro"/>
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