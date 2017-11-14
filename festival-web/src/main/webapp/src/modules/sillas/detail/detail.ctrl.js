/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("sillasModule");
    mod.controller("sillas.detailCtrl", ["$scope", "$http", "sillasContext", "$state",
        function ($scope, $http, sillasContext, $state) {
            $scope.detail = true;
            $http.get(sillasContext + $state.params.sillasId).then(function (response) {
                $scope.silla = response.data;
            });
        }
    ]);
}
)(angular);

