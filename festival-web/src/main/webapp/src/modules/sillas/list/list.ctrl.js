/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("sillasModule");
    mod.controller('sillas.listCtrl', ['$scope', '$http', 'sillasContext', '$state',
        function ($scope, $http, sillasContext, $state) {
            $http.get(sillasContext).then(function (response) {
                $scope.sillas = response.data;
            });
        }
    ]);
}
)(angular);

