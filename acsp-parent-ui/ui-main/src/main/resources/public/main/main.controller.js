'use strict';

define(['main/main.router'], function (acsp) {
	
	/**
	 * Handles support for CSRF
	 * Also handles the retrieval of current user information.
	 */
	acsp.controller("authentication",
			['$scope', '$http', '$q', '$location', '$uibModal',
			function($scope, $http, $q, $location, $uibModal){
		
		$scope.user = ACSP_DATA.currentUser;
		
		$scope.resetPassword = function() {
			
			 var modalInstance = $uibModal.open({
			      animation: $scope.animationsEnabled,
			      templateUrl: 'password-reset/password-reset.html',
			      controller: 'passwordReset'
			 });
		}
				
		$scope.logout = function(){
			
			$http({
				url : '/logout',
				method : "POST",
				headers: {
			    	'XSRF-TOKEN': Cookies.get('XSRF-TOKEN')
			    }
			}).then(function(data) {
						window.location = "/signin"
					},
					function(data){
						console.log("ERROR");
						console.log(data.data);
						window.location = "/signin"
					}
			);
		}
		
	}]);

});