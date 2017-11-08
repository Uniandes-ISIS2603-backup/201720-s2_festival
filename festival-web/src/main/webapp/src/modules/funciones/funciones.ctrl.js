(function (ng) {
    var mod = ng.module("funcionesModule");
    mod.constant("funcionesContext", "api/funciones");
    mod.controller('funcionesCtrl', ['$scope', '$http', 'funcionesContext', '$state',
        function ($scope, $http, funcionesContext, $state) {
            $http.get(funcionesContext).then(function (response) {
                $scope.funcionesRecords = response.data;
            });
            
            if (($state.params.funcionId !== undefined)&& ($state.params.funcionId !== null)) {
                $http.get(funcionesContext + '/' + $state.params.funcionId).then(function (response) {
                    $scope.currentFuncion = response.data;
                    if (($scope.currentFuncion.sala.id !== undefined)&& ($scope.currentFuncion.sala.id !== null)) {
                        $http.get( 'api/salas/' + $scope.currentFuncion.sala.id).then(function (response) {
                            $scope.currentSala = response.data;
                        });
                    };
                });
            };
            $scope.create = function() {
                $state.go('funcionesList');
            };
            $scope.deleteFuncion = function(param){
                console.log("controler deleteFuncion");
                $state.go('funcionDelete',{funcionId:param});
            };
            $scope.updateFuncion = function(param){
                console.log("controler updateFuncion");
                $state.go('funcionUpdate',{funcionId:param});
            };
            $scope.createFuncion = function(){
                console.log("controler createFuncion");
                $state.go('funcionCreate');
            };
        }
    ]);
}
)(window.angular);