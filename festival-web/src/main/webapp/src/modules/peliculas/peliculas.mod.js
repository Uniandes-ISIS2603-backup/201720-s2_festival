/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 (function (ng){
 	var mod = ng.module("peliculasModule", ["ui.router", "ngSanitize"]);
 	mod.constant("peliculasContext", "api/peliculas/");
 	mod.config(['$stateProvider', '$urlRouterProvider', 
 		function($stateProvider, $urlRouterProvider){

 			var basePath = 'src/modules/peliculas/';
 			$stateProvider.state('peliculas', {
 				url: '/peliculas',
 				abstract : true,
 				views: {
 					"mainView": {
 						templateUrl: basePath + 'peliculas.html',
 						controller: "peliculasCtrl",
 						controllerAs: 'ctrl'
 					} 
 				}
 			})


 			.state("peliculasList", {
 				url: '/list',
 				parent: 'peliculas',
 				views: {
 					'listView' :  {
 						templateUrl: basePath + 'peliculas.list.html'
 					}
 				}
 			})


 			.state('peliculaDetail', {
 				url: '/{peliculaId:int}/detail',
 				parent: 'peliculas',
 				param: {
 					peliculaId: null
 				},
 				views: {
 					'listView': {
 						templateUrl: basePath + 'peliculas.list.html'
 					},
 					'detailView': {
 						templateUrl: basePath + 'peliculas.detail.html',
 						controller: 'peliculasCtrl',
 						controllerAs: 'ctrl'
 					}
 				}
 			})


 			.state('verCorto', {
 				url: '/corto',
 				parent: 'peliculaDetail',
 				views: {
 					'cortoView': {
 						templateUrl: function () { 
 							return basePath + 'peliculas.corto.html';
 						},
 						controller: 'peliculasCtrl',
 						controllerAs: "ctrl"
 					}
 				}
 			})

 			.state('createPelicula', {
 				url: '/create',
 				parent: 'peliculas',
 				views: {
 					'listView': {
 						templateUrl: basePath + 'peliculas.list.html'
 					},
 					'createPeliculaView': {
 						controller: 'createPeliculaCtrl',
 						controllerAs: 'crtl',
 						templateUrl: basePath + 'createPelicula.html'
 					}
 				}	
 			});


 			$stateProvider.state('updatePelicula',{
 				url: '/{peliculaModfId:int}/update',
 				parent: 'peliculas',
 				param:{
 					peliculaModfId: null
 				},
 				views: {
 					'listView': {
 						templateUrl: basePath + 'peliculas.list.html'
 					},
 					'updatePeliculaView': {
 						controller: 'updatePeliculaCtrl',
 						controllerAs: 'crtl',
 						templateUrl: basePath + 'updatePelicula.html'
 					}
 				}
 			});

 			$stateProvider.state('deletePelicula', {
 				url: '/{peliculaDeleteId:int}/delete',
 				parent: 'peliculas',
 				param: {
 					peliculaDeleteId: null
 				},
 				views: {
 					'listView': {
 						templateUrl: basePath + 'peliculas.list.html',
 						controller: 'peliculasCtrl',
 						controllerAs: "ctrl"
 					}
 				}
 			});


 		}]);
 })(angular);

