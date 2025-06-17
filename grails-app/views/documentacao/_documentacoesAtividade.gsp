<g:if test="${documentacoes}">
    <table class="table table-striped table-bordered table-hover text-center">
        <thead>
        <tr>
            <th>Data de Cadastro</th>
            <th>Nome</th>
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
                <td><g:formatDate format="dd/MM/yyyy" date="${documentacao?.dateCreated}"/></td>
                <td>${documentacao?.nome}</td>
                <td><g:formatDate format="dd/MM/yyyy" date="${documentacao?.dataEvento}"/></td>
                <td>${documentacao?.cargaHoraria}h</td>
                <td>${documentacao?.tipoAtividade}</td>
                <td>${documentacao?.statusDocumentacao}</td>
                <td>
                    <div class="btn-group">
                        <g:link title="Visualizar" class="btn btn-primary fa fa-eye" controller="documentacao" action="show" id="${documentacao?.id}" />
                        <button type="button" class="btn btn-success fa fa-pencil" onclick="editarDocumentacao(${documentacao?.id})"></button>
                        <button type="button" class="btn btn-danger fa fa-trash-o" onclick="deleteRegistro(${documentacao?.id})"></button>
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
        <span>SEM DOCUMENTA&Ccedil;&Atilde;O CADASTRADA</span>
    </div>
</g:else>