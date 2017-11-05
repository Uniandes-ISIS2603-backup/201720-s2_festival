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
            
            $scope.toBoletasList = function () {
            $state.go('boletasList',{reload : true});
            };
            $scope.toBoletasGet = function(){;
                $state.go('boletasGet');
            };
            $scope.toBoletasGetFromList = function(param){;
                $state.go('boletasGet', {boletaId:param});
            };
            $scope.deleteBoleta = function(param){;
                $state.go('boletasDelete', {boletaId:param});
            };
            $scope.updateBoleta = function(param){;
                $state.go('boletasUpdate', {boletaId:param});
            };
            $scope.deleteCalificacionFromBoleta = function(param){;
                $http.delete(boletasContext+param + '/calificaciones').then(function()
               {
                   $state.reload();
               });
            };
            $scope.toBoletasCreate = function(){;
                $state.go('boletasCreate');
            };
//            $http.get('data/boletas.json').then(function (response) {
//                $scope.boletasRecords = response.data;
//            });
        }
    ]);
}
)(angular);