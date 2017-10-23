/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule");
    mod.config(function ($stateProvider) {
            var basePath = 'src/modules/users/detail/';
            $stateProvider.state('users.detail', {
                url: '/detail',
                views: {
                    'usersView': {
                        templateUrl: basePath + 'users.detail.html',
                        controller: 'users.detailController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    );
})(angular);