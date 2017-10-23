/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule");
    mod.config(function ($stateProvider) {
            var basePath = 'src/modules/users/login/';
            $stateProvider.state('users.login', {
                url: '/login',
                views: {
                    'usersView': {
                        templateUrl: basePath + 'users.login.html',
                        controller: 'users.loginController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    );
})(angular);