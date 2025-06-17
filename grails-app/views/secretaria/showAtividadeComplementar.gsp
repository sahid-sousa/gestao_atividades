<%@ page import="com.ufra.gestao.atividades.enums.StatusDocumentacao" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>${documentacao.nome}</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper">
    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">${documentacao.nome}</h1>
        </div>
        <!--End Page Header -->
    </div>
    <g:if test='${flash.message}'>
        <div class="row">
            <div class="col-sm-12">
                <div class='alert alert-info'>
                    <button type="button" class="close" onclick="$('.alert-info').hide()">&times;</button>
                    <strong>${flash.message}</strong>
                </div>
            </div>
        </div>
    </g:if>
    <g:if test='${flash.error}'>
        <div class="row">
            <div class="col-sm-12">
                <div class='alert alert-danger'>
                    <button type="button" class="close" onclick="$('.alert-danger').hide()">&times;</button>
                    <strong>${flash.error}</strong>
                </div>
            </div>
        </div>
    </g:if>
    <g:link url="${createLink(controller: 'secretaria', action: 'atividadeComplementarList')}"  class="btn btn-primary"> Listagem de Documentação</g:link>
    <br/>
    <br/>
    <div class="panel panel-primary">
        <div class="panel-heading">
            Documentacão ${documentacao.nome}
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-12">
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Matrícula:</strong> ${documentacao.pessoa.matricula}</li>
                        <li class="list-group-item"><strong>Aluno:</strong> ${documentacao.pessoa.nome}</li>
                        <li class="list-group-item"><strong>Nome:</strong> ${documentacao.nome}</li>
                        <li class="list-group-item"><strong>Data de Cadastro:</strong> ${documentacao.dateCreated.format('dd/MM/YYYY')}</li>
                        <li class="list-group-item"><strong>Data do Evento:</strong> <g:formatDate format="dd/MM/yyyy" date="${documentacao.dataEvento}"/></li>
                        <li class="list-group-item"><strong>Documentação:</strong> ${documentacao?.tipoAtividade}</li>
                        <li class="list-group-item"><strong>Carga Horária: </strong> ${documentacao?.cargaHoraria}</li>
                        <li class="list-group-item list-group-item-info"><strong>Status:</strong> ${documentacao.statusDocumentacao}</li>
                    </ul>
                </div>
                <div class="col-sm-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">Descri&ccedil;&atilde;o</div>
                        <div class="panel-body">${documentacao.descricao}</div>
                    </div>
                </div>
                <div class="col-lg-12 div-table">
                    <g:render template="documentos" model="[documentos: documentacao.documentos]"/>
                </div>
                <div class="col-sm-12">
                    <button href="#" class="btn btn-success" data-toggle="modal" data-target="#mdEditarDocumento"> Editar Documentação</button>
                </div>
                <div class="modal fade" id="mdEditarDocumento" data-backdrop="static" data-keyboard="false" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <g:form controller="secretaria" action="update" method="POST"><!-- g:form -->
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">${documentacao.nome}</h4>
                                </div>
                                <div class="modal-body">
                                    <g:hiddenField name="idDocumentacao" value="${documentacao?.id}"/>
                                    <div class="form-group">
                                        <label for="statusDocumentacao" class="control-label">Status da Documentacao *</label>
                                        <g:select  class="form-control" from="${StatusDocumentacao.secretaria()}"
                                                  name="statusDocumentacao"
                                                  value="${documentacao.statusDocumentacao}"
                                                  optionKey="key"
                                                  optionValue="descricao" />
                                    </div> <!-- /. form-group -->
                                    <div class="form-group">
                                        <label for="comentario" class="control-label">Descrição *</label>
                                        <g:textArea name="comentario" class="form-control" required="" value="${documentacao?.comentario}"/>
                                    </div> <!-- /. form-group -->
                                </div> <!-- modal-body -->
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-success" id="btn_upload">Salvar</button>
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                </div>
                            </g:form><!-- /. g:form -->
                        </div><!-- /. modal-content -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end page-wrapper -->
</body>
</html>