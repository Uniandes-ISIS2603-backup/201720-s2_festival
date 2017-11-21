/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module('salasModule', ['ui.router']);
    mod.constant("salasContext", "api/salas/");
    mod.config(['$stateProvider', 
        function ($stateProvider) {
            var basePath = 'src/modules/salas/';
            $stateProvider
                    .state('salas', {
                        abstract: true,
                        url: "/salas",
                        views : {
                            "mainView": {
                                templateUrl: basePath + "salas.html",
                                controller: "salasCtrl",
                                controllerAs: "ctrl"
                            }
                        }
                    })
                    .state('salas.controles', {
                        url: "/lista",
                        views : {
                            "lista@salas": {
                                templateUrl: basePath + "listaSalas.html",
                                controller : function($scope, $http, salasContext, $state) {
                                    $http.get(salasContext).then(function (response) {
                                        $scope.salas = response.data;
                                    });
                                    $scope.deleteSala = function(idSala) {
                                        $http.delete(salasContext + idSala);
                                    };
                                }
                            },
                            "create@salas": {
                                templateUrl: basePath + "createSala.html",
                                controller: function ($scope, $http, $state, salasContext) {
                                    $scope.createSala = function () {
                                        $http.post(salasContext, {
                                            name: $scope.name,
                                            numSillas: $scope.numSillas,
                                            numSillasPreferenciales: $scope.numSillasPreferenciales
                                        }).then(function (response) {
                                            $scope.nuevaSala.$setUntouched();
                                            $scope.nuevaSala.$setPristine();
                                        });
                                    };
                                }
                            },
                            "update@salas": {
                                templateUrl: basePath + "updateSala.html",
                                controller: function($scope, $http, salasContext, $state) {
                                    $http.get(salasContext).then(function (response) {
                                        $scope.salas = response.data;
                                    });
                                    $scope.updateSala = function (idSala) {
                                        $http.put(salasContext + idSala, {
                                            name: $scope.name,
                                            numSillas: $scope.numSillas,
                                            numSillasPreferenciales: $scope.numSillasPreferenciales
                                        }).then(function (response) {
                                        });
                                    };
                                }
                            }
                        }
                    })                            
                    .state('salas.detalleSala', {
                        url: "/{idSala:int}",
                        param: {
                            idSala : null  
                        },
                        views: {
                            "salaDetalle@salas" :{
                                templateUrl: basePath + "detalleSala.html",
                                controller: function($scope, $http, salasContext, $state) {
                                    $http.get(salasContext + $state.params.idSala).then(function (response) {
                                        $scope.sala = response.data;
                                    });
                                }
                            }
                        }
                    });
        }]);
})(window.angular);