/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng){
	var mod = ng.module("criticosModule", ["ui.router"]);
	mod.constant("criticosContext", "api/criticos/");
	mod.config(['$stateProvider', 
		function ($stateProvider){
			var basePath = 'src/modules/criticos/';

			$stateProvider.state('criticos', {
				url: '/criticos',
				abstract: true,
				views: {
					'mainView' : {
						templateUrl: basePath + 'criticos.html',
						controller: 'criticosCtrl',
						controllerAs: 'ctrl'
					}
				}
			})

			.state('criticosList', {
				url: '/list',
				parent: 'criticos',
				views: {
					'listView': {
						templateUrl: basePath + 'criticos.list.html'
					}
				}
			})

			.state('criticoDetail', {
 				url: '/{criticoId:int}/detail',
 				parent: 'criticos',
 				param: {
 					criticoId: null
 				},
 				views: {
 					'listView': {
 						templateUrl: basePath + 'criticos.list.html'
 					},
 					'detailView': {
 						templateUrl: basePath + 'critico.detail.html',
 						controller: 'criticosCtrl',
 						controllerAs: 'ctrl'
 					}
 				}
 			});

		}]);
})(angular);

