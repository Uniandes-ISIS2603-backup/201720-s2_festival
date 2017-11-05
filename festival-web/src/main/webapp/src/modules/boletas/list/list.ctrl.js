/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.listCtrl', ['$scope', '$http', 'boletasContext', '$state',
        function ($scope, $http, boletasContext, $state) {
            $http.get(boletasContext).then( function (response) {
                $scope.boletas = response.data;
            });
        }        
    ]);
}
)(angular);

