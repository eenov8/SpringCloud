'use strict';

/**
 * @class angular_module.ercModule.HeaderCtrl
 * @param  $scope {object} {@link https://docs.angularjs.org/guide/scope}
 * @param $rootScope {service} {@link https://docs.angularjs.org/api/ng/service/$rootScope}
 * @param  $route {service} {@link https://docs.angularjs.org/api/ngRoute/service/$route}
 * @param  $location {service} {@link https://docs.angularjs.org/api/ng/service/$location}
 * @param $cookieStore {service} {@link https://docs.angularjs.org/api/ngCookies/service/$cookieStore}
 * @return HeaderCtrl-Constructor Instance of HeaderCtrl
 * @description Controller for controlling Header Section of Eat Rest Code
 */

ercModule
.controller(
		'HeaderCtrl',
		[
		 '$scope','$rootScope','$route','$location','$cookieStore','$timeout',
		 function($scope,$rootScope,$route,$location,$cookieStore,$timeout) {
			 $scope.logoIcon = "images/Logo.png";
			 $scope.userAccountIcon = "images/icons/Arrow_Grey_down.png";
			
			 /**
			  * @name $scope.logOut
			  * @function logOut
			  * @memberOf angular_module.ercModule.DashboardCtrl
			  * @description Logs Out user from application and redirect to Login Page
			  */
			 
			 $scope.logOut = function() {
				 $cookieStore.remove('user');
				 $timeout(function() {
					 angular.element('.account').triggerHandler('click');
				 }, 100);
				 $rootScope.loggedIn = false;
				 $location.path("/login");
				 $location.replace();
				 $route.reload();
			 }

		 } ]);
