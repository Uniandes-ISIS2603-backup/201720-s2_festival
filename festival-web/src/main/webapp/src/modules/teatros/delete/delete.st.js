
(function (ng) {
    var mod = ng.module("teatrosModule");
    mod.config(function ($stateProvider){
        
        $stateProvider.state("teatros.delete", {
            url: "/teatros/{teatrosId:int}/delete",
            param: {
              teatrosId : null  
            },
            views: {
                "teatrosDetailView" :{
                    controller: "teatros.deleteCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
    });
})(angular);