/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.controller("calificaciones.createCtrl", ["$scope", "$http", "$state", "calificacionesContext",  
        function ($scope, $http, $state, calificacionesContext) {
            $scope.createCalificacion = function () {
                $http.post(calificacionesContext, {
                    calificacion: $scope.calificacion,
                    comentario: $scope.comentario,
                    boleta: {
                        id: $scope.boleta,
                        estado : 3,
                        codigoDeBarras : 650,
                        precio:100
                    }
                }).then(function (response) {
                    //Silla created successfully.
                    $state.go('calificacionesList');
                });
            };
        }
    ]);
}
)(angular);


