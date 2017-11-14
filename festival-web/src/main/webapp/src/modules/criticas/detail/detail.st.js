/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule");
    mod.config(function ($stateProvider) {
        var basePath = "src/modules/criticas/detail/";

        $stateProvider.state("criticas.detail", {
            url: "/criticas/{criticasId:int}/detail",
            param: {
                criticasId: null
            },
            views: {
                "criticasView": {
                    templateUrl: basePath + "detail.html",
                    controller: "criticas.detailCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);