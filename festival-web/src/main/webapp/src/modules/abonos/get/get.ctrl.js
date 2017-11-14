/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller('abonos.getCtrl', ['$scope', '$http', 'abonosContext', '$stateParams',
        function ($scope, $http, abonosContext, $stateParams) {
            $scope.detail = true;
            $http.get(abonosContext + $stateParams.abonoId).then(function (response) {
                $scope.abono = response.data;
            });

        }
    ]);
}
)(angular);