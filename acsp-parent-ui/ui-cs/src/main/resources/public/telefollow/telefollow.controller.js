'use strict';

define(['main/main.module'], function (acsp) {
	
	/**
	 * Controller for Search
	 * @Author Elizabeth Laguardia
	 * 06162016
	 */

	acsp.register.controller('telefollowNewController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.model = {};
		
		
		$scope.move = function(_data) {
			$rootScope.$broadcast('cs-record-select', _data);
		};
		
	
		$scope.$on('telefollow_save', function(event, args) {
			$scope.fn_load();
		});
		
		
		$scope.fn_load = function() {
		
			
			$http({
				url: 'query-telefollow-alloc-waitingforpickup-new?allocated=N',
				method: "GET",
				
			}).then (function (data) {
				
				$scope.model = data.data;
			
				$rootScope.$broadcast('telefollow_new_list_loaded', $scope.model.results ? $scope.model.results.length: 0);
			});
		}
	})
	
	acsp.register.controller('telefollow-notif-controller', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.model = {};
		
		$scope.$on('telefollow_new_list_loaded', function(event, args) {
			$scope.model.new_count = args;
		});
		
		$scope.$on('telefollow_tracker_list_loaded', function(event, args) {
			$scope.model.tracker_count = args;
		});
		
	})
	
	acsp.register.controller('telefollowContactedController', function($scope, $http, $location,
			$compile, $rootScope, acspToastService) {
		
		$scope.model = {};
		
		$scope.move = function(_data) {
			$rootScope.$broadcast('cs-record-select', _data);
		};
		
		$scope.$on('telefollow_save', function(event, args) {
			$scope.fn_load();
		});
		
		
		$scope.fn_load = function() {
		
			
			$http({
				url: 'query-telefollow-alloc-waitingforpickup-new?allocated=Y',
				method: "GET",
				
			}).then (function (data) {
				
				$scope.model = data.data;
							
				$rootScope.$broadcast('telefollow_tracker_list_loaded', $scope.model.results ? $scope.model.results.length: 0);
			});
		}
	})

	/**
	 * Controller For Save call logs
	 * @Author Elizabeth Laguardia
	 */
	acsp.register.controller('telefollowSaveController', function($scope, $http, $location, $filter, $sce, acspToastService,$rootScope) {
		
		$scope.spinShow = false;
		
		$scope.$on('telefollow_save', function(event, args) {
			$scope.byCancel = false;
			$scope.bySalesPending = false;
		});
		
		
		$scope.contactedList = [
              {name: "MERCHANT", value: "1"},
              {name: "PROMOTER", value: "2"},
              {name: "CUSTOMER", value: "3"},
              {name: "EDP", value: "4"},
              {name: "OTHER", value: "5"}
        ];
		
		
		$scope.statusList = [
              {name: "SALES", value: "1"},
              {name: "CANCEL", value: "2"},
              {name: "NOT YET CONTACTED", value: "3"},
              {name: "WAITING FOR PICK UP", value: "5"},
              {name: "SALES PENDING", value: "8"},
              {name: "OTHER", value: "15"}
        ];
		
		$scope.actionList = [
             {name: "END", value: "1"},
             {name: "CANCEL", value: "2"},
             {name: "NONE", value: "3"},
             {name: "RECONTACT", value: "4"},
             {name: "FEEDBACK TO CAD", value: "5"},
             {name: "FEEDBACK TO CMD", value: "6"},
             {name: "FEEDBACK TO MKT", value: "7"}
        ];
		
		$scope.cancelList = [
             {name: "PROCESS TOO LONG", value: "1"},
             {name: "PURCHASED BY CASH", value: "2"},
             {name: "CHANGE TO ANOTHER COMPANY", value: "3"},
             {name: "CHANGED MIND", value: "5"},
             {name: "UNCONTACTABLE", value: "8"},
             {name: "REPROCESSED", value: "16"},
             {name: "OTHERS", value: "17"}
        ];
		
		$scope.methodList = [
             {name: "CALL", value: 1},
             {name: "TEXT", value: 2}
        ];
		
		var clear = function(){
			$scope.model = {};
		};
		
		$scope.reset = function(){
			clear();
			clearInput();
		};
		
		var clearInput = function() {
			
			$scope.model.contacted = $scope.contactedList[0];
			$scope.model.status = $scope.statusList[0];
			$scope.model.action = $scope.actionList[0];
			$scope.model.cancelReason = $scope.cancelList[0];
			$scope.model.method = $scope.methodList[0];
			$scope.model.comments = null;
			$scope.today();
			
			checkActionfCancel();
			
			
		}
		
		var checkActionfCancel = function() {
			
			var chk = $scope.model.action.value;
			
			if (chk === '2') {
				$scope.byCancel = true;
				$scope.model.cancelReason = $scope.cancelList[0];
			} 
			else {
				$scope.byCancel = false;
			}
		}
		
		var checkIfSalesPending = function() {
			
			var chk = $scope.model.status.value;
			
			if (chk === '8') {
				$scope.bySalesPending = true;
		
			} 
			else {
				$scope.bySalesPending = false;
			}
		}
		
		
		$scope.checkedIfSalesPending = function() {
			checkIfSalesPending();
			
		};
		
		$scope.checkedActionIfCancel = function() {
			checkActionfCancel();
			
		};
		
		
		
		(function (){
			
			clear();
			
			$scope.$on('cs-record-select', function(event, args) {
				$scope.model.name = args.firstName && args.lastName && (args.firstName + " " + args.lastName);
				$scope.model.appCd = args.appCd;
				$scope.model.approvalCode = args.approvalCode;
				$scope.model.approvalDate = args.approvalDate;
				$scope.model.storeName = args.storeName;
				$scope.model.storePhone = args.storePhone;
				$scope.model.storePic = args.storePic;
				$scope.model.mobileNo = args.mobileNo;
				$scope.model.officePhone = args.officePhone;
				$scope.model.homePhone = args.homePhone;
				$scope.model.applicationDate = args.applicationDate;
				$scope.model.products = args.products;
				$scope.model.telefollowHistory = args.telefollowHistory;
				
				console.log("history:", $scope.model.telefollowHistory);
				clearInput();
				
			});
		
		})();
		
	   //Save Function
		
		
		
		$scope.save = function () {
			
			$scope.saveSpinShow = true;
			var chk = $scope.model.action.value;
			var chkSalesPending = $scope.model.status.value;
		
			var cancel = null;
		
			if (chk === '2') {
				 cancel: $scope.model.cancelReason.value; 
			} 
			
			if (chkSalesPending !== '8') {
				$scope.model.salesPending = null;
			} 
		
	    console.log(cancel);	
		
		var req = $http({
			url : "command-telefollow-save",
			method : 'POST',
			dataType : 'json',
			transformRequest : false,
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			data : JSON.stringify({
				appCd : $scope.model.appCd,
				name : $scope.model.name,
				comments : $scope.model.comments,
				contactTo : $scope.model.contacted.value,
			    status : $scope.model.status.value,
			    cancelReason : cancel,
			    action : $scope.model.action.value,
			    followupDate: $scope.model.followupDate,
			    commitmentDate: $scope.model.commitmentDate,
			    salesPending: $scope.model.salesPending,
			    method: $scope.model.method.value
			    
			})

		}).then(function successCallback(responseObj) {
			var data = responseObj.data;
			if(data.responseSuccess){
			
				$scope.successTextAlert = "Successful Update!";
				$scope.showSuccessAlert = true;
				
				acspToastService("success", $scope.successTextAlert);
				
				$rootScope.$broadcast('telefollow_save', data);
				
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
		
	
		
		$scope.model.salesPending = new Date();
		$scope.model.commitmentDate = new Date();
		$scope.model.followupDate = new Date();
		
		$scope.popup = {
				openedFollowup: false,
				openedCommitment: false,
				openedSalesPending: false	
		};
		
		$scope.formats = ['dd-MMMM-yyyy', 'yyyy-MM-dd', 'dd.MM.yyyy', 'shortDate'];
		$scope.format = $scope.formats[1];
		
		$scope.today = function() {
		    $scope.model.followupDate = new Date();
		    $scope.model.commitmentDate = new Date();
		    $scope.model.salesPending = new Date();
		};
		
		$scope.dateOptions = {
			    formatYear: 'yy',
			    minDate: new Date() + 1,
			    startingDay: 1
		};
		
		$scope.altInputFormats = ['M!/d!/yyyy'];
		
		$scope.clear = function() {
		   
		    $scope.model.followupDate = null;
		    $scope.model.commitmentDate = null;
		    $scope.model.salesPending = null;
		    $scope.model = {};
		 
		};
		
		$scope.openFollowup = function() {
			$scope.popup.openedFollowup = true;
		};
		
		$scope.openCommitment = function() {
			$scope.popup.openedCommitment = true;
		};
		
		$scope.opensalesPending = function() {
			$scope.popup.openedSalesPending = true;
		};
		
	})

});
	

	