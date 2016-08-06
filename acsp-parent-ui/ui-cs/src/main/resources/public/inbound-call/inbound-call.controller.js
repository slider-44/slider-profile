'use strict';

define(['main/main.module'], function (acsp) {
	
	/**
	 * Controller for Search
	 * @Author Franz Cortez
	 */
	acsp.register.controller('searchController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.spinShow = false;
		$scope.searchBy = 'CUSTOMER INFORMATION';
		
		$scope.reset = function(){
			$scope.model = {};
			$scope.model.customers = [];
			$scope.model.stores = [];
		}
		
		$scope.reset();

		$scope.move = function(_data) {
			$rootScope.$broadcast('cs-record-select', _data);
		};
		
		$scope.checkerGo = function() {

			var chk = $scope.caller;

			if (chk === 'CUSTOMER') {
				
				$scope.caller1 = true;
				$scope.caller2 = false;

			} else if (chk === 'PROMOTER' || 'MERCHANT') {
				
				$scope.caller2 = true;
				$scope.caller1 = false;

			}

		};

		$scope.checkerSearchBy = function() {

			var chk = $scope.searchBy;

			if (chk === 'CUSTOMER INFORMATION') {
				
				$scope.customerName = true;
				$scope.byPhone = false;
				$scope.byStore = false;
				$scope.byCustomerOrPromoter = true;
				$scope.byApplicationCd = false;
				
				$scope.caller1 = true;
				$scope.caller2 = false;
				
			} else if (chk === 'STORE NAME') {
				
				$scope.byStore = true;
				$scope.byPhone = false;
				$scope.customerName = false;
				$scope.byCustomerOrPromoter = true;
				$scope.byApplicationCd = false;
				
				$scope.caller2 = true;
				$scope.caller1 = false;
				
			} 
		};

		$scope.checkerSearchBy();
		
		$scope.search = function() {
			var reqParam = {};
			
			$scope.spinShow = true;
			//Assign request parameter depends on search by condition.

			if ($scope.searchBy == 'CUSTOMER INFORMATION') {
				reqParam = {
					firstName : $scope.model.firstName,
					lastName : $scope.model.lastName,
					birthDay : $scope.model.birthDay,
					appCd : $scope.model.appCd,
					agreementCd : $scope.model.agreementCd,
					telNo : $scope.model.homeTel
				};
			}

			if ($scope.searchBy == 'STORE NAME') {
				reqParam = {
					storeName : $scope.model.storeName,
					storeCd : $scope.model.storeCd,
					telNo : $scope.model.storeTel
				};
			}
			
			var _withParam = false;
			$.each(reqParam, function(k,v){
				_withParam = _withParam || v;
			});

			if(!_withParam) {
				
				acspToastService("warning", "Search not continued. Please input at least one search field value.");
				$scope.spinShow = false;
				
			} else if ($scope.searchBy == 'CUSTOMER INFORMATION') {

				$http({
					url : 'query-customer-search',
					method : "GET",
					params : reqParam
				}).then(
					function(responseObj) {
						var data = responseObj.data;
						if(data.responseSuccess) {
							$scope.model.customers = data.results;
							if(!$scope.model.customers || $scope.model.customers.length === 0){
								acspToastService("warning", "No data found.  Kindly edit search parameters.");
							}	
						} else {
							acspToastService("warning", "Error in search. " + data.responseMessage);
						}
						
						$scope.spinShow = false;
					},
					function(error) {
						$scope.spinShow = false;
					});

			} else if ($scope.searchBy == 'STORE NAME') {
				$http({
					url : 'query-store-search',
					method : "GET",
					params : reqParam
				}).then(
					function(responseObj) {
						var data = responseObj.data;
						if(data.responseSuccess) {
							$scope.model.stores = data.results;
							if(!$scope.model.stores || $scope.model.stores.length === 0){
								acspToastService("warning", "No data found.  Kindly edit search parameters.");
							}
						} else {
							acspToastService("warning", "Error in search. " + data.responseMessage);
						}
						
						
						$scope.spinShow = false;
					},
					function(error) {
						$scope.spinShow = false;
					});
			}

		};

		$scope.popup = {
			opened: false
		};

		$scope.formats = ['dd-MMMM-yyyy', 'yyyy-MM-dd', 'dd.MM.yyyy', 'shortDate'];
		$scope.format = $scope.formats[1];
		  
		$scope.today = function() {
		    $scope.model.birthDay = new Date();
		};
		
		$scope.clear = function() {
		    $scope.model.birthDay = null;
		};
		
		$scope.dateOptions = {
		    formatYear: 'yy',
		    maxDate: new Date() + 1,
		    startingDay: 1
		};
		  
		$scope.altInputFormats = ['M!/d!/yyyy'];
		
		$scope.open = function() {
			$scope.popup.opened = true;
		};


	});

	/**
	 * Controller For Save call logs
	 * @Author Franz Cortez
	 */
	acsp.register.controller('customerSave', function($scope, $http, $location, $filter, $sce, acspToastService) {
		$scope.spinShow = false;
		
		var clear = function(){
			$scope.model = {};
			$scope.callEnded = false;
		};
		
		(function (){
			
			clear();

			$scope.$on('cs-record-select', function(event, args) {
				$scope.model.name = args.storeName || args.firstName && args.surName && (args.firstName + " " + args.surName);

				$scope.model.birthDay = args.birthDay ? 
						new Date((args.birthDay.substr(0, 4) + '-'
								+ args.birthDay.substr(4, 2) + '-'
								+ args.birthDay.substr(6, 2)))
						: null;
				
				$scope.model.appCd = args.appCd;
				$scope.model.customerCd = args.customerCd;
			});
		
		})();

		
		/*
		 * Save function
		 * 
		 */
		$scope.save = function() {
			$scope.saveSpinShow = true;
			
			var req = $http({
				url : "command-cs-inbound-call-save",
				method : 'POST',
				dataType : 'json',
				transformRequest : false,
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				data : JSON.stringify({
					callFrom : $scope.model.callFrom,
					category : $scope.model.category,
					appCd : $scope.model.appCd,
					name : $scope.model.name,
					birthDay : $scope.model.birthDay,
					comment : $scope.model.comment,
					contactNum : $scope.model.contactNum,
					callEnd : $scope.model.callEnd,
					callStart : $scope.model.callStart,
					transfer : $scope.model.transfer,
					telefollow : $scope.model.telefollow,
					contacted : $scope.model.contacted,
					claimed : $scope.model.claimed,
					customerCd: $scope.model.customerCd
				})

			}).then(function successCallback(responseObj) {
				var data = responseObj.data;
				if(data.responseSuccess){
					$scope.successTextAlert = "Adding new call log successful";
					$scope.showSuccessAlert = true;
					
					acspToastService("success", $scope.successTextAlert);

					$scope.switchBool = function(value) {
						$scope[value] = !$scope[value];
					}

					$scope.show = false;
					$scope.isDisabledEnd = false;
					$scope.isDisabledStart = false;
					
					$scope.reset();
					
				} else {
					
					acspToastService("danger", "Error in saving.");
					
				}
				
				$scope.saveSpinShow = false;
			}, function errorCallback(response) {
				console.log(response);
				
				$scope.saveSpinShow = false;
			});
		}
		
		/*
		 * Call End function
		 * 
		 */
		$scope.callEndFunction = function() {
		var req = $http({
			method : "GET",
				url : 'utils-timestamp'
				
			}).success(function(data) {
				$scope.model.callEnd = data;
				$scope.model.callEndParse =  $filter('date')(new Date(), 'hh:mm:ss a');
				$scope.callEnded = true;
			});

		}
		
		/*
		 * Call Start function
		 * 
		 */
		$scope.callStartFunction = function() {
			 $scope.isDisabledStart = false;
			 $scope.spinShow = true;
			var req = $http({
				url : 'utils-timestamp',
				method : "GET"
			}).success(function(data) {
				$scope.show = true;
				$scope.isDisabledStart = true;
				$scope.spinShow = false;
				
				$scope.model.callStart = data;
				$scope.model.callStartParse =  $filter('date')(new Date(), 'hh:mm:ss a');
			});
		}
		
		/*
		 * Call cancel function
		 * 
		 */
		$scope.callCancel = function(){
			$scope.isDisabledStart = false;
			$scope.isDisabledEnd = false;
			$scope.show = false;
					
			$scope.reset();
			
			$scope.saveForm.$setPristine();
		}
		
		/*
		 * Clear field function
		 */
		$scope.reset = function(){
			var _callStart = $scope.model.callStart;
			var _callStartParse = $scope.model.callStartParse;
			clear();
			$scope.model.callStart = _callStart;
			$scope.model.callStartParse = _callStartParse;
			
			$scope.saveForm.$setPristine();
		}
		
		$scope.popup = {
			opened: false
		};

		$scope.format = 'yyyy-MM-dd';
		  
		$scope.today = function() {
		    $scope.model.birthDay = new Date();
		};
		
		$scope.clear = function() {
		    $scope.model.birthDay = null;
		};
		
		$scope.dateOptions = {
		    formatYear: 'yy',
		    maxDate: new Date() + 1,
		    startingDay: 1
		};
		  
		$scope.altInputFormats = ['M!/d!/yyyy'];
		
		$scope.open = function() {
			$scope.popup.opened = true;
		};
	})
	
});

