/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("sillasModule", ["ui.router"]);
    mod.constant("sillasContext", "api/sillas/");
    mod.config(["$stateProvider",
        function ($stateProvider){
            var basePath = "src/modules/sillas/";

            $stateProvider.state("sillas", {
                abstract: true,
                views: {
                    "mainView": {
                        templateUrl: basePath + "sillas.html",
                        controller: "sillasCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
    }]);
})(angular);