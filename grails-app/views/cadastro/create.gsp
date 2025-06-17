<%@ page import="com.ufra.gestao.atividades.enums.TipoGenero" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <asset:stylesheet src="application.css" />
</head>
<body class="body-Login-back">
<g:hiddenField name="url-login" value="${createLink(controller: 'login', action: 'auth')}"/>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center logo-margin ">
            %{--<img src="${assetPath(src:'logo.png')}" alt="Logo"/>--}%
        </div>
        <div class="col-md-4 col-md-offset-4" data-run="operacoesCadastro">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Cadastro</h3>
                </div>
                <div class="panel-body">
                    <g:if test='${flash.message}'>
                        <div class='alert alert-info'>${flash.message}</div>
                    </g:if>
                    <form action="${createLink(controller: 'cadastro', action: 'save')}" method="POST" id="form-cadastro" name="form-cadastro">
                        <fieldset>
                            <div class="form-group">
                                <input type="text"
                                       placeholder="Matrícula"
                                       name='matricula' id='matricula'
                                       minlength="5"
                                       required="required"
                                       value="${params.matricula}"
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="text"
                                       placeholder="Nome"
                                       name='nome' id='nome'
                                       required="required"
                                       minlength="10"
                                       value="${params.nome}"
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <div class="form-group">
                                <g:select name="genero" class="form-control"
                                          required="required"
                                          noSelection="['': 'Sexo']"
                                          value="${params.genero}"
                                          from="${TipoGenero.values()}"/>
                            </div>
                            <div class="form-group">
                                <input type="email"
                                       placeholder="Email"
                                       name='email' id='email'
                                       required="required"
                                       value="${params.email}"
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="password"
                                       placeholder="Senha"
                                       name='password' id='password'
                                       required="required"
                                       minlength="6"
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="password"
                                       placeholder="Confirmar Senha"
                                       required="required"
                                       name='confirmarpassword' id='confirmarpassword'
                                       minlength="6"
                                       class="form-control form-control--placeholder">
                            </div>
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="cadastrar($('#form-cadastro'))">
                                Cadastrar
                            </button>
                            <g:link controller="login" class="btn btn-lg btn-light btn-block" action="auth">
                                Voltar
                            </g:link>
                        </fieldset>
                        <form>
                </div>
            </div>
        </div>
    </div>
</div>
<asset:javascript src="application.js"/>
</body>
</html>