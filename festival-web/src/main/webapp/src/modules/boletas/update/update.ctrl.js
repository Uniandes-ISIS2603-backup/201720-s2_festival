/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.updateCtrl', ['$scope', '$http', 'boletasContext', '$state',
        function ($scope, $http, boletasContext, $state) {
            $scope.update = true;
            $http.get(boletasContext + $state.params.boletaId).then(function (response) {
                $scope.boleta = response.data;
                $scope.boletaCodigoBarras = $scope.boleta.codigoDeBarras;
                $scope.boletaEstado = $scope.boleta.estado;
                $scope.boletaPrecio = $scope.boleta.precio;
                $scope.idFuncion = $scope.boleta.funcion.id;
                $scope.idSilla = $scope.boleta.silla.id;
                $scope.idEspectador = $scope.boleta.espectador.id;
            });
            $scope.actionForBoleta = function () {
                $http.put(boletasContext + $state.params.boletaId, {
                    codigoDeBarras: $scope.boletaForm.boletaCodigoBarrasIn.$viewValue,
                    estado: $scope.boletaForm.boletaEstadoIn.$viewValue,
                    precio: $scope.boletaForm.boletaPrecioIn.$viewValue,
                    funcion: {id: $scope.boletaForm.idFuncionIn.$viewValue},
                    silla: {id: $scope.boletaForm.idSillaIn.$viewValue},
                    espectador: {id: $scope.boletaForm.idEspectadorIn.$viewValue}
                }).then(function (response) {
                    $state.go('boletasGet', {boletaId: response.data.id});
                });
            };
        }

    ]);
}
)(angular);