/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("criticasModule");
    mod.controller("criticas.updateCtrl", ["$scope", "$http", "$state", "criticasContext",
        function ($scope, $http, $state, criticasContext) {
            $scope.update = true;
            $http.get(criticasContext + $state.params.criticasId).then(function (response) {
                $scope.critica = response.data;
                $scope.criticaComentario = $scope.critica.comentario;
            });
            $scope.actionForCritica = function () {
                $http.put(criticasContext + $state.params.criticasId, {
                    comentario: $scope.criticaForm.criticaComentarioTa.$viewValue
                }).then(function (response) {
                    $state.go('criticas.detail', {criticasId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

