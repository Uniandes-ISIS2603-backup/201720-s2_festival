/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("teatrosModule", ["ui.router"]);
    mod.constant("teatrosContext", "api/teatros/");
    mod.config(["$stateProvider",
        function ($stateProvider){
            var basePath = "src/modules/teatros/";

            $stateProvider.state("teatros", {
                abstract: true,
                views: {
                    "mainView": {
                        templateUrl: basePath + "teatros.html",
                        controller: "teatrosCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
    }]);
})(angular);

