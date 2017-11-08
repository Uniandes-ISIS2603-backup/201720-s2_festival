/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionesModule");
    //console.log($scope);
    mod.controller('funciones.updateCtrl',['$scope', '$http', 'funcionesContext', '$state', '$rootScope',
        function ($scope, $http, funcionesContext, $state, $rootScope, $stateParams) {
            console.log("update funcion http");
            
            $rootScope.edit = false;
            $scope.update = function () {
                console.log($scope.fechaInicio);
                $http.put(funcionesContext+"/"+$state.params.funcionId, {
                    
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
//                    espectador : {id : $scope.idEspectador}
                }).then(function (response) {
                    //Author created successfully
                    $state.go('funcionesList', {}, {reload: true});
                });
            };
        }
        
    ]);
}
)(angular);