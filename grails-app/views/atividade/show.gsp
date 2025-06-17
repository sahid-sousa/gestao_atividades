<%@ page import="com.ufra.gestao.atividades.sistema.*" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>Inicio</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper">
    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">${atividade.nome}</h1>
        </div>
        <!--End Page Header -->
    </div>
    <g:if test='${flash.message}'>
        <div class="row">
            <div class="col-lg-12">
                <div class='alert alert-warning'>
                    <strong>${flash.message}</strong>
                </div>
            </div>
        </div>
    </g:if>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Categorias da Atividade
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <g:if test="${atividade instanceof AtividadeComplementar}">
                            <g:render template="listAtividadeComplementar" model="[categorias: categorias]"/>
                        </g:if>
                        <g:else>
                            <g:render template="listEstgioSupervisionado" model="[categorias: categorias]"/>
                        </g:else>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- end page-wrapper -->
</body>
</html>