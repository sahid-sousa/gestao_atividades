// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap.min.js
//= require jquery.mask.js
//= require masks.js
//= require jquery.validate.min.js
//= require  jquery-validation-messages.js
//= require bootstrap-waitingfor.min.js
//= require dropzone.js
//= require_tree .
//= require_self

App.modules.operacoesCadastro = function () {
    function validarFomularioCadastro(form) {
        form.validate({
            submitHandler: cadastrar(form)
        });
    }

    function cadastrar(form) {
        var url = form.attr('action');
        var method = form.attr('method');
        if(!form.valid()){ return false }
        $.ajax({
            type: method,
            url: url,
            data: form.serialize(), // serializes the form's elements.
            success: function(response){
                if(response.status){
                    swal(response.title, response.text, "success", {
                        button: "OK",
                    }).then(function() {
                        window.location.href = response.url;
                    });
                }else{
                    swal(response.title, response.text, "warning", {
                        button: "OK",
                    }).then(function() {
                        console.log("teste")
                    });
                }
            }
        });
        return false;
    }
    window.validarFomularioCadastro = validarFomularioCadastro;
    window.cadastrar = cadastrar;
};

App.modules.operacoesDocumento = function (){
    function deleteRegistroArquivo(idDoc, idDocumentacao) {
        swal({
            title: "Você tem certeza?",
            text: "Uma vez excluído, você não poderá recuperar!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
            buttons: ["Cancelar", "Confirmar"],
        }).then(function(willDelete) {
            if (willDelete) {
                $.ajax({
                    type: 'POST',
                    cache: false,
                    url: $('#urlDeleteArquivo').val(),
                    data: { idDoc: idDoc, idDocumentacao: idDocumentacao },
                }).done(function(data) {
                    $(".div-table").html(data);
                    swal("Registro Deletado com sucesso!", {
                        icon: "success",
                    });
                }).fail(function() {
                    swal("Não foi possível deletar o registro selecionado!", {
                        icon: "danger",
                    });
                });
            }
        });
    }

    function abrirModal(titulo){
        $(".modal-title").html(titulo)
        $('#mdDocumentacao').modal('show');
    }

    function editarDocumentacao(idDocumentacao) {
        $('#documentacaoId').val(idDocumentacao);
        $.ajax({
            type: 'POST',
            cache: false,
            url: $('#url-get-documentacao').val(),
            data: { idDocumentacao: idDocumentacao },
        }).done(function (data) {
            if(data.tipo == 'ATIVIDADE_COMPLEMENTAR'){
                $('#nome').val(data.documentacao.nome);
                $('#dataEvento').val(formataData(data.documentacao.dataEvento));
                $('#descricao').val(data.documentacao.descricao);
                $('#tipoDocumentacao').val(data.documentacao.tipoAtividade.name);
                $('#cargaHoraria').val(data.documentacao.cargaHoraria);
            }else{
                $('#nome').val(data.documentacao.tipoDocumentoEstagio.name);
            }
            abrirModal('Editar Documentação');
        }).fail(function () {
            swal("Não foi possível deletar o registro selecionado!", {
                icon: "danger",
            });
        });
    }

    function deleteRegistroDocumentacao(idDocumentacao) {
        swal({
            title: "Você tem certeza?",
            text: "Uma vez excluído, você não poderá recuperar!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
            buttons: ["Cancelar", "Confirmar"],
        }).then(function(willDelete) {
            if (willDelete) {
                $.ajax({
                    type: 'POST',
                    cache: false,
                    url: $('#urlDeleteDocumentacao').val(),
                    data: { idDocumentacao: idDocumentacao },
                }).done(function(data) {
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }
                }).fail(function() {
                    swal("Não foi possível deletar o registro selecionado!", {
                        icon: "danger",
                    });
                });
            }
        });
    }

    function formataData(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [day, month, year].join('/');
    }

    window.editarDocumentacao = editarDocumentacao;
    window.deleteRegistroDocumentacao = deleteRegistroDocumentacao;
    window.deleteRegistroArquivo = deleteRegistroArquivo;
};

App.modules.operacoesDocumentacao = function () {
    function cadastrarDocumentacao() {
        $('#idDocumentacao').val('');
        $('form').trigger('reset');
        abrirModal('Adicionar Documentação')
    }

    function abrirModal(titulo){
        $(".modal-title").html(titulo)
        $('#mdDocumentacao').modal('show');
    }

    function editarDocumentacao(idDocumentacao) {
        $('#documentacaoId').val(idDocumentacao);
        $.ajax({
            type: 'POST',
            cache: false,
            url: $('#url-get-documentacao').val(),
            data: { idDocumentacao: idDocumentacao },
        }).done(function (data) {
            if(data.tipo == 'ATIVIDADE_COMPLEMENTAR'){
                $('#nome').val(data.documentacao.nome);
                $('#dataEvento').val(formataData(data.documentacao.dataEvento));
                $('#descricao').val(data.documentacao.descricao);
                $('#tipoDocumentacao').val(data.documentacao.tipoAtividade.name);
                $('#cargaHoraria').val(data.documentacao.cargaHoraria);
            }else{
                $('#nome').val(data.documentacao.tipoDocumentoEstagio.name);
            }
            abrirModal('Editar Documentação');
        }).fail(function () {
            swal("Não foi possível deletar o registro selecionado!", {
                icon: "danger",
            });
        });
    }

    function deleteRegistro(idDocumentacao) {
        swal({
            title: "Você tem certeza?",
            text: "Uma vez excluído, você não poderá recuperar!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
            buttons: ["Cancelar", "Confirmar"],
        }).then(function(willDelete) {
            if (willDelete) {
                $.ajax({
                    type: 'POST',
                    cache: false,
                    url: $('#url-delete-documentacao').val(),
                    data: { idDocumentacao: idDocumentacao },
                }).done(function(data) {
                    $(".div-table").html(data);
                    swal("Registro Deletado com sucesso!", {
                        icon: "success",
                    });
                }).fail(function() {
                    swal("Não foi possível deletar o registro selecionado!", {
                        icon: "danger",
                    });
                });
            }
        });
    }

    function formataData(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [day, month, year].join('/');
    }

    window.editarDocumentacao = editarDocumentacao;
    window.cadastrarDocumentacao = cadastrarDocumentacao;
    window.deleteRegistro = deleteRegistro;
};

(function () {
    App.findRun();
})();



