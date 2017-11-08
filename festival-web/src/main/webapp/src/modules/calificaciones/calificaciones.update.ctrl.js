/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("calificacionesModule");
    //console.log($scope);
    mod.controller('calificaciones.updateCtrl',['$scope', '$http', 'calificacionesContext', '$state', '$rootScope',
        function ($scope, $http, calificacionesContext, $state, $rootScope, $stateParams) {
            console.log("update calificacion http");
            
            $rootScope.edit = false;
            $scope.updateCalificacion = function () {
                console.log($scope);
                $http.put(calificacionesContext+"/"+$state.params.calificacionId, {
                    calificacion: $scope.calificacion,
                    comentario: $scope.comentario,
                    id: $state.params.calificacionId
                    
//                    espectador : {id : $scope.idEspectador}
                }).then(function (response) {
                    //Author created successfully
                    $state.go('calificacionesList', {}, {reload: true});
                });
            };
        }
        
    ]);
}
)(angular);