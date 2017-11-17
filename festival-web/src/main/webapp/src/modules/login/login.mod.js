(function (ng) {
    var mod = ng.module('loginModule', ['ui.router']);
    mod.constant("loginContext", "api/login/");
    mod.config(['$stateProvider', 
        function ($stateProvider) {
            var basePath = 'src/modules/login/';
            $stateProvider
                    .state('login', {
                        url: "/login",
                        views : {
                            "mainView": {
                                templateUrl: basePath + "login.html",
                                controller: function ($scope, $http, sillasContext, $state) {
            
                                }
                            },
                            "loginUsuario@login": {
                                templateUrl: basePath + "loginUsuario.html",
                                controller: function ($scope, $http, sillasContext, $state) {
            
                                }
                            },
                            "loginBoleta@login": {
                                templateUrl: basePath + "loginBoleta.html",
                                controller: function ($scope, $http, sillasContext, $state) {
            
                                }
                            }
                        }
                    })
        }]);
})(window.angular);