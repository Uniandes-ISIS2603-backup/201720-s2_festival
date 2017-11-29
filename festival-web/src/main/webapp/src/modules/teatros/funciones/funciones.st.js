/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng){
    var mod = ng.module("teatrosModule");
    mod.config(function ($stateProvider){
        var basePath = "src/modules/teatros/funciones/";
        
        $stateProvider.state("teatros.funciones",{
            url:"/teatros/{teatrosId:int}/funciones",
            param:{
                teatrosId:null
            },
            views:{
                "teatrosListView":{
                    templateUrl: basePath + "funciones.html",
                    controller: "teatros.funcionesCtrl",
                    controllerAs:"ctrl"
                }
            }
        });
    });
})(angular);

