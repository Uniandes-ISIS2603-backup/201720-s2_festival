(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'calificacionesContext', '$state',
        function ($scope, $http, calificacionesContext, $state) {
            $http.get(calificacionesContext).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
            
            if (($state.params.funcionId !== undefined)&& ($state.params.funcionId !== null)) {
                $http.get(calificacionesContext + '/' + $state.params.calificacionId).then(function (response) {
                    $scope.currentCalificacion = response.data;
                    
                });
            };
            $scope.crearCalificacion = function() {
                $state.go('crearCalificacion');
            };
            
            $scope.deleteCalificacion = function(param){
               
              $state.go('calificacionDelete',{calificacionId:param});  
            };
            $scope.actualizarCalificacion = function(param){
               
              $state.go('update',{calificacionId:param});  
            };
            
                
                
            
        }
    ]);
}
)(window.angular);