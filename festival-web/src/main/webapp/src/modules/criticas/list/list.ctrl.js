/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("criticasModule");
    mod.controller('criticas.listCtrl', ['$scope', '$http', 'criticasContext',
        function ($scope, $http, criticasContext) {
            $http.get(criticasContext).then(function (response) {
                $scope.criticas = response.data;
            });
        }
    ]);
}
)(angular);

