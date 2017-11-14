/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("boletasModule");
    mod.controller("boletas.deleteCtrl", ["$http", "$state", "boletasContext",
        function ($http, $state, boletasContext) {
            $http.delete(boletasContext + $state.params.boletaId, {
            }).then(function () {
                $state.go('boletasList', {}, {location: "replace"});
            });
        }
    ]);
}
)(angular);


