/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("teatrosModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/teatros/update/";
        
        $stateProvider.state("teatros.update", {
            url: "/teatros/{teatrosId:int}/update",
            param: {
              sillasId : null  
            },
            views: {
                "sillasDetailView" :{
                    templateUrl: basePath + "update.html",
                    controller: "teatros.updateCtrl",
                    controllerAs: "ctrl"
                }
            },
            data: {
                requireLogin: true,
                roles: ['admin', 'assistant']
            }
        });
    });
})(angular);
