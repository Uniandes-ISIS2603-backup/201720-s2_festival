/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule");
    mod.config(function ($stateProvider) {
            var basePath = 'src/modules/users/create/';
            $stateProvider.state('users.create', {
                url: '/create',
                views: {
                    'usersView': {
                        templateUrl: basePath + 'users.create.html',
                        controller: 'users.createController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    );
})(angular);