/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.constant("abonosContext", "api/abonos/");
    mod.controller('abonosCtrl', ['$scope', '$http', 'abonosContext', '$state',
        function ($scope, $http, abonosContext, $state) {
             $scope.toAbonosList = function () {
                $state.go('abonosList', {reload : true});
            };
            $scope.toAbonosGet = function(param){;
                
                $state.go('abonosGet', {abonoId:param}, {reload : true});
            };
            $scope.deleteAbono = function(param){;
                $state.go('abonosDelete', {abonoId:param});
            };
            $scope.toBoletasGetFromList = function(param){;
                
                $state.go('boletasGet', {boletaId:param});
            };
            $scope.removeBoletaFromAbono = function(param1, param2){
               $http.delete(abonosContext+param1 + '/boletas/'+param2).then(function()
               {
                   $state.reload();
               });
               };
            $scope.addBoletaToAbono = function(param1, param2){;
            $http.post(abonosContext+param1 + '/boletas/'+param2).then(function()
            {
                $state.reload();
            });
            };
            $scope.toAbonosCreate = function(){;
                $state.go('abonosCreate');
            };
        }
    ]);
}
)(angular);