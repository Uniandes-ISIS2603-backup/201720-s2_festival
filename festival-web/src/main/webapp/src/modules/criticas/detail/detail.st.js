/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/criticas/detail/";
        var baseListPath = "src/modules/criticas/list/";
        
        $stateProvider.state("criticas.detail", {
            url: "/criticas/{criticasId:int}/detail",
            param: {
              criticasId : null  
            },
            views: {
                "criticasListView": {
                    templateUrl: baseListPath + "list.html",
                    controller: "criticas.listCtrl",
                    controllerAs: "ctrl"
                },
                "criticasDetailView" :{
                    templateUrl: basePath + "detail.html",
                    controller: "criticas.detailCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);