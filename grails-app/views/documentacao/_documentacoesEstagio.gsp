<g:if test="${documentacoes}">
    <table class="table table-striped table-bordered table-hover text-center">
        <thead>
        <tr>
            <td>Data de Cadastro</td>
            <th>Nome</th>
            <th>Status</th>
            <th>Opções</th>
        </tr>
        </thead>
        <tbody>
        <g:each var="documentacao" in="${documentacoes}">
            <tr>
                <td>${documentacao?.dateCreated.format('dd/MM/yyyy')}</td>
                <td>${documentacao?.nome}</td>
                <td>${documentacao?.statusEstagio}</td>
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