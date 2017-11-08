/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("teatrosModule");
    mod.controller('teatros.listCtrl',['$scope', '$http', 'teatrosContext', '$state',
        function($scope, $http, teatrosContext, $state ){
            $http.get(teatrosContext).then(function(response){
                $scope.teatros = response.data;
            });
        }
    ]);
}
)(angular);

