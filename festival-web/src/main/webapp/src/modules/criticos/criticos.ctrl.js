(function (ng) {
	var mod = ng.module("criticosModule");
	mod.constant("criticosContext", "api/criticos/");
	mod.controller('criticosCtrl', ['$scope', '$sce', '$http', 'criticosContext', '$state',
		function($scope, $sce, $http, criticosContext, $state) {
			$http.get(criticosContext).then(
				function (response) {
					$scope.criticosRecords = response.data;
				});

			if ($state.params.criticoId !== undefined) {
				$http.get(criticosContext + $state.params.criticoId).then(function (response) {
					$scope.critico = response.data;

					$http.get(criticosContext + $state.params.criticoId + '/criticas').then(function (response){
						$scope.criticasDeCritico = response.data;
					});
				});
			};
		}]);
})(angular);