/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("sillasModule");
    mod.controller("sillas.updateCtrl", ["$scope", "$http", "$state", "sillasContext",  
        function ($scope, $http, $state, sillasContext) {
            $http.get(sillasContext + $state.params.sillasId).then(function (response) {
                $scope.silla = response.data;
            });
            $scope.updateSilla = function () {
                $http.put(sillasContext + $state.params.sillasId, {
                    tarifa: $scope.sillaTarifa,
                    esPreferencial: $scope.sillaEsPreferencial
                }).then(function (response) {
                    //Silla created successfully.
                    $state.go('sillas.detail', {sillasId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

