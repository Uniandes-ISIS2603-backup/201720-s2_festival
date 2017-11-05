/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller('abonos.createCtrl', ['$scope', '$http', 'abonosContext', '$state', '$rootScope',
        function ($scope, $http, abonosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createAbono = function () {
                console.log($scope);
                $http.post(abonosContext, {
                    precio: $scope.abonoPrecio
                }).then(function (response) {
                    //Author created successfully
                    $state.go('abonosList', {abonoId: response.data.id}, {reload: true});
                });
            };
        }
        
    ]);
}
)(angular);