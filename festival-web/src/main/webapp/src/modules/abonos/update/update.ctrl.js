/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller('abonos.updateCtrl', ['$scope', '$http', 'abonosContext', '$state',
        function ($scope, $http, abonosContext, $state) {
            $scope.update = true;
            $http.get(abonosContext + $state.params.abonoId).then(function (response) {
                $scope.abono = response.data;
                $scope.abonoPrecio = $scope.abono.precio;
                $scope.abonoIDEspectador = $scope.abono.espectador.id;
            });
            $scope.actionForAbono = function () {
                $http.put(abonosContext + $state.params.abonoId, {
                    precio: $scope.abonoForm.abonoPrecioIn.$viewValue,
                    espectador: {id: $scope.abonoForm.abonoIDEspectadorIn.$viewValue}
                }).then(function (response) {
                    $state.go('abonosGet', {abonoId: response.data.id});
                });
            };
        }

    ]);
}
)(angular);