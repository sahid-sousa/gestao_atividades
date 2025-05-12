<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>Perfil</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper">
    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">Meus Dados</h1>
        </div>
        <g:if test='${flash.message}'>
            <div class='alert alert-warning'>
                <strong>${flash.message}</strong>
            </div>
        </g:if>
    <!--End Page Header -->
    </div>

</div>
<!-- end page-wrapper -->
</body>
</html>