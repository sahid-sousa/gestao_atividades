var App = {};
App.modules = {};
App.run = function (nome) {
    var find = false;
    for (var key in App.modules) {
        if (key === nome) {
            find = true;
            var module = App.modules[key];
            module();
        }
    }
    if (!find) {
        console.warn("O módulo '" + nome + "' não foi encontrado.")
    }
};

App.findRun = function () {
    var modules = document.querySelectorAll('*[data-run]');
    if (modules.length !== 0) {
        for (var i = 0; i < modules.length; i++) {
            var module = modules[i];
            module = module.dataset.run;
            App.run(module);
        }
    }
};