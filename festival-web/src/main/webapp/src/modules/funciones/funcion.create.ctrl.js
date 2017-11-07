

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionesModule");
    mod.controller("funciones.createCtrl", ["$scope", "$http", "$state", "funcionesContext",  
        function ($scope, $http, $state, funcionesContext) {
            $scope.create = function () {
                $http.post(funcionesContext, {
                    horaInicio: $scope.fechaInicio,
                    horaFin: $scope.fechaFin,
                    name : $scope.nombre,
                    sala: {
                        id: $scope.sala
                        
                    },
                    festival:{
                        id : $scope.festival
                    },
                    pelicula:{
                        id:$scope.pelicula
                    }
                }).then(function (response) {
                    //Silla created successfully.
                    $state.go('funcionesList');
                });
            };
        }
    ]);
}
)(angular);


