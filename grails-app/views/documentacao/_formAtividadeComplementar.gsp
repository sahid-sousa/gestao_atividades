<%@ page import="com.ufra.gestao.atividades.enums.*" %>
<!doctype html>
<g:form controller="documentacao" action="salvarAtividadeComplementar" name="form-atividade">
    <g:hiddenField name="documentacaoId" value=""/>
    <g:hiddenField name="pessoa" value="${user?.pessoa?.id}"/>
    <g:hiddenField name="categoriaAtividadeAluno" value="${categoria?.id}"/>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
    </div>
    <div class="modal-body">
        <div class="form-group">
            <label for="dataEvento" class="control-label">Data do Evento *</label>
            <g:textField name="dataEvento" class="form-control date" required=""/>
        </div> <!-- /. form-group -->

        <div class="form-group">
            <label class="control-label" for="nome">Nome*</label>
            <g:textField name="nome" class="form-control" required=""/>
        </div> <!-- /. form-group -->

        <div class="form-group">
            <label for="descricao" class="control-label">Descrição *</label>
            <g:textArea name="descricao" class="form-control" required=""/>
        </div> <!-- /. form-group -->

        <div class="form-group">
            <label for="tipoDocumentacao" class="control-label">Tipo da Documentação *</label>
            <g:select name="tipoDocumentacao" class="form-control" from="${TipoAtividadeComplementar.values()}"
                      optionValue="descricao" optionKey="key" required=""
                      noSelection="['':'Escolha uma das opções...']"/>
        </div> <!-- /. form-group -->

        <div class="form-group">
            <label for="cargaHoraria" class="control-label">Carga Horária *</label>
            <g:field type="number" name="cargaHoraria" min="1" value="1" class="form-control" required=""/>
        </div>

    </div> <!-- modal-body -->
    <div class="modal-footer">
        <g:submitButton name="Salvar" class="btn btn-success" />
        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
    </div> <!-- /. modal-footer -->
</g:form>