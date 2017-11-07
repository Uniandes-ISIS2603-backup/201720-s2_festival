/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("teatrosModule");
    mod.controller("teatros.updateCtrl", ["$scope", "$http", "$state", "teatrosContext",  
        function ($scope, $http, $state, teatrosContext) {
            $http.get(teatrosContext + $state.params.teatrosId).then(function (response) {
                $scope.teatro = response.data;
            });
            $scope.updateTeatro = function () {
                $http.put(teatrosContext + $state.params.teatrosId, {
                    teatroNombre: $scope.nombre,
                    tarifaBasica: $scope.tarifaBasica
                }).then(function (response) {
                    $state.go('teatros.detail', {teatroId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

