/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("criticasModule");
    mod.controller("criticas.createCtrl", ["$scope", "$http", "$state", "criticasContext",  
        function ($scope, $http, $state, criticasContext) {
            $scope.createCritica = function () {
                $http.post(criticasContext, {
                    comentario: $scope.criticaComentario,
                    critico: { 
                        id: $scope.critico 
                    },
                    funcion: { 
                        id: $scope.funcion
                    }
                }).then(function (response) {
                    //Silla created successfully.
                    $state.go('criticas.detail', {criticasId: response.data.id});
                });
            };
        }
    ]);
}
)(angular);

