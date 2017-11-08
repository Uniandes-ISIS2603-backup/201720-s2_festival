/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng){
    var mod = ng.module("teatrosModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/teatros/list/";
        
        $stateProvider.state("teatros.list",{
            url:"/teatros",
            views:{
                "teatrosListView":{
                    templateUrl: basePath + "list.html",
                    controller: "teatros.listCtrl",
                    controllerAs:"ctrl"
                }
            }
        });
    });
})(angular);
