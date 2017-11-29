/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 (function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.takeCtrl', ['$scope', '$http', 'boletasContext', '$state',
        function ($scope, $http, boletasContext, $state, $modal) {
            $scope.take = true;
            $scope.init = function () {
                 
               /* document.getElementById("elPapaDelModal").removeChild(document.getElementById("cajaFunciones"));*/

            }; 
            $http.get(boletasContext + $state.params.boletasId).then(function (response) {
                $scope.boleta = response.data;
            });
            $scope.comprarBoletas = function () {
                $http.put(boletasContext + $state.params.boletasId, {
                    estado: "COMPRADA",
                    espectador: {id: $scope.boletaForm.idEspectadorIn.$viewValue}
                }).then(function (response) {
                    $state.go('boletasGet', {boletaId: response.data.id});
                });
            };
            $scope.reservarBoletas = function () {
                $http.put(boletasContext + $state.params.boletasId, {
                    estado: "RESERVADA",
                    espectador: {id: $scope.boletaForm.idEspectadorIn.$viewValue}
                }).then(function (response) {
                    $state.go('boletasGet', {boletaId: response.data.id});
                });
            };
        }

        ]);
}
)(angular);