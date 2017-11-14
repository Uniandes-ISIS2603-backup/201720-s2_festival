/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    // Definición del módulo
    var mod = ng.module("abonosModule", ['ui.router']);
    mod.constant("abonosContext", "api/abonos/");
        
    // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/abonos/';
            // Mostrar la lista de editoriales será el estado por defecto del módulo
            // Definición del estado 'editorialsList' donde se listan los editoriales
            //TODO: EL STATE PROVIDER ESTÁ GENERANDO ERROR, EL NOMBRE DEBERÍA SER: 'boletasList'
            $stateProvider.state('abonos', {
                // Url que aparecerá en el browser
                url: '/abonos',
                views: {
                    mainView: {
                        templateUrl: basePath + 'abonos.html',
                        controller: 'abonosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state("abonosList", {
            url: "/list",
            parent:'abonos',
            views: {
                abonosView: {
                    templateUrl: basePath + 'list/list.html',
                    controller: 'abonos.listCtrl',
                    controllerAs: "ctrl"
                }
            }
        })
        .state("abonosGet", {
            url: "/get/{abonoId:int}",
            parent:'abonos',
            param: {
              abonoId : null  
            },
            views: {
                abonosView: {
                    templateUrl: basePath + 'get/get.html',
                    controller: 'abonos.getCtrl',
                    controllerAs: "ctrl"
                }
            }
        })
        .state("abonosDelete", {
            url: "/delete/{abonoId:int}",
            parent:'abonos',
            param: {
              abonoId : null  
            },
            views: {
                abonosView: {
//                    templateUrl: basePath + 'delete/delete.html',
                    controller: 'abonos.deleteCtrl',
                    controllerAs: "ctrl"
                }
            }
        })
        .state("abonosUpdate", {
            url: "/update/{abonoId:int}",
            parent:'abonos',
            param: {
              abonoId : null  
            },
            views: {
                abonosView: {
                    templateUrl: basePath + 'update/update.html',
                    controller: 'abonos.updateCtrl',
                    controllerAs: "ctrl"
                }
            }
        })
        .state("abonosCreate", {
            url: "/create",
            parent:'abonos',
            views: {
                abonosView: {
                    templateUrl: basePath + 'create/create.html',
                    controller: 'abonos.createCtrl',
                    controllerAs: "ctrl"
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