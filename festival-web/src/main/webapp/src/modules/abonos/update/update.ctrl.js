/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    //console.log($scope);
    mod.controller('abonos.updateCtrl',['$scope', '$http', 'abonosContext', '$state', '$rootScope',
        function ($scope, $http, abonosContext, $state, $rootScope, $stateParams) {
            console.log($stateParams);
            $http.get(abonosContext+$state.params.abonoId).then( function (response) {
                $scope.abono = response.data;
                $scope.abonoPrecio = $scope.abono.precio;
                $scope.abonoIdEspetador = $scope.abono.espectador.id;
                $scope.abonoBoletas = $scope.abono.boletas;
            });
            $rootScope.edit = false;
            $scope.updateAbono = function () {
                console.log($scope);
                $http.put(abonosContext+$state.params.abonoId, {
                    precio: $scope.abonoPrecio,
                    espectador : { id : $scope.abonoIdEspectador}
                }).then(function (response) {
                    //Author created successfully
                    $state.go('abonosList', {boletaId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
}
)(angular);