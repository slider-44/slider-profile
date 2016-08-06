'use strict';

define(['main/main.module'], function (acsp) {
/**
 * Controller for Search
 * @Author Elizabeth Laguardia
 * 07132016
 */	
	
	acsp.register.controller('searchAccountController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.model = {};
		
		
		$scope.move = function(_data) {
			$rootScope.$broadcast('cs-record-select', _data);
		};
		
		$scope.fn_load = function() {
			
			$http({
					url: 'query-account-details',
					method: "GET",
					
				}).then (function (data) {
				
				$scope.model = data.data;
				});
			}
	})
	
	acsp.register.controller('editAccountController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		
		var clear = function(){
			$scope.model = {};
		};
		
		
		(function (){
			
			clear();
			
			$scope.$on('cs-record-select', function(event, args) {
			
				$scope.model.usercd = args.usercd;
				$scope.model.firstName = args.firstName;
				$scope.model.lastName = args.lastName;
				$scope.model.email = args.email;
				
			});
		
		})();
		
		
	})
});