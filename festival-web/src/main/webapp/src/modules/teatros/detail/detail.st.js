/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("teatrosModule");
    mod.config(function($stateProvider){
        var basePath = "src/modules/teatros/detail/";
        var baseListPath = "src/modules/teatros/list/";
        
        $stateProvider.state("teatros.detail", {
            url:"/teatros/{teatrosId:int}/detail",
            param:{
                teatrosId:null
            },
            views:{
                "teatrosListView":{
                    templateUrl: baseListPath + "list.html",
                    controller: "teatros.listCtrl",
                    controllerAs:"ctrl"
                },
                "teatrosDetailView":{
                    templateUrl:basePath + "detail.html",
                    controller:"teatros.detailCtrl",
                    controllerAs:"ctrl"
                }
            }
        });
    });
})(angular);

