/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalesModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/festivales/update/";
        
        $stateProvider.state("festivales.update", {
            url: "/festivales/{festivalesId:int}/update",
            param: {
              festivalesId : null  
            },
            views: {
                "festivalesDetailView" :{
                    templateUrl: basePath + "update.html",
                    controller: "festivales.updateCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);

