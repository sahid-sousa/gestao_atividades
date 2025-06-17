<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>Atividade Complementar</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper">
    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">Documentos Atividade Complementar</h1>
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
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i class="fa fa-search fa-fw"></i> Pesquisar
        </div>
        <g:form controller="secretaria" action="atividadeComplementarList">
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12 div-table">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <g:textField name="aluno" class="form-control" placeholder="Nome do Aluno" value="${params.aluno}"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <g:textField name="nome" class="form-control" placeholder="Nome da Documentação" value="${params.nome}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer text-right">
                <div class="btn-group">
                    <g:submitButton name="btn-search" class="btn btn-success" value="Buscar"/>
                </div>
            </div>
        </g:form>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Documentações
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-12 div-table">
                    <g:if test="${documentacoes}">
                        <table class="table table-striped table-bordered table-hover text-center">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Aluno</th>
                                <th>Data de Cadastro</th>
                                <th>Data do Evento</th>
                                <th>Carga Horária</th>
                                <th>Documentação</th>
                                <th>Status</th>
                                <th>Opções</th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each var="documentacao" in="${documentacoes}">
                                <tr>
                                    <td>${documentacao?.nome}</td>
                                    <td>${documentacao.pessoa.nome}</td>
                                    <td><g:formatDate format="dd/MM/yyyy" date="${documentacao?.dateCreated}"/></td>
                                    <td><g:formatDate format="dd/MM/yyyy" date="${documentacao?.dataEvento}"/></td>
                                    <td>${documentacao?.cargaHoraria}h</td>
                                    <td>${documentacao?.tipoAtividade}</td>
                                    <td>${documentacao?.statusDocumentacao}</td>
                                    <td>
                                        <div class="btn-group">
                                            <g:link title="Visualizar" class="btn btn-primary fa fa-eye" controller="secretaria" action="showAtividadeComplementar" id="${documentacao?.id}" />
                                            <g:link title="Editar" class="btn btn-success fa fa-pencil" controller="secretaria" action="editarAtividadeComplementar" id="${documentacao.id}" />
                                        </div>
                                    </td>
                                </tr>
                            </g:each>
                            </tbody>
                        </table>
                        <g:paginate controller="documentacao" action="list" total="${countDocumentacao}" />
                    </g:if>
                    <g:else>
                        <div class="alert alert-info text-center">
                            <p>SEM DOCUMENTA&Ccedil;&Atilde;O</p>
                            <p>
                                <g:link action="atividadeComplementarList">
                                    CLIQUE AQUI PARA RECARREGAR
                                </g:link>
                            </p>
                        </div>
                    </g:else>

                </div>
            </div>
        </div>
    </div>

</div>
<!-- end page-wrapper -->
</body>
</html>