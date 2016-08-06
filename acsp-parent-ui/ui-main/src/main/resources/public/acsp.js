var ACSP_DATA = {};

require.config({
    baseUrl: '/'
});
require(
		[
			'resources/thirdparty/js/jquery-2.1.4.min'
		],
		function () {
			require(
					[
						'resources/thirdparty/js/moment',
						'resources/thirdparty/js/angular.min'
					],
					function () {
						require(
						[
							'resources/thirdparty/js/bootstrap.min',
							'resources/thirdparty/js/angular-route.min',
							'resources/thirdparty/js/angular-animate.min',
							'resources/thirdparty/js/angular-sanitize.min',
							'resources/thirdparty/js/angular-messages',
							'resources/thirdparty/js/ui-bootstrap-tpls-1.3.2.min',
							'resources/thirdparty/js/si-table',
							'resources/thirdparty/js/ngToast.min',
							'resources/thirdparty/js/ngGallery'
						],
						function () {
							require(
									[
									    'password-reset/password-reset.controller',
									    'main/main.controller'
									],
									function () {
										$.ajax({
											url : '/user',
											method: 'GET',
											success: function(data){
												ACSP_DATA.currentUser = data;
												angular.bootstrap(document, ['acsp']);
											}
										})
									});
						});
					});
		});
