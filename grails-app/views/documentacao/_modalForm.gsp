<%@ page import="com.ufra.gestao.atividades.sistema.CategoriaAtividadeAlunoAtic" %>
<div class="modal fade" id="mdDocumentacao" data-backdrop="static" data-keyboard="false" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <g:if test="${categoria instanceof CategoriaAtividadeAlunoAtic}">
                <g:render template="formAtividadeComplementar" model="[user : user, categoria: categoria]"/>
            </g:if>
            <g:else>
                <g:render template="formEstagioSupervisionado" model="[user : user, categoria: categoria]"/>
            </g:else>
        </div> <!-- /. modal-content -->
    </div> <!-- /. modal-dialog -->
</div>