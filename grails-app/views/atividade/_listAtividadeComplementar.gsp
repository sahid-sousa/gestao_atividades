<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Nome</th>
        <th>Carga Horária</th>
        <th>Carga Horária Aprovada</th>
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
                ${categoria.categoriaAtividade.cargaHoraria}
            </td>
            <td>
                ${categoria?.cargaHorariaTotal}
            </td>
        </tr>
    </g:each>
    </tbody>
</table>