/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    //console.log($scope);
    mod.controller('boletas.updateCtrl',['$scope', '$http', 'boletasContext', '$state', '$rootScope',
        function ($scope, $http, boletasContext, $state, $rootScope, $stateParams) {
            console.log($stateParams);
            $http.get(boletasContext+$state.params.boletaId).then( function (response) {
                $scope.boleta = response.data;
                $scope.boletaCodigoBarras = $scope.boleta.codigoDeBarras;
                $scope.boletaEstado = $scope.boleta.estado;
                $scope.boletaPrecio = $scope.boleta.precio;
                $scope.idFuncion = $scope.boleta.funcion.id;
                $scope.idSilla = $scope.boleta.silla.id;
                $scope.idEspectador = $scope.boleta.espectador.id;
            });
            $rootScope.edit = false;
            $scope.updateBoleta = function () {
                console.log($scope);
                $http.put(boletasContext+$state.params.boletaId, {
                    codigoDeBarras: $scope.boletaCodigoBarras,
                    estado: $scope.boletaEstado,
                    precio: $scope.boletaPrecio,
                    funcion: {id: $scope.idFuncion},
                    silla : {id : $scope.idSilla}
//                    espectador : {id : $scope.idEspectador}
                }).then(function (response) {
                    //Author created successfully
                    $state.go('boletasList', {boletaId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
}
)(angular);