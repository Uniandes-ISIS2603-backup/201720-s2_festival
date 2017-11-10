(function (ng) {
	var mod = ng.module("peliculasModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('updatePeliculaCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {
			if ($state.params.peliculaModfId !== undefined) {
				$http.get(peliculasContext + $state.params.peliculaModfId).then(function (response) {
					$scope.peliculaMd = response.data;
					$scope.peliculaNombre = $scope.peliculaMd.name;
					$scope.peliculaDirector = $scope.peliculaMd.director;
					$scope.peliculaDuracion = $scope.peliculaMd.duracionMinutos;
					$scope.peliculaPais =  $scope.peliculaMd.pais;
					$scope.peliculaImagen = $scope.peliculaMd.imagen;
					$scope.peliculaCorto = $scope.peliculaMd.corto;
					$scope.peliculaGenero = $scope.peliculaMd.genero;

					$scope.trustSrc = function(src) {
						return $sce.trustAsResourceUrl(src);
					};
				});
			};

			$scope.updatePelicula =  function () {
				$http.put(peliculasContext + $state.params.peliculaModfId, {
					name: $scope.peliculaNombre,
					director: $scope.peliculaDirector,
					duracionMinutos: $scope.peliculaDuracion,
					pais: $scope.peliculaPais,
					imagen: $scope.peliculaimagen,
					corto: $scope.peliculaCorto,
					genero: $scope.peliculaGenero
				}).then(function (response) {
					$state.go('peliculaDetail', {peliculaId: response.data.id}, {reload : true});
				});
			};

		}]);
})(angular);
