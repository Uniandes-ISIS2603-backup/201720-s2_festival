/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 (function (ng){
 	var mod = ng.module("peliculaAmpliadaModule", ["ui.router", "ngSanitize"]);
 	mod.constant("peliculasContext", "api/peliculas/");
 	mod.config(['$stateProvider', '$urlRouterProvider', 
 		function($stateProvider, $urlRouterProvider){

 			var basePath = 'src/modules/peliculas/masDetalle/';
 			$stateProvider.state('peliculaAmpliada', {
 				url: '/peliculas/{peliculaId:int}/inf',
 				params: {
 					peliculaId: null,
 					comprada : null,
 					idBoletaComprada : null
 				},
 				views: {
 					"mainView": {
 						templateUrl: basePath + 'peliculaDetallada.html',
 						controller: "peliculaDetalladaCtrl",
 						controllerAs: 'ctrl'
 					} 
 				}
 			})

 			.state('boletasDeFuncion', {
 				url: '/funciones/{funcionId:int}/boletas',
 				param: {
 					funcionId: null
 				},
 				parent: 'peliculaAmpliada' ,
 				views: {
 					'mainView': {
 						templateUrl: basePath + 'peliculaDetallada.html'
 					},

 					"funcBoletasView": {
 						templateUrl: basePath + 'boletasDeFunc/boletasFunc.html',
 						controller: "boletasFuncionCtrl",
 						controllerAs: 'ctrl'
 					} 
 				}
 			}).state('boletasFuncionLista', {
 				url: '/lista',
 				param: {
 					funcionId: null
 				},
 				parent: 'boletasDeFuncion' ,
 				views: {
 					"funcBoletasView": {
 						templateUrl: basePath + 'boletasDeFunc/boletasFunc.html'
 					},

 					"vistaVarible": {
 						templateUrl: basePath + 'boletasDeFunc/vistaBoletasLista/boletasFuncionEnLista.html',
 						controller: "vistaboletasListaCtrl",
 						controllerAs: 'ctrl'
 					} 
 				}
 			});

 			$stateProvider.state('funcionesBoletasDetalle', {
 				url: '/detalle',
 				param: {
 					funcionId: null
 				},
 				parent: 'boletasDeFuncion',
 				views: {
 					"funcBoletasView": {
 						templateUrl: basePath + 'boletasDeFunc/boletasFunc.html'
 					},
 					'vistaVarible': {
 						templateUrl: basePath + 'boletasDeFunc/vistaBoletasDetalle/boletasDeFuncionDetalle.html',
 						controller: 'vistaBoletasDeFuncionDetalleCtrl',
 						controllerAs: 'ctrl'
 					}

 				}
 			});

 			
 		}]);
 })(angular);

