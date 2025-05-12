<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
                    <h3 class="panel-title">Login</h3>
                </div>
                <div class="panel-body">
                    <g:if test='${flash.message}'>
                        <div class='alert alert-danger'>
                            <strong>${flash.message}</strong>
                        </div>
                    </g:if>
                    <form id="formLogin" action='${postUrl}' method="POST">
                        <fieldset>
                            <div class="form-group">
                                <input type="text"
                                       placeholder="Username"
                                       name='username' id='username'
                                       required="required"
                                       value="${request.remoteUser}"
                                       class="form-control form-control--placeholder" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="password"
                                       placeholder="Senha"
                                       name='password' id='password'
                                       required="required"
                                       class="form-control form-control--placeholder">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember-me" id="remember_me"
                                           <g:if test='${hasCookie}'>checked="checked"</g:if>
                                           type="checkbox" value="Remember Me">Lembrar
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Acessar"/>
                            <g:link controller="cadastro" class="text-uppercase btn btn-lg btn-info btn-block" action="create">
                                Cadastro
                            </g:link>
                            <g:link controller="recuperarSenha" class="text-uppercase btn btn-lg btn-light btn-block" action="recuperar">
                                Esqueci minha senha
                            </g:link>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<asset:javascript src="application.js"/>

<g:if test="${params.open}">
    <script>
        msgCadastro();
    </script>
</g:if>

<script type='text/javascript'>
    <!--
    (function(){
        document.forms['formLogin'].elements['username'].focus();
    })();
    // -->
</script>
</body>
</html>