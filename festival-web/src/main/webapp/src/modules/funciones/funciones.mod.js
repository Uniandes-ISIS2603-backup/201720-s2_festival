(function (ng) {
    var mod = ng.module("funcionesModule", ['ui.router']);
    mod.constant("funcionesContext", "api/funciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/funciones/';
            $urlRouterProvider.otherwise("/peliculasList");

            $stateProvider.state('funciones', {
                url: '/funciones',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'funciones.html',
                        controller: 'funcionesCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('funcionesList', {
                url: '/list',
                parent: 'funciones',
                views: {
                    'listView': {
                        templateUrl: basePath + 'funciones.list.html'
                    }
                }
            }).state('funcionDetail', {
                url: '/{funcionId:int}/detail',
                parent: 'funciones',
                param: {
                    funcionId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'funciones.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'funciones.detail.html',
                        controller: 'funcionesCtrl',
                        controllerAs: 'ctrl'
                    }

                }
            }).state('funcionDelete', {
                url: '/{funcionId:int}/delete',
                parent: 'funciones',
                param: {
                    funcionId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'funciones.list.html',
                        controller : "funciones.deleteCtrl",
                        controllerAs : "ctrl"
                    }

                }
             }).state('funcionCreate', {
                url: '/funcion/create',
                parent: 'funciones',
                
                views: {
                    'listView': {
                        templateUrl: basePath + 'create.html',
                        controller : "funciones.createCtrl",
                        controllerAs : "ctrl"
                    }

                }
                }).state('funcionUpdate', {
                url: '/{funcionId:int}/update',
                parent: 'funciones',
                
                views: {
                    'listView': {
                        templateUrl: basePath + 'update.html',
                        controller : "funciones.updateCtrl",
                        controllerAs : "ctrl"
                    }

                }
            });
        }]);
})(window.angular);
