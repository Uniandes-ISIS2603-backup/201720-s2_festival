(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies
        'boletasModule',
        'abonosModule',
        'calificacionesModule',
        'funcionesModule',
        'teatrosModule',
        'festivalesModule',
//        'espectadoresModule',
//        'criticosModule',
        'peliculasModule',
        'salasModule',
        'patrocinadoresModule',
        'sillasModule',
        'criticasModule'
    ]);
    
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);