'use strict';

define(['main/main.routeResolver', 'acsp-util/acsp-util.js'], function () {
	
	var acsp = angular.module('acsp', [ 'ngRoute', 'ngMessages', 'siTable', 'ngToast', 'ngAnimate', 'ui.bootstrap', 
	                         'acspUtil', 'routeResolverServices', 'jkuri.gallery']);
	                         
	/**
	 * Service that can be used to show a Toast notification.
	 */
	acsp.factory("acspToastService", ['ngToast', function(ngToast){
		var acspToastService = {};
		var faIcon = {
				'info': "info-circle",
				'default': "",
				'danger': "exclamation-triangle",
				'warning': "warning",
				'success': "check"
		};
		
		var createToastConfig = function(level, message, onDismiss){
			return $.inArray(level, ['info', 'danger', 'warning', 'success']) === -1 ? {} :
				{ className: level,
		 		  content: '<p><i class="fa fa-' + faIcon[level] + ' fa-3x"></i>' + message + '</p>',
		 		  timeout: 3000,
		 		  additionalClasses: 'acsp-toast',
		 		  maxNumber: 5,
		 		  dismissButton: true,
		 		  animation: 'slide',
		 		  onDismiss: onDismiss}
		};
		
		return function(level, message, onDismiss){
			var toastConfig = createToastConfig(level, message, onDismiss);
			toastConfig.content && ngToast.create(toastConfig);
		}
	}]);

	/**
	 * Stores the equivalent message for the known error HTTP status.
	 */
	acsp.constant("responseErrorStatus", {
		404: 'Service is unavailable as of the moment. Kindly try again after 10 seconds.',
		405: 'Service is unavailable as of the moment. Kindly contact web administrator.',
		default: function(rejection){
					return 'Error in processing request. ' + (rejection.statusText && (rejection.statusText + ' [' + rejection.status + '].'))
	         	 }
		}
	);

	/**
	 * Adds a interceptor that shows a error toast notification whenever 
	 * a failed http request is encountered.
	 */
	acsp.config(['$httpProvider', function($httpProvider, acspToastService, responseErrorStatus) {
		
		var _expiredToast = null;
		
		//alternatively, register the interceptor via an anonymous factory
		$httpProvider.interceptors.push(function($q, acspToastService, responseErrorStatus) {
		  return {
		   'request': function(config) {
			   return config;
		    },
		    'requestError': function(rejection) {
		    	console.log('requestError');
		    	console.log(rejection);
		        return $q.reject(rejection);
		    },
		    'response': function(response) {
		    	if(response.headers("Location") || (response.data && response.data.match && response.data.match("^<!DOCTYPE html>"))){
		    		if(!_expiredToast){
			    		_expiredToast = true;
			    		acspToastService('danger', "Session already expired.", function(){
			    			window.location = "/";
			    			_expiredToast = null;
			    		});	
			    	}
		    	}
		    	
		 	   	return response;
		    },
		    'responseError': function(rejection) {
		    	console.log('responseError');
		 	   	console.log(rejection);
		 	   	acspToastService('danger', responseErrorStatus[rejection.status] || responseErrorStatus.default(rejection));
		 	   	return $q.reject(rejection);
		    }
		  };
		});
	}]);
	
	return acsp;
	
});

