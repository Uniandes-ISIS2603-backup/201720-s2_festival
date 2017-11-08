(function (ng) {
    var mod = ng.module("calificacionesModule");
    mod.controller("calificaciones.deleteCtrl", ["$http", "$state", "calificacionesContext",  
        function ($http, $state, calificacionesContext) {
            
            $http.delete(calificacionesContext +"/"+ $state.params.calificacionId, {
            }).then(function () {
                //Silla created successfully.
                
                $state.go('calificacionesList',{},{location:"replace"});
            });
        }
    ]);
}
)(angular);

