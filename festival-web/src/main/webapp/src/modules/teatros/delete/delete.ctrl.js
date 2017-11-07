/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("teatrosModule");
    mod.controller("teatros.deleteCtrl", ["$http", "$state", "teatrosContext",  
        function ($http, $state, teatrosContext) {
            $http.delete(teatrosContext + $state.params.teatrosId, {
            }).then(function () {
                $state.go('teatros.list',{},{location:"replace"});
            });
        }
    ]);
}
)(angular);

