/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("peliculaAmpliadaModule");
    mod.controller("vistaBoletasDeFuncionDetalleCtrl", ["$scope", "$http", "$state", "funcionesContext", 
        function ($scope, $http, $state, funcionesContext) {
            $http.get(funcionesContext + "/" + $state.params.funcionId + "/boletas")
                .then(function (response){
                        $scope.boletas = response.data;

                    }
                );
        }
    ]);
}
)(angular);


