/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("sillasModule");
    mod.config(function ($stateProvider) {
        var basePathDetail = "src/modules/sillas/detail/";

        $stateProvider.state("sillas.update", {
            url: "/sillas/{sillasId:int}/update",
            param: {
                sillasId: null
            },
            views: {
                "sillasView": {
                    templateUrl: basePathDetail + "detail.html",
                    controller: "sillas.updateCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);