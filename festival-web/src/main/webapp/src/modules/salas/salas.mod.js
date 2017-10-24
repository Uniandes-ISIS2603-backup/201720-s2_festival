/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = angular.module('salasModule', ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
             var basePath = 'src/modules/salas/';
            $urlRouterProvider.otherwise("/salas");
            $stateProvider
                .state('salas', {
                    url: "/salas",
                    views: {
                        "": {templateUrl: basePath+"salas.html"}
                    }
                });
        }]);
})(window.angular);

