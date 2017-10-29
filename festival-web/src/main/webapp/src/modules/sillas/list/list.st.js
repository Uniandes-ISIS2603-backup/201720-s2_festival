/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("sillasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/sillas/list/"; 
        
        $stateProvider.state("sillas.list", {
            url: "/sillas",
            views: {
                "sillasListView": {
                    templateUrl: basePath + "list.html",
                    controller: "sillas.listCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);