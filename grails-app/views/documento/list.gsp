<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>Documentos ${categoria.categoriaAtividade}</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper">
    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">Documentos ${categoria.categoriaAtividade}</h1>
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
    <g:link url="${createLink(controller: 'atividade', action: 'show', id: categoria.categoriaAtividade.atividade.id)}"  class="btn btn-primary"> Categorias da Atividade </g:link>
    <a href="#" class="btn btn-success"> Adicionar Documentos </a>
    <br />
    <br />
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Documentos
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-12">
                    <g:if test="${documentos}">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each var="documento" in="${documentos}">
                                    <td>${documento.nome}</td>
                                    <td>${documento.statusDocumento}</td>
                                </g:each>
                                </tbody>
                            </table>
                        </div>
                    </g:if>
                    <g:else>
                        <center>
                            <span class="text-center">SEM DOCUMENTOS CADASTRADOS</span>
                        </center>
                    </g:else>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.panel-body -->
    </div>

</div>
<!-- end page-wrapper -->
</body>
</html>