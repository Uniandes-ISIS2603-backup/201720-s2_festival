/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    // Definición del módulo
    var mod = ng.module("abonosModulo", ['ui.router']);
//    mod.constante("boletasContext", "api/boletas");
        
    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/abonos/';
            // Mostrar la lista de editoriales será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/abonosList");
            // Definición del estado 'editorialsList' donde se listan los editoriales
            //TODO: EL STATE PROVIDER ESTÁ GENERANDO ERROR, EL NOMBRE DEBERÍA SER: 'boletasList'
            $stateProvider.state('abonosList', {
                // Url que aparecerá en el browser
                url: '/abonos/List',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'abonos.list.html',
                        controller: 'abonosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
//			.state('boletasGetSingle', {
//			
//			
//			});
        }
    ]);
    
})(window.angular);