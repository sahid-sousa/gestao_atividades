<%@ page import="com.ufra.gestao.atividades.enums.*" %>
<g:form controller="documentacao" action="salvarAtividadeEstagioSupervisionado" name="form-estagio">
    <g:hiddenField name="documentacaoId" value=""/>
    <g:hiddenField name="pessoa" value="${user?.pessoa?.id}"/>
    <g:hiddenField name="categoriaAtividadeAluno" value="${categoria?.id}"/>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
    </div>
    <div class="modal-body">
        <div class="form-group">
            <label for="nome" class="control-label">Documento *</label>
            <g:select name="nome" class="form-control" from="${TipoDocumentoEstagio.values()}"
                      optionValue="descricao" optionKey="key" required=""
                      noSelection="['':'Escolha uma das opções...']"/>
        </div> <!-- /. form-group -->
    </div> <!-- modal-body -->
    <div class="modal-footer">
        <g:submitButton name="Salvar" class="btn btn-success" />
        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
    </div> <!-- /. modal-footer -->
</g:form>