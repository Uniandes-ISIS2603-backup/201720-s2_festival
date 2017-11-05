(function (ng) {
	var mod = ng.module("peliculasModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('peliculasCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {
			$http.get(peliculasContext).then(
				function (response) {
					$scope.peliculasRecords = response.data;
				});

			if ($state.params.peliculaId !== undefined) {
				$http.get(peliculasContext + $state.params.peliculaId).then(function (response) {
					$scope.pelicula = response.data;
					$scope.trustSrc = function(src) {
						return $sce.trustAsResourceUrl(src);
					};
				});
			};
		}]);
})(angular);


