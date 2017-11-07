/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalesModule");
    mod.controller("festivales.updateCtrl", ["$scope", "$http", "$state", "festivalesContext",  
        function ($scope, $http, $state, festivalesContext) {
            $http.get(festivalesContext + $state.params.festivalesId).then(function (response) {
                $scope.festival = response.data;
            });
            $scope.updateFestival = function () {
                $http.put(festivalesContext + $state.params.festivalesId, {
                    festivalName: $scope.festivalName,
                }).then(function (response) {
                    //Silla created successfully.
                    $state.go('festivales.detail', {festivalesId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

