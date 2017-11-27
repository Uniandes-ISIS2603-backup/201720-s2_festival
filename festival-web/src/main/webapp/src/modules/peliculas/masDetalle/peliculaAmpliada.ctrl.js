(function (ng) {
	var mod = ng.module("peliculaAmpliadaModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('peliculaDetalladaCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {

			$http.get(peliculasContext + $state.params.peliculaId).then(function (response) {
				$scope.pelicula = response.data;
				$scope.trustSrc = function(src) {
					return $sce.trustAsResourceUrl(src);
				};
				
				$http.get(peliculasContext + $state.params.peliculaId + '/calificaciones').then(function (response) {
					$scope.calificaciones = response.data;
				});

				$http.get(peliculasContext + $state.params.peliculaId + '/funciones').then(function (response) {
					var funciones = response.data;
					var funcionesReturn = new Array();
					console.log('FuncionesLenght: ' + funciones.length);
					for (i = 0; i < funciones.length; i++){

						var inicioSplit = funciones[i].horaInicio.split("T");
						var fecha = inicioSplit[0];
						inicioSplit = inicioSplit[1].split("-");

						var finSplit = funciones[i].horaFin.split("T");
						finSplit = finSplit[1].split("-");

						var funcionN = {
							"no" : (i + 1),
							"fecha" : fecha,
							"horaInicio" : inicioSplit[0],
							"horaFin" : finSplit[0]
						};
						funcionesReturn.push(funcionN);
					};
					console.log('FuncionesRetLenght: ' + funcionesReturn.length);
					$scope.funcionesRet = funcionesReturn;
				});
			});
		}]);
})(angular);
