/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule", ["ui.router"]);
    mod.constant("criticasContext", "api/criticas/");
    mod.config(["$stateProvider",
        function ($stateProvider) {
            var basePath = "src/modules/criticas/";

            $stateProvider.state("criticas", {
                abstract: true,
                views: {
                    "mainView": {
                        templateUrl: basePath + "criticas.html",
                        controller: "criticasCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
        }]);
})(angular);