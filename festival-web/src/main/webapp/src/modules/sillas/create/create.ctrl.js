/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("sillasModule");
    mod.controller("sillas.createCtrl", ["$scope", "$http", "$state", "sillasContext",
        function ($scope, $http, $state, sillasContext) {
            $scope.create = true;
            $scope.actionForSilla = function () {
                $http.post(sillasContext, {
                    tarifa: $scope.sillaForm.sillaTarifaIn.$viewValue,
                    esPreferencial: $scope.sillaForm.sillaEsPreferencialIn.$viewValue,
                    sala: {
                        id: $scope.sillaForm.salaIn.$viewValue
                    }
                }).then(function (response) {
                    $state.go('sillas.detail', {sillasId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

