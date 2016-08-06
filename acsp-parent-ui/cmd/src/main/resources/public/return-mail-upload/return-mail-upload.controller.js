'use strict';

define(['main/main.module'], function (acsp) {
	
	acsp.register.service('uploadReturnedMailSvc', ['$http', '$rootScope', 'acspToastService', 
	                                                function ($http, $rootScope, acspToastService) {
	  this.uploadFileToUrl = function(file, uploadUrl, scope){
		  var fd = new FormData();
		  fd.append('file', file);
	    
		  $http.post(uploadUrl, fd, {
			  transformRequest: angular.identity,
			  headers: {'Content-Type': undefined}
		  })
		  .success(function(data){
			  if(data.responseSuccess){
				  acspToastService("success", "Upload of data was successful.");
				  
			  } else {
				  acspToastService("warning", "Errors encountered during upload.");
				  
			  }
			  
			  scope.model.result = data;
			  scope.spinShow = false;
		  })
		  .error(function(data){
			  scope.spinShow = false;
		  });
	  }
	}]);

	acsp.register.controller('uploadReturnedMailCtrl', ['$scope', 'uploadReturnedMailSvc', 
	                                                    function($scope, uploadReturnedMailSvc){
	  $scope.spinShow = false;
	  $scope.model = {};
	  
	  $scope.cancel = function(){
		  $scope.model = {};
		  $("#uploadReturnedMail").val("");
	  }
	  
	  $scope.uploadFile = function(){
	    var file = $scope.model.uploadReturnedMail;  
	    $scope.spinShow = true;
	       
	    var uploadUrl = "/zuul/command-cmd-return-mail-upload";
	    uploadReturnedMailSvc.uploadFileToUrl(file, uploadUrl, $scope);
	  };

	}]);
	
});

