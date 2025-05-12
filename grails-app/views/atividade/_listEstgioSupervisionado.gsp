<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Status</th>
        <th>Carga Horária</th>
    </tr>
    </thead>
    <tbody>
    <g:each var="categoria" in="${categorias}">
        <tr>
            <td>
                <a href="${createLink(controller: 'documentacao', action: 'list', id: "${categoria.id}")}">
                    ${categoria.categoriaAtividade.nome}
                </a>
            </td>
            <td>
                ${categoria?.statusEstagioSupervisionado}
            </td>
            <td>
                ${categoria.categoriaAtividade.cargaHoraria}
            </td>
        </tr>
    </g:each>
    </tbody>
</table>