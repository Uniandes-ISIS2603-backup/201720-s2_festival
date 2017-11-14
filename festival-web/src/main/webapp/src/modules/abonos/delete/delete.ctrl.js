/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("abonosModule");
    mod.controller("abonos.deleteCtrl", ["$http", "$state", "abonosContext",
        function ($http, $state, abonosContext) {
            $http.delete(abonosContext + $state.params.abonoId, {
            }).then(function () {
                $state.go('abonosList', {}, {location: "replace"});
            });
        }
    ]);
}
)(angular);