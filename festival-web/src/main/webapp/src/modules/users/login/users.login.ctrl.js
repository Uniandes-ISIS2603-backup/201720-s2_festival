/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){
    var mod = ng.module("usersModule");
    mod.controller('users.loginController', ['$scope', '$http', 'usersContext', '$state',
        function ($scope, $http, usersContext, $state) {
//            $http.get(authorsContext).then(function (response) {
//                $scope.authorsRecords = response.data;
//            });
//
//            if ($state.params.authorId !== undefined) {
//                $http.get(authorsContext + '/' + $state.params.authorId).then(function (response) {
//                    $scope.booksRecords = response.data.books;
//                    $scope.currentAuthor = response.data;
//                });
//            }
        }
    ]);
})(angular);