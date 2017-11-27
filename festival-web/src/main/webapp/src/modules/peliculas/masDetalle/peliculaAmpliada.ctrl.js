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

				$scope.calificaciones = new Array();

				$http.get(peliculasContext + $state.params.peliculaId + '/funciones').then(function (response) {

					var funciones = response.data;
					var funcionesReturn = new Array();
					$scope.rutas = new Array();
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


						var rutaCalificaciones = 'api/funciones/' + funciones[i].id + '/calificaciones';
						$scope.rutas.push(rutaCalificaciones);
						console.log('1 -> ' + rutaCalificaciones);
					};
					$scope.funcionesRet = funcionesReturn;


					console.log('rutas -> ' +  $scope.rutas);

					for(i = 0; i < $scope.rutas.length; i++){
						var rutaAct = $scope.rutas[i];
						console.log('Ruta it ' + i + ': ' + rutaAct);
						$http.get(rutaAct).then(function (response) {
							var calificacionAct = respose.data;
							console.log('calificacion Actual: ' + calificacionAct);
							$scope.calificaciones.push(calificacionAct);
						});
					}
				});
			});
		}]);
})(angular);
