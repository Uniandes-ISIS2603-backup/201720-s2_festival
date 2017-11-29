(function (ng) {
	var mod = ng.module("peliculasModule");
	mod.constant("peliculasContext", "api/peliculas");
	mod.controller('createPeliculaCtrl', ['$scope', '$sce', '$http', 'peliculasContext', '$state',
		function($scope, $sce, $http, peliculasContext, $state) {

			$scope.prepararCorto = function (url){
				var a = url.split("/");
				var b = a[3];
				 
				if(b.match(/watch.*/)){
					var c = b.split("=");
					 
					return "https://www.youtube.com/embed/" + c[1] + "?ecver=2"
				}
				return "https://www.youtube.com/embed/" + a[3] + "?ecver=2";
			};

			$scope.createPelicula = function () {
				$http.post(peliculasContext, {
					name: $scope.peliculaNombre,
					director: $scope.peliculaDirector,
					duracionMinutos: $scope.peliculaDuracion,
					pais: $scope.peliculaPais,
					imagen: $scope.peliculaImagen,
					corto: $scope.prepararCorto($scope.peliculaCorto),
					genero: $scope.peliculaGenero
				}).then(function (response) {
					$state.go('peliculaDetail', {peliculaId: response.data.id}, {reload : true});
				});
			};
		}]);
})(angular);

