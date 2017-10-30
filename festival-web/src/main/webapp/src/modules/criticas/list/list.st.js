/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("criticasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/criticas/list/"; 
        
        $stateProvider.state("criticas.list", {
            url: "/criticas",
            views: {
                "criticasListView": {
                    templateUrl: basePath + "list.html",
                    controller: "criticas.listCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);