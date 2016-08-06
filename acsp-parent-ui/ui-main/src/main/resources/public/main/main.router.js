'use strict';

define(['main/main.module'], function (acsp) {

	/**
	 * Configuration for routing into pages
	 * 
	 */
	acsp.config(['$routeProvider', 'routeResolverProvider', '$controllerProvider', 
             '$compileProvider', '$filterProvider', '$provide',
             
             function ($routeProvider, routeResolverProvider, $controllerProvider, 
                       $compileProvider, $filterProvider, $provide) {
		
		acsp.register = {
                controller: $controllerProvider.register,
                directive: $compileProvider.directive,
                filter: $filterProvider.register,
                factory: $provide.factory,
                service: $provide.service
            };
		
		//Define routes - controllers will be loaded dynamically
        var route = routeResolverProvider.route;
        
        var configDynamicRoute = function(dept, module){
        	var dynamicRoute = route.resolve(module, dept);
        	$routeProvider.when(dynamicRoute.mapping, dynamicRoute);
        } 

    	console.log(ACSP_DATA.currentUser);
    	$.each(ACSP_DATA.currentUser.menus, function(main_index, main_menu){
    		$.each(main_menu.menuItems, function(item_index, item_menu){
    			if(item_menu.read){
    				configDynamicRoute(main_menu.project, item_menu.module);	
    			}		
    		});
    	});
                
		$routeProvider.when('/', {
			templateUrl : 'main/main.html'
		}).otherwise({
			redirectTo : '/'
		});
		
	}]);
	
	return acsp;
	
});
