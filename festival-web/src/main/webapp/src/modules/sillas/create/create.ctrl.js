/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("sillasModule");
    mod.controller("sillas.createCtrl", ["$scope", "$http", "$state", "sillasContext",  
        function ($scope, $http, $state, sillasContext) {
            $scope.createSilla = function () {
                $http.post(sillasContext, {
                    tarifa: $scope.sillaTarifa,
                    esPreferencial: $scope.sillaEsPreferencial,
                    sala: {
                        id: $scope.sala
                    }
                }).then(function (response) {
                    //Silla created successfully.
                    $state.go('sillas.detail', {sillasId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

