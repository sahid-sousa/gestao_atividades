<g:if test="${documentos}">
    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped text-center">
            <thead>
            <tr>
                <th>Data de Cadastro</th>
                <th>Nome do Arquivo</th>
                <th>Documentação</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="documento" in="${documentos}">
                <tr>
                    <td><g:formatDate format="dd/MM/yyyy" date="${documento.dateCreated}"/></td>
                    <td>${documento.originalFileName}</td>
                    <td>${documento.documentacao.nome}</td>
                    <td>
                        <div class="btn-group">
                            <g:link title="Download" class="btn btn-success fa fa-download" controller="secretaria" action="download" id="${documento?.id}" />
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</g:if>
<g:else>
    <div class="alert alert-info text-center">
        <span>SEM DOCUMENTOS CADASTRADOS</span>
    </div>
</g:else>