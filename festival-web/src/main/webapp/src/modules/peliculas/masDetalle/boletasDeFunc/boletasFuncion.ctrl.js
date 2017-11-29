(function (ng) {
	var mod = ng.module("peliculaAmpliadaModule");
	mod.constant("context", "api/funciones/");
	mod.controller('boletasFuncionCtrl', ['$scope', '$sce', '$http', 'context', '$state',
		function($scope, $sce, $http, context, $state) {

			if($state.params.funcionId !== undefined) {
				$scope.vistasModel = {value : false};
				$scope.tugf = $state.params.funcionId; 
				$('#bannerBoletas').load
			};

			$scope.loadDefaultState = function () {
				console.log('entró ijo de tu re mil pta madre :v ');
				$state.go('boletasFuncionLista' , {funcionId : $state.params.funcionId});
			};
		}]);
})(angular);
