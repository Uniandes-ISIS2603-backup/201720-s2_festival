/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("criticasModule");
    mod.controller("criticas.detailCtrl", ["$scope", "$http", "criticasContext", "$state",
        function ($scope, $http, criticasContext, $state) {
            $scope.detail = true;
            $http.get(criticasContext + $state.params.criticasId).then(function (response) {
                $scope.critica = response.data;
            });
        }
    ]);
}
)(angular);

