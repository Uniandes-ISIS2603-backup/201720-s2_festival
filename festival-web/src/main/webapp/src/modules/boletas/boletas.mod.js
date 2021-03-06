/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    // Definición del módulo
    var mod = ng.module("boletasModule", ['ui.router']);
    mod.constant("boletasContext", "api/boletas/");

    // Configuración de los estados del módulo
    mod.config(['$stateProvider',
        function ($stateProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/boletas/';
            $stateProvider
                    .state('boletas', {
                        // Url que aparecerá en el browser
                        url: '/boletas',
                        abstract: true,
                        views: {
                            mainView: {
                                templateUrl: basePath + 'boletas.html',
                                controller: 'boletasCtrl',
                                controllerAs: 'ctrl'
                            }
                        }
                    })
                    .state("boletasList", {
                        url: "/list",
                        parent: 'boletas',
                        views: {
                            boletasView: {
                                templateUrl: basePath + 'list/list.html',
                                controller: 'boletas.listCtrl',
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state("boletasGet", {
                        url: "/get/{boletaId:int}",
                        parent: 'boletas',
                        param: {
                            boletaId: null
                        },
                        views: {
                            boletasView: {
                                templateUrl: basePath + 'get/get.html',
                                controller: 'boletas.getCtrl',
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state("boletasDelete", {
                        url: "/delete/{boletaId:int}",
                        parent: 'boletas',
                        param: {
                            boletaId: null
                        },
                        views: {
                            boletasView: {
                                controller: 'boletas.deleteCtrl',
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state("boletasUpdate", {
                        url: "/update/{boletaId:int}",
                        parent: 'boletas',
                        param: {
                            boletaId: null
                        },
                        views: {
                            boletasView: {
                                templateUrl: basePath + 'get/get.html',
                                controller: 'boletas.updateCtrl',
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state("boletasCreate", {
                        url: "/create",
                        parent: 'boletas',
                        views: {
                            boletasView: {
                                templateUrl: basePath + 'get/get.html',
                                controller: 'boletas.createCtrl',
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state("boletasTake", {
                        url: "/take/{boletasId:int}",
                        parent: 'boletas',
                        param: {
                            boletasId: null
                        },
                        views: {
                            boletasView: {
                                templateUrl: basePath + 'get/get.html',
                                controller: 'boletas.takeCtrl',
                                controllerAs: "ctrl"
                            }
                        }
                    });
        }
    ]);

})(window.angular);