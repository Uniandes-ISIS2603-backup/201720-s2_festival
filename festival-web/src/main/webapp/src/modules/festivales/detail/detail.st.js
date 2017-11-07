/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("festivalesModule");
    mod.config(function($stateProvider){
        var basePath = "src/modules/festivales/detail/";
        var baseListPath = "src/modules/festivales/list/";
        
        $stateProvider.state("festivales.detail", {
            url:"/festivales/{festivalesId:int}/detail",
            param:{
                festivalesId:null
            },
            views:{
                "teatrosListView":{
                    templateUrl: baseListPath + "festivales.html",
                    controller: "festivales.listCtrl",
                    controllerAs:"ctrl"
                },
                "teatrosDetailView":{
                    templateUrl:basePath + "detail.html",
                    controller:"festivales.detailCtrl",
                    controllerAs:"ctrl"
                }
            }
        });
    });
})(angular);

