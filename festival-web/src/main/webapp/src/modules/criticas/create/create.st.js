/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule");
    mod.config(function ($stateProvider) {
        var basePathDetail = "src/modules/criticas/detail/";

        $stateProvider.state("criticas.create", {
            url: "/criticas/create",
            views: {
                "criticasView": {
                    templateUrl: basePathDetail + "detail.html",
                    controller: "criticas.createCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);