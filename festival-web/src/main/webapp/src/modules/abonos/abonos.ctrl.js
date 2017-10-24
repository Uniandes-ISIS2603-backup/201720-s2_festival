/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModulo");
    mod.constant("abonosContext", "api/abonos");
    mod.controller('abonosCtrl', ['$scope', '$http', 'abonosContext',
        function ($scope, $http, abonosContext) {
            $http.get('data/abonos.json').then(function (response) {
                $scope.abonosRecords = response.data;
            });
        }
    ]);
}
)(angular);