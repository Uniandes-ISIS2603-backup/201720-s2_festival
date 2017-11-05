/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("boletasModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/boletas/list/"; 
        
        $stateProvider.state("boletasList", {
            url: "/list",
            parent: 'boletas',
            views: {
                "boletasView": {
                    templateUrl: basePath + "list.html",
                    controller: "boletas.listCtrl",
                    controllerAs: "listCtrl"
                }
            }
        });
    });
})(angular);


