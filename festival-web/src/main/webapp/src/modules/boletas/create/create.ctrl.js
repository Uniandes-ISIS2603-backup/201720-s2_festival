/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.createCtrl', ['$scope', '$http', 'boletasContext', '$state', '$rootScope',
        function ($scope, $http, boletasContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createBoleta = function () {
                console.log($scope);
                $http.post(boletasContext, {
                    codigoDeBarras: $scope.boletaCodigoBarras,
                    estado: $scope.boletaEstado,
                    precio: $scope.boletaPrecio,
                    funcion: {id: $scope.idFuncion},
                    silla : {id : $scope.idSilla}
                }).then(function (response) {
                    //Author created successfully
                    $state.go('boletasList', {boletaId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
}
)(angular);

