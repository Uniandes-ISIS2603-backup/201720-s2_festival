/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule");
    mod.config(function ($stateProvider){
        
        $stateProvider.state("criticas.delete", {
            url: "/criticas/{criticasId:int}/delete",
            param: {
              criticasId : null  
            },
            views: {
                "criticasDetailView" :{
                    controller: "criticas.deleteCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);