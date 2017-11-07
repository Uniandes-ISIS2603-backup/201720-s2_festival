/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("festivalesModule");
    mod.controller('festivales.listCtrl',['$scope', '$http', 'festivalesContext', '$state',
        function($scope, $http, festivalesContext, $state ){
            $http.get(festivalesContext).then(function(response){
                $scope.festivales = response.data;
            });
        }
    ]);
}
)(angular);

