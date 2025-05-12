<%@ page import="com.ufra.gestao.atividades.sistema.DocumentacaoAtividadeComplementar" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="layout_main"/>
    <title>${documentacao.nome}</title>
</head>
<body>
<!--  page-wrapper -->
<div id="page-wrapper" data-run="operacoesDocumento">
    <g:hiddenField name="urlDeleteArquivo" value="${createLink(controller: 'documentacao', action: 'deleteArquivo')}" />
    <g:hiddenField name="urlDeleteDocumentacao" value="${createLink(controller: 'documentacao', action: 'delete')}"/>
    <g:hiddenField name="url-get-documentacao" value="${createLink(controller: 'documentacao', action: 'getDocumentacao')}"/>
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
    <g:link url="${createLink(controller: 'documentacao', action: 'list', id: documentacao.categoriaAtividadeAluno.id)}"  class="btn btn-primary"> Listagem de Documentação</g:link>
    <br/>
    <br/>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Documentos
        </div>
        <!-- panel-body -->
        <div class="panel-body">
            <!-- row -->
            <div class="row">
                <div class="col-sm-12">
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Data de Cadastro:</strong> ${documentacao.dateCreated.format('dd/MM/YYYY')}</li>
                        <li class="list-group-item"><strong>Nome:</strong> ${documentacao.nome}</li>
                        <g:if test="${documentacao instanceof DocumentacaoAtividadeComplementar}">
                            <li class="list-group-item"><strong>Data do Evento:</strong> <g:formatDate format="dd/MM/yyyy" date="${documentacao.dataEvento}"/></li>
                            <li class="list-group-item"><strong>Documentação:</strong> ${documentacao?.tipoAtividade}</li>
                            <li class="list-group-item"><strong>Carga Horária: </strong> ${documentacao?.cargaHoraria}</li>
                        </g:if>
                        <li class="list-group-item list-group-item-info"><strong>Status:</strong> ${documentacao.statusDocumentacao}</li>
                    </ul>
                </div>
                <g:if test="${documentacao instanceof DocumentacaoAtividadeComplementar}">
                    <div class="col-sm-12">
                        <div class="panel panel-info">
                            <div class="panel-heading">Descri&ccedil;&atilde;o</div>
                            <div class="panel-body">${documentacao.descricao}</div>
                        </div>
                    </div>
                </g:if>
                <g:if test="${documentacao?.comentario}">
                    <div class="col-sm-12">
                        <div class="panel panel-warning">
                            <div class="panel-heading">Comentário</div>
                            <div class="panel-body">${documentacao.comentario}</div>
                        </div>
                    </div>
                </g:if>
                <div class="col-lg-12 div-table">
                    <g:render template="documentos" model="[documentos: documentos, documentacao: documentacao, countDocumentos: countDocumentos]" />
                </div>

                <div class="col-sm-12">
                    <button href="#" class="btn btn-success" data-toggle="modal" data-target="#mdSaveDocumento"> Adicionar Documentos </button>
                    <button type="button" class="btn btn-warning" onclick="editarDocumentacao(${documentacao.id})"> Editar </button>
                    <button type="button" class="btn btn-danger" onclick="deleteRegistroDocumentacao(${documentacao.id})"> Excluir </button>
                </div>
            </div>
            <!-- /.row -->
            <!-- Modal -->
            <div class="modal fade" id="mdSaveDocumento" data-backdrop="static" data-keyboard="false" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Enviar Documentos</h4>
                        </div>
                        <g:uploadForm controller="documentacao" action="upload" method="post" name="upload-from">
                            <g:hiddenField name="idDocumentacao" value="${documentacao.id}" />
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="file">Selecione os Arquivos</label>
                                    <input type="file" id="file" name="file" class="form-control" multiple>
                                </div>
                                <span class="help-block">
                                    Selecione um ou mais arquivos para efetuar upload.
                                </span>
                            </div> <!-- modal-body -->
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success" id="btn_upload">Enviar Arquivos</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                            </div> <!-- /. modal-footer -->
                        </g:uploadForm><!-- form -->
                    </div> <!-- /. modal-content -->
                </div> <!-- /. modal-dialog -->
            </div><!-- /.Modal -->
        <!-- Modal -->
        <g:render template="modalForm" model="[user : user, categoria: documentacao.categoriaAtividadeAluno]" />
        <!-- /.Modal -->
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- end page-wrapper -->
</body>
</html>