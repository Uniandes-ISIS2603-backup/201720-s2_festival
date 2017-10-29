/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("sillasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/sillas/create/";
        
        $stateProvider.state("sillas.create", {
            url: "/sillas/create",
            views: {
                "sillasDetailView" :{
                    templateUrl: basePath + "create.html",
                    controller: "sillas.createCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);