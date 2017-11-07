/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalesModule", ["ui.router"]);
    mod.constant("festivalesContext", "api/festivales/");
    mod.config(["$stateProvider",
        function ($stateProvider){
            var basePath = "src/modules/festivales/";

            $stateProvider.state("festivales", {
                abstract: true,
                views: {
                    "mainView": {
                        templateUrl: basePath + "festivales.html",
                        controller: "festivalesCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
    }]);
})(angular);

