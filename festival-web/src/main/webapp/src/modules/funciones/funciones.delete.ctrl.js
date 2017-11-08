/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("funcionesModule");
    mod.controller("funciones.deleteCtrl", ["$http", "$state", "funcionesContext",  
        function ($http, $state, funcionesContext) {
            
            $http.delete(funcionesContext +"/"+ $state.params.funcionId, {
            }).then(function () {
                //Silla created successfully.
                
                $state.go('funcionesList',{},{reload:"true"});
            });
        }
    ]);
}
)(angular);

