/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule");
    mod.config(function ($stateProvider) {
            var basePath = 'src/modules/users/boletas/detail/';
            $stateProvider.state('users.boletas.detail', {
                url: '/detail',
                views: {
                    'boletasView': {
                        templateUrl: basePath + 'users.boletas.detail.html',
                        controller: 'users.boletas.detailController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    );
})(angular);