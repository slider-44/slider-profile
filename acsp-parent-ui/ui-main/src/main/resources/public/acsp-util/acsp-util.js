'use strict';

define([], function() {

	var acspUtil = angular.module('acspUtil', []);

	var compareTo = function() {
		return {
			require : "ngModel",
			replace: true,
			scope : {
				otherModelValue : "=acspCompareTo"
			},
			link : function(scope, element, attributes, ngModel) {

				ngModel.$validators.compareTo = function(modelValue) {

					return modelValue === scope.otherModelValue;
				};

				scope.$watch("otherModelValue", function() {
					ngModel.$validate();
				});
			}
		};
	};

	acspUtil.directive("acspCompareTo", compareTo);
	
	var acspMenu = function(){
		return {
			restrict: 'E',
			templateUrl: '/fragments/acsp-menu.html',
			controller: ['$scope', function($scope) {
			      $scope.menus = ACSP_DATA.currentUser.menus;
		    }]
		}
	}
	
	acspUtil.directive("acspMenu", acspMenu);

	return acspUtil;

});