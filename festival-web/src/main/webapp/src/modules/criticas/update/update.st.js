/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/criticas/update/";
        
        $stateProvider.state("criticas.update", {
            url: "/criticas/{criticasId:int}/update",
            param: {
              criticasId : null  
            },
            views: {
                "criticasDetailView" :{
                    templateUrl: basePath + "update.html",
                    controller: "criticas.updateCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);