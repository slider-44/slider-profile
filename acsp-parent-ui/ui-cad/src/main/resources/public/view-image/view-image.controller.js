'use strict';

define(['main/main.module'], function (acsp) {
	
	acsp.register.controller('salesImageController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService){
		
		  $scope.reset = function(){
			  $scope.spinShow = false;
			  $scope.displayImage = false;
			  $scope.model = {};
		  }
		  
		  $scope.reset();
		  
		  $scope.search = function(){
			  
			  $scope.spinShow = true;
			  
			  $http({
				  url : 'query-sales-image/' + $scope.model.customerCd,
				  method : "GET"
			  }).then(
					  function(data) {
						  if(data.data && data.data.length > 0) {
							  $scope.model.images = data.data;
							  $scope.displayImage = true;
						  } else {
							  acspToastService("warning", "No image found.");
							  $scope.displayImage = false;
						  }
						  
						  $scope.spinShow = false;  
					  },
					  function(error) {
						  acspToastService("warning", "Errors encountered during search.");
						  $scope.spinShow = false;
						  $scope.displayImage = false;
					  });
		  }
	});	
});

