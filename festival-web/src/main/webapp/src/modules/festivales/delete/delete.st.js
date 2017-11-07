/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalesModule");
    mod.controller("festivales.deleteCtrl", ["$http", "$state", "festivalesContext",  
        function ($http, $state, festivalesContext) {
            $http.delete(festivalesContext + $state.params.festivalesId, {
            }).then(function () {
                $state.go('festivales.list',{},{location:"replace"});
            });
        }
    ]);
}
)(angular);

