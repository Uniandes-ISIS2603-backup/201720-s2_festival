/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller('boletas.getCtrl', ['$scope', '$http', 'boletasContext', '$state',
        function ($scope, $http, boletasContext, $stateParams) {
            console.log($stateParams)
            $http.get(boletasContext+$stateParams.params.boletaId).then( function (response) {
                $scope.boleta = response.data;
            });
        }
        
    ]);
}
)(angular);


