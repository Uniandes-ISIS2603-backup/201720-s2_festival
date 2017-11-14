/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.createCtrl', ['$scope', '$http', 'boletasContext', '$state',
        function ($scope, $http, boletasContext, $state) {
            $scope.create = true;
            $scope.actionForBoleta = function () {
                $http.post(boletasContext, {
                    codigoDeBarras: $scope.boletaForm.boletaCodigoBarrasIn.$viewValue,
                    estado: $scope.boletaForm.boletaEstadoIn.$viewValue,
                    precio: $scope.boletaForm.boletaPrecioIn.$viewValue,
                    funcion: {id: $scope.boletaForm.idFuncionIn.$viewValue},
                    silla : {id : $scope.boletaForm.idSillaIn.$viewValue}
                }).then(function (response) {
                    $state.go('boletasList', {boletaId: response.data.id});
                });
            };
        }
        
    ]);
}
)(angular);

