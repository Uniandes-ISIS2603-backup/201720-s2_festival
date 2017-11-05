(function (ng) {
	var mod = ng.module("peliculasModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('createPeliculaCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {
			$scope.createPelicula = function () {
				$http.post(peliculasContext, {
					name: $scope.peliculaNombre,
					director: $scope.peliculaDirector,
					duracionMinutos: $scope.peliculaDuracion,
					pais: $scope.peliculaPais,
					creditos: $scope.peliculaCreditos,
					corto: $scope.peliculaCorto,
					genero: $scope.peliculaGenero
				}).then(function (response) {
					$state.go('peliculaDetail', {peliculaId: response.data.id})
				});
			}
		}]);
})(angular);

