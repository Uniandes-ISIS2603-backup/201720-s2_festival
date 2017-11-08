(function (ng) {
	var mod = ng.module("peliculasModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('updatePeliculaCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {
			if ($state.params.peliculaModfId !== undefined) {
				$http.get(peliculasContext + $state.params.peliculaModfId).then(function (response) {
					$scope.peliculaMd = response.data;
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
					creditos: $scope.peliculaCreditos,
					corto: $scope.peliculaCorto,
					genero: $scope.peliculaGenero
				}).then(function (response) {
					$state.go('peliculaDetail', {peliculaId: response.data.id}, {reload : true});
				});
			};
			
		}]);
})(angular);
