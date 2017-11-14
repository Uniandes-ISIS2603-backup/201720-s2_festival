/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("sillasModule");
    mod.config(function ($stateProvider) {
        var basePath = "src/modules/sillas/detail/";

        $stateProvider.state("sillas.detail", {
            url: "/sillas/{sillasId:int}/detail",
            param: {
                sillasId: null
            },
            views: {
                "sillasView": {
                    templateUrl: basePath + "detail.html",
                    controller: "sillas.detailCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);