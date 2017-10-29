/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("sillasModule");
    mod.controller("sillas.deleteCtrl", ["$http", "$state", "sillasContext",  
        function ($http, $state, sillasContext) {
            $http.delete(sillasContext + $state.params.sillasId, {
            }).then(function () {
                //Silla created successfully.
                $state.go('sillas.list',{},{location:"replace"});
            });
        }
    ]);
}
)(angular);

