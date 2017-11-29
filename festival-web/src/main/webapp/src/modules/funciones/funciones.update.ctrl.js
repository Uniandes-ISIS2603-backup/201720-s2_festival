/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("funcionesModule");
    // 
    mod.controller('funciones.updateCtrl',['$scope', '$http', 'funcionesContext', '$state', '$rootScope',
        function ($scope, $http, funcionesContext, $state, $rootScope, $stateParams) {
             
            
            $rootScope.edit = false;
            $scope.update = function () {
                 
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