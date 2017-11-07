/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng) {
    var mod = ng.module("teatrosModule");
    mod.controller("teatros.detailCtrl", ["$scope", "$http", "teatrosContext","$state",
        function($scope, $http, teatrosContext, $state){
            $http.get(teatrosContext + $state.params.teatrosId).then(function(response){
                $scope.teatro = response.data;
            });
        }
    ]);
}
)(angular);

