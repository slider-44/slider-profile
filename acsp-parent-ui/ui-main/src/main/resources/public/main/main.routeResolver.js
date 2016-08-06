'use strict';

define([], function () {

    var routeResolver = function () {

        this.$get = function () {
            return this;
        };

        this.route = function (routeConfig) {

            var resolve = function (baseName, path, secure) {            	
            	if (!path) {
					path = '';
				} else {
					path = "/" + path;
				}

				path = path + "/" + baseName;

				var routeDef = {};
				routeDef.mapping = path;
				routeDef.templateUrl = path + "/" + baseName + '.html';
				routeDef.secure = (secure) ? secure : false;
				routeDef.resolve = {
					load : [
							'$q',
							'$rootScope',
							function($q, $rootScope) {
								var dependencies = [ path + "/" + baseName + '.controller.js' ];
								return resolveDependencies($q, $rootScope, dependencies);
							} ]
				};
				
				console.log(routeDef);
				
				return routeDef;
			},

            resolveDependencies = function ($q, $rootScope, dependencies) {
                var defer = $q.defer();
                require(dependencies, function () {
                    defer.resolve();
                    $rootScope.$apply()
                });

                return defer.promise;
            };

            return {
                resolve: resolve
            }
        }(this.routeConfig);

    };

    var servicesApp = angular.module('routeResolverServices', []);

    //Must be a provider since it will be injected into module.config()    
    servicesApp.provider('routeResolver', routeResolver);
});

