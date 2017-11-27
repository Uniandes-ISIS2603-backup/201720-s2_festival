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
 				param: {
 					peliculaId: null
 				},
 				views: {
 					"mainView": {
 						templateUrl: basePath + 'peliculaDetallada.html',
 						controller: "peliculaDetalladaCtrl",
 						controllerAs: 'ctrl'
 					} 
 				}
 			})

 		

 			
 		}]);
 })(angular);

