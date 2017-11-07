/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng){
    var mod = ng.module("festivalesModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/festivales/list/";
        
        $stateProvider.state("festivales.list",{
            url:"/festivales",
            views:{
                "festivalesListView":{
                    templateUrl: basePath + "list.html",
                    controller: "festivales.listCtrl",
                    controllerAs:"ctrl"
                }
            }
        });
    });
})(angular);

