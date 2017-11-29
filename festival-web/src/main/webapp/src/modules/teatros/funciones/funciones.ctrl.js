/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 (function(ng){
 	var mod = ng.module("teatrosModule");
 	mod.controller('teatros.funcionesCtrl',['$scope', '$http', 'teatrosContext', '$state',
 		function($scope, $http, teatrosContext, $state ){
 			 
 			$http.get(teatrosContext + $state.params.teatrosId +"/funciones").then(function(response){
 				
 				$scope.funciones = response.data;
 				$scope.hoverIn = function(){
 					this.hoverEdit = true;
 				};

 				$scope.hoverOut = function(){
 					this.hoverEdit = false;
 				};
 				
 			});
 			
 			
 			
 		}
 		]);
 }
 )(angular);

