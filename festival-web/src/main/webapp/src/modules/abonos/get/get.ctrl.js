/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller('abonos.getCtrl', ['$scope', '$http', 'abonosContext', '$state',
        function ($scope, $http, abonosContext, $stateParams, $state) {
            console.log($stateParams);
            $http.get(abonosContext+$stateParams.params.abonoId).then( function (response) {
                $scope.abono = response.data;
            });

            }        
    ]);
}
)(angular);