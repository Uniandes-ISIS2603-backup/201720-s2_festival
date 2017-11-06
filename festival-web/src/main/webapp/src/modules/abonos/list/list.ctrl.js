/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller('abonos.listCtrl', ['$scope', '$http', 'abonosContext', '$state',
        function ($scope, $http, abonosContext, $state) {
            $http.get(abonosContext).then( function (response) {
                $scope.abonos = response.data;
            });
        }        
    ]);
}
)(angular);