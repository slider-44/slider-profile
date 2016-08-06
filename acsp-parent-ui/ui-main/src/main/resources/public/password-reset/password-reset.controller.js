define(['main/main.router'], function (acsp) {

	acsp.controller("passwordReset", function($scope, $http, $uibModalInstance, acspToastService, $parse){
			
		$scope.model = {};

		$scope.ok = function () {
		    $uibModalInstance.close();
		};
		
		$scope.cancel = function () {
		    $uibModalInstance.dismiss('cancel');
		};
		
		$scope.changeNewPassword = function() {
			
			if ($scope.model.currentInvalidNewPassword == $scope.model.newPassword) {
				
				var serverMessage = $parse('resetPasswordForm.newPassword.$error.serverValidation');
				$scope.resetPasswordForm.newPassword.$setValidity('serverValidation', false);
				serverMessage.assign($scope, "Using previous three passwords is not allowed");
				
			} else {
				
				$scope.resetPasswordForm.newPassword.$setValidity("serverValidation", true);
				
			}
		}
		  
		$scope.change = function() {
			
			if ($scope.model.currentInvalidPassword == $scope.model.currentPassword) {
				
				var serverMessage = $parse('resetPasswordForm.currentPassword.$error.serverValidation');
				$scope.resetPasswordForm.currentPassword.$setValidity('serverValidation', false);
		    	serverMessage.assign($scope, "Invalid Password");
			
			} else {
				
				$scope.resetPasswordForm.currentPassword.$setValidity("serverValidation", true);
			}
		}
		  
		 
		$scope.save = function () {
			  
			$http({
				method : 'POST',
				url : 'command-reset-password',
				dataType: 'json',
				transformRequest : false,
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'},
				data : JSON.stringify({
						currentPassword : $scope.model.currentPassword,
						newPassword : $scope.model.newPassword})
			}).then(function successCallback (serverResponse) {
				
				var response = serverResponse.data;
				
				if(response.responseSuccess) {
					$scope.successTextAlert = "Password reset succesfull!";
					$scope.showSuccessAlert = true;
					
					acspToastService("success", "Password reset succesfull!");
					$uibModalInstance.close();
					
				} else {
					
					$.each(response.responseErrors, function(i,error){
						
						var serverMessage = $parse('resetPasswordForm.' + error.fieldName + '.$error.serverValidation');
						$scope.resetPasswordForm[error.fieldName].$setValidity('serverValidation', false);
						serverMessage.assign($scope, error.fieldError);
					
					});
				    	
				    $scope.model.currentInvalidPassword = $scope.model.currentPassword;
				    $scope.model.currentInvalidNewPassword = $scope.model.newPassword;
				}
			}, function errorCallback(response) {
				
				console.log(response);
				$uibModalInstance.close();
				
			});
			
		};
		
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
	});
	
});