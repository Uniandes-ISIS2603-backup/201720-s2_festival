(function (ng) {
	var mod = ng.module("peliculaAmpliadaModule");
	mod.constant("context", "api/funciones/");
	mod.controller('vistaboletasListaCtrl', ['$scope', '$sce', '$http', 'context', '$state',
		function($scope, $sce, $http, context, $state) {
			
			if($state.params.funcionId !== undefined) {			
				$http.get(context + $state.params.funcionId + '/boletas').then(
					function (response) {
						

						var boletasReturn = [];
						var boletas = response.data;
						for (i = 0; i < boletas.length; i++){
							
							var estado = boletas[i].estado === "DISPONIBLE" ? 1 : (boletas[i].estado === "RESERVADA" ? 2 : 3);
							var boletaN = {
								"id" : boletas[i].id,
								"precio" : boletas[i].precio,
								"codigoDeBarras" : boletas[i].codigoDeBarras,
								"estado" : estado
							};
							boletasReturn.push(boletaN);
						};

						$scope.boletasRet = boletasReturn;
					});
			};
		}]);
})(angular);
