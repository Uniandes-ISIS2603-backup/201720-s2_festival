(function (ng) {
    var mod = ng.module("calificacionesModule", ['ui.router']);
    mod.constant("calificacionesContext", "api/calificaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/calificaciones/';
            $urlRouterProvider.otherwise("/calificacionesList");

            $stateProvider.state('calificaciones', {
                url: '/calificaciones',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'calificaciones.html',
                        controller: 'calificacionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('calificacionesList', {
                url: '/list',
                parent: 'calificaciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'calificaciones.list.html'
                    }
                }
            }).state('crearCalificacion', {
                url: '/crearCalificacion',
                parent: 'calificaciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'crearCalificacion.html',
                        controller: "calificaciones.createCtrl",
                        controllerAs : "ctrl"
                    }

                }

            
            }).state('update', {
                url: '/update/{calificacionId:int}',
                parent: 'calificaciones',
                param: {
                    calificacionId : null  
                  },
                views: {
                    'listView': {
                        templateUrl: basePath + 'update.html',
                        controller: "calificaciones.updateCtrl",
                        controllerAs: "ctrl"
                    }

                }
            }).state("calificacionDelete", {
                url: "/calificaciones/{calificacionId:int}/delete",
                parent: 'calificaciones',
                param: {
                  calificacionId : null  
                },
                views: {
                    listView :{
//                        templateUrl: basePath + 'calificaciones.list.html',
                        controller: "calificaciones.deleteCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
        }]);
})(window.angular);
