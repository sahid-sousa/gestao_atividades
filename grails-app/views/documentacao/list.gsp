<%@ page import="com.ufra.gestao.atividades.sistema.*; com.ufra.gestao.atividades.enums.*" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>Documentos ${categoria.categoriaAtividade}</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper" data-run="operacoesDocumentacao" >
    <g:hiddenField name="url-delete-documentacao" value="${createLink(controller: 'documentacao', action: 'deleteDocumentacao')}" />
    <g:hiddenField name="url-get-documentacao" value="${createLink(controller: 'documentacao', action: 'getDocumentacao')}"/>
    %{--<g:hiddedField name="url-update" value="" />--}%
    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">${categoria.categoriaAtividade}</h1>
        </div>
        <!--End Page Header -->
    </div>
    <g:if test='${flash.error}'>
        <div class="row">
            <div class="col-lg-12">
                <div class='alert alert-warning'>
                    <button type="button" class="close" onclick="$('.alert-warning').hide()">&times;</button>
                    <strong>${flash.error}</strong>
                </div>
            </div>
        </div>
    </g:if>
    <g:link url="${createLink(controller: 'atividade', action: 'show', id: categoria.categoriaAtividade.atividade.id)}"  class="btn btn-primary"> Categorias da Atividade </g:link>
    <button href="#" class="btn btn-success" onclick="cadastrarDocumentacao()"> Cadastrar Documentação </button>
    <br />
    <br />
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Documentação
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-12 div-table">
                    <g:if test="${categoria instanceof CategoriaAtividadeAlunoAtic}">
                        <g:render template="documentacoesAtividade" model="[documentacoes: documentacoes, countDocumentacao: countDocumentacao]"/>
                    </g:if>
                    <g:else>
                        <g:render template="documentacoesEstagio" model="[documentacoes: documentacoes, countDocumentacao: countDocumentacao]"/>
                    </g:else>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- Modal -->
    <g:render template="modalForm" model="[user : user, categoria: categoria]"/>
    <!-- /.Modal -->
</div>

</div>
<!-- end page-wrapper -->
</body>
</html>