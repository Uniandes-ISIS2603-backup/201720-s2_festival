/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng) {
    var mod = ng.module("usersModule");
    mod.config(function ($stateProvider) {
            var basePath = 'src/modules/users/boletas/detail/calificacion/';
            $stateProvider.state('users.boletas.detail.calificacion', {
                url: '/calificacion',
                views: {
                    'boletasDetailView': {
                        templateUrl: basePath + 'users.boletas.detail.calificacion.html',
                        controller: 'users.boletas.detail.calificacionController',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    );
})(angular);