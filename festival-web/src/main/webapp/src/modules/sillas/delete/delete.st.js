/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("sillasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/sillas/delete/";
        
        $stateProvider.state("sillas.delete", {
            url: "/sillas/{sillasId:int}/delete",
            param: {
              sillasId : null  
            },
            views: {
                "sillasDetailView" :{
//                    templateUrl: basePath + "delete.html",
                    controller: "sillas.deleteCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);