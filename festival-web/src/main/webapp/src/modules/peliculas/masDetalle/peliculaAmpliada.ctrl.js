(function (ng) {
	var mod = ng.module("peliculaAmpliadaModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('peliculaDetalladaCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {


			$scope.sortType     = 'id'; 
			$scope.sortReverse  = false; 

			$scope.onLoad = function () { 
				 
				 
				if($state.params.idBoletaComprada !== undefined && $state.params.comprada !== undefined){
					 
					if($state.params.comprada == true){
						document.getElementById('elPapaDelModal').removeChild(document.getElementById('cajaFunciones'));
						 
						
						$state.go('boletasTake', {boletasId : $state.params.idBoletaComprada}, {reload : true, notify: true});
						

					}
				};
			};
			$http.get(peliculasContext + $state.params.peliculaId).then(function (response) {
				$scope.pelicula = response.data;
				$scope.trustSrc = function(src) {
					return $sce.trustAsResourceUrl(src);
				};

				$http.get(peliculasContext + $state.params.peliculaId + '/calificaciones').then(function (response) {
					$scope.calificaciones = response.data;
					$scope.totalCal = $scope.calificaciones.length;
				});

				$http.get(peliculasContext + $state.params.peliculaId + '/promedioCalificaciones').then(function (response) {

					$scope.darPromEstrella = function (numero){ 
						var num = numero == 0 ? parseFloat(parseFloat(0.000)) : (numero < 0.667 ? parseFloat(0.333) : (numero < 1.000 ? parseFloat(0.667) : (numero < 1.333 ? parseFloat(1.000) : (numero < 1.667 ? parseFloat(1.333) : (numero < 2.000 ? parseFloat(parseFloat(1.667)) : (numero < 2.333 ? parseFloat(2.000) : (numero < 2.667 ? parseFloat(2.333) : (numero < 3.000 ? parseFloat(2.667) : (numero < 3.333 ? parseFloat(3.000) : (numero < 3.667 ? parseFloat(3.333) : (numero < 4.000 ? parseFloat(3.667) : (numero < 4.333 ? parseFloat(4.000) : (numero < 4.667 ? parseFloat(4.333) : (numero < 5.000 ? parseFloat(4.667) : parseFloat(5.000)))))))))))))));

						var numRond = num.toFixed(3);
						return numRond;
					};
					$scope.promedio = response.data.calificacion ;

					$scope.darPromedioRond = function (num, digits) {
						return parseFloat(Math.round(num * 100) / 100).toFixed(digits);
					};

				});

				$http.get(peliculasContext + $state.params.peliculaId + '/funciones').then(function (response) {
					var funciones = response.data;
					var funcionesReturn = new Array();
					for (i = 0; i < funciones.length; i++){
						var id = funciones[i].id;
						var inicioSplit = funciones[i].horaInicio.split("T");
						var fecha = inicioSplit[0];
						inicioSplit = inicioSplit[1].split("-");

						var finSplit = funciones[i].horaFin.split("T");
						finSplit = finSplit[1].split("-");

						var funcionN = {
							"id" : id,
							"no" : (i + 1),
							"fecha" : fecha,
							"horaInicio" : inicioSplit[0],
							"horaFin" : finSplit[0]
						};
						funcionesReturn.push(funcionN);
					};

					$scope.funcionesRet = funcionesReturn;

					$scope.hoverIn = function(){
						this.hoverEdit = true;
					};

					$scope.hoverOut = function(){
						this.hoverEdit = false;
					};
				});
			});
		}]);
})(angular);
