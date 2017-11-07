/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng) {
    var mod = ng.module("festivalesModule");
    mod.controller("festivales.detailCtrl", ["$scope", "$http", "festivalesContext","$state",
        function($scope, $http, festivalesContext, $state){
            $http.get(festivalesContext + $state.params.festivalesId).then(function(response){
                $scope.festival = response.data;
            });
        }
    ]);
}
)(angular);

