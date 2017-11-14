/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.constant("boletasContext", "api/boletas/");
    mod.controller('boletasCtrl', ['$scope', '$http', 'boletasContext', '$state',
        function ($scope, $http, boletasContext, $state) {
            $scope.deleteCalificacionFromBoleta = function (param) {
                ;
                $http.delete(boletasContext + param + '/calificaciones').then(function ()
                {
                    $state.reload();
                });
            };
        }
    ]);
}
)(angular);