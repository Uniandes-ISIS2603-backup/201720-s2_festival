/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller('abonos.createCtrl', ['$scope', '$http', 'abonosContext', '$state',
        function ($scope, $http, abonosContext, $state) {
            $scope.create = true;
            $scope.actionForAbono = function () {
                $http.post(abonosContext, {
                    precio: $scope.abonoForm.abonoPrecioIn.$viewValue,
                    espectador: {id: $scope.abonoForm.abonoIDEspectadorIn.$viewValue}
                }).then(function (response) {
                    $state.go('abonosList', {abonoId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);