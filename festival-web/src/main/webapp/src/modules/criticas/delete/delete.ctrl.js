/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("criticasModule");
    mod.controller("criticas.deleteCtrl", ["$http", "$state", "criticasContext",
        function ($http, $state, criticasContext) {
            $http.delete(criticasContext + $state.params.criticasId, {
            }).then(function () {
                $state.go('criticas.list', {}, {location: "replace"});
            });
        }
    ]);
}
)(angular);

