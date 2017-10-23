/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule");
    mod.config(function ($stateProvider) {
            var basePath = 'src/modules/users/boletas/';
            $stateProvider.state('users.boletas', {
                url: '/boletas',
                abstract: true,
                views: {
                    'usersView': {
                        templateUrl: basePath + 'users.boletas.html',
                        controller: 'users.boletasController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    );
})(angular);