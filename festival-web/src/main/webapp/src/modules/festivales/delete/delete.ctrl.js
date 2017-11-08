/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("festivalesModule");
    mod.config(function ($stateProvider){
        
        $stateProvider.state("festivales.delete", {
            url: "/festivales/{festivalesId:int}/delete",
            param: {
              festivalesId : null  
            },
            views: {
                "festivalesDetailView" :{
                    controller: "festivales.deleteCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);

