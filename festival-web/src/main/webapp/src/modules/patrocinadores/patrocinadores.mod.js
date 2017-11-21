/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module('patrocinadoresModule', ['ui.router']);
    mod.constant("patrocinadoresContext", "api/patrocinadores/");
    mod.config(['$stateProvider', 
        function ($stateProvider) {
            var basePath = 'src/modules/patrocinadores/';
            $stateProvider
                    .state('patrocinadores', {
                        abstract: true,
                        url: "/patrocinadores",
                        views : {
                            "mainView": {
                                templateUrl: basePath + "patrocinadores.html",
                                controller: "patrocinadoresCtrl",
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state('patrocinadores.controles', {
                        url: "/lista",
                        views : {
                            "lista@patrocinadores": {
                                templateUrl: basePath + "listaPatrocinadores.html",
                                controller : function($scope, $http, patrocinadoresContext, $state) {
                                    $http.get(patrocinadoresContext).then(function (response) {
                                        $scope.patrocinadores = response.data;
                                    });
                                    $scope.deletePatrocinador = function(idPatrocinador) {
                                        $http.delete(patrocinadoresContext + idPatrocinador);
                                    };
                                }
                            },
                            "create@patrocinadores": {
                                templateUrl: basePath + "createPatrocinador.html",
                                controller: function ($scope, $http, $state, patrocinadoresContext) {
                                    $scope.createPatrocinador = function () {
                                        $http.post(patrocinadoresContext, {
                                            name: $scope.name,
                                            patrocinio: $scope.patrocinio,
                                            NIT: $scope.NIT
                                        }).then(function (response) {
                                        });
                                    };
                                }
                            },
                            "update@patrocinadores": {
                                templateUrl: basePath + "updatePatrocinador.html",
                                controller: function($scope, $http, patrocinadoresContext, $state) {
                                    $http.get(patrocinadoresContext).then(function (response) {
                                        $scope.patrocinadores = response.data;
                                    });
                                    $scope.updatePatrocinador = function (idPatrocinador) {
                                        $http.put(patrocinadoresContext + idPatrocinador, {
                                            name: $scope.name,
                                            patrocinio: $scope.patrocinio,
                                            NIT: $scope.NIT
                                        }).then(function (response) {
                                        });
                                    };
                                }
                            }
                        }
                    })                            
                    .state('patrocinadores.detallePatrocinador', {
                        url: "/{idPatrocinador:int}",
                        param: {
                            idPatrocinador : null  
                        },
                        views: {
                            "patrocinadorDetalle@patrocinadores" :{
                                templateUrl: basePath + "detallePatrocinador.html",
                                controller: function($scope, $http, patrocinadoresContext, $state) {
                                    $http.get(patrocinadoresContext + $state.params.idPatrocinador).then(function (response) {
                                        $scope.patrocinador = response.data;
                                    });
                                }
                            }
                        }
                    });
        }]);
})(window.angular);