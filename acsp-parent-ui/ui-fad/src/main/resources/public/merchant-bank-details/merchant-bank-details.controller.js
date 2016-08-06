'use strict';

define(['main/main.module'], function (acsp) {
	
	/**
	 * Controller for Search
	 * @Author Elizabeth Laguardia
	 * 06162016
	 */

	acsp.register.controller('merchantBankDetailsController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.model = {};
		
		$scope.$on('merchant_save', function(event, args) {
			$scope.fn_load();
		});
		
		
		$scope.move = function(_data) {
			$rootScope.$broadcast('bank-details', _data);
		};
			
		
		$scope.fn_load = function() {
	
		$http({
				url: 'query-merchant-bank-details',
				method: "GET",
				
			}).then (function (data) {
			
			$scope.model = data.data;
		
			});
		}
		
	})
	
	acsp.register.controller('merchantSaveController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.model = {};
		
		var agentCode = null;
		
		$scope.spinShow = false;
		
		$scope.accountTypeList = [
            {name: "SAVINGS", value: "1"},
            {name: "CHECKING", value: "2"}
       ];
		
	    var clear = function(){
	    	$scope.model = {};
			
		};
		
		
		$scope.$on('bank-details', function(event, args) {
			
			clear();
			agentCode = args.agentCd
			
			$scope.model.accountName = args.accountName
			$scope.model.accountNo = args.accountNo;
			$scope.model.bankName = args.bankName;
			$scope.model.bankName = args.bankName;
			$scope.model.agentCd = args.agentCd;
			$scope.model.agentName = args.agentName;
			$scope.model.merchantCategory = args.merchantCategory;
			$scope.model.telephoneNo = args.telephoneNo;
			$scope.model.faxNo = args.faxNo;
			$scope.model.merchantAddress = args.merchantAddress;
			
			if(args.accountType === '1') {
				$scope.model.accountType = $scope.accountTypeList[0];
			}
			
			if(args.accountType === '2') {
				$scope.model.accountType = $scope.accountTypeList[1];
			}
		
		});
		
		//Save
		
		$scope.save = function () {
			
			$scope.saveSpinShow = true;
			
			var req = $http({
				url : "command-merchant-bank-save",
				method : 'POST',
				dataType : 'json',
				transformRequest : false,
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				data : JSON.stringify({
					accountName : $scope.model.accountName,
					bankName : $scope.model.bankName,
					accountNo : $scope.model.accountNo,
					accountType : $scope.model.accountType.value,
					agentCd: agentCode
				})

			}).then(function successCallback(responseObj) {
				var data = responseObj.data;
				if(data.responseSuccess){
				
					$scope.successTextAlert = "Successful Update!";
					$scope.showSuccessAlert = true;
					
					acspToastService("success", $scope.successTextAlert);
					
					$rootScope.$broadcast('merchant_save', data);
					
					clear();
				
					$scope.saveForm.$setPristine();
					
				} else {
					
					acspToastService("danger", "Error in saving.");
					
				}
				
				$scope.saveSpinShow = false;
			}, function errorCallback(response) {
				console.log(response);
				
				$scope.saveSpinShow = false;
			});
		}
		
	})
	

});
	

	