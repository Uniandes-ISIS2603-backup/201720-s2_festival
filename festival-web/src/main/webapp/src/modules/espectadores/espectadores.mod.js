/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng){
	var mod = ng.module("espectadoresModule", ["ui.router"]);
	mod.constant("espectadoresContext", "api/espectadores/");
	mod.config(['$stateProvider', 
		function ($stateProvider){
			var basePath = 'src/modules/espectadores/';

			$stateProvider.state('espectadores', {
				url: '/espectadores',
				abstract: false,
				views: {
					'mainView' : {
						templateUrl: basePath + 'espectadores.html',
						controller: 'espectadoresCtrl',
						controllerAs: 'ctrl'
					}
				}
			})

			.state('espectadoresList', {
				url: '/list',
				parent: 'espectadores',
				views: {
					'listView': {
						templateUrl: basePath + 'espectadores.list.html'
					}
				}
			})
		}]);
})(angular);

