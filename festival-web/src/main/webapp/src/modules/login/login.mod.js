(function (ng) {
    var mod = ng.module('loginModule', ['ui.router']);
    mod.constant("loginContext", "api/login/");
    mod.config(['$stateProvider', 
        function ($stateProvider) {
            var basePath = 'src/modules/login/';
            $stateProvider
                    .state('login', {
                        url: "/login",
                        data: {
                            requireLogin: false
                        },
                        views : {
                            "mainView": {
                                templateUrl: basePath + "login.html",
                                controller: function ($scope, $http, $state) {
            
                                }
                            },
                            "loginUsuario@login": {
                                templateUrl: basePath + "loginUsuario.html",
                                controller: function ($scope, $http, $state, $rootScope) {
                                    $scope.user = {};
                                    $scope.data = {};
                                    $http.get('data/users.json').then(function (response) {
                                        $scope.users = response.data;
                                    });
                                    $scope.autenticar = function () {
                                        var flag = false;
                                        for (var item in $scope.users) {
                                            if ($scope.users[item].user === $scope.data.username && $scope.users[item].password === $scope.data.password && $scope.users[item].rol === $scope.data.rol) {
                                                flag = true;
                                                $scope.user = $scope.users[item];
                                                $state.go('peliculasList', {}, {reload:true});
                                                break;
                                            }
                                        }
                                        if (!flag) {
                                            $rootScope.alerts.push({type: "danger", msg: "Nombre de usuario o contraseña incorrectos"});
                                        } else {
                                            sessionStorage.token = $scope.user.token;
                                            sessionStorage.setItem("username", $scope.user.user);
                                            sessionStorage.setItem("name", $scope.user.name);
                                            sessionStorage.setItem("rol", $scope.user.rol);
                                            $rootScope.currentUser = $scope.user.name;
                                        }
                                    }
                                }
                            },
                            "loginBoleta@login": {
                                templateUrl: basePath + "loginBoleta.html",
                                controller: function ($scope, $http, $state) {
            
                                }
                            }
                        }
                    })
                    .state('logout', {
                        url: '/logout',
                        data: {
                            requireLogin: false,
                            roles: []
                        },
                        views: {
                            'mainView': {
                                templateUrl: basePath + 'logout.html',
                                controller: function($state) {
                                    if (sessionStorage.getItem("username")) {
                                        sessionStorage.clear();
                                    } else {
                                        $state.go('booksList', {}, {reload: true});
                                    }
                                }
                            }
                        }
                    })
        }]);
})(window.angular);