/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.getCtrl', ['$scope', '$http', 'boletasContext', '$stateParams',
        function ($scope, $http, boletasContext, $stateParams) {
            $scope.detail = true;
            $http.get(boletasContext + $stateParams.boletaId).then(function (response) {
                $scope.boleta = response.data;
            });
        }
    ]);
}
)(angular);