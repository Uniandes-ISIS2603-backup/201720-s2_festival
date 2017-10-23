/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule", ['ui.router']);
    mod.constant("usersContext", "api/users");
    mod.config(['$stateProvider', function ($stateProvider) {
            var basePath = 'src/modules/users/';
            $stateProvider.state('users', {
                url: '/usuario',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'users.html',
                        controller: 'usersController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(angular);