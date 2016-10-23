'use strict';


/**
 * @type Module
 * @class angular_module.ercModule
 * @memberOf angular_module
 * @name ercModule
 */

var ercModule = angular.module('ercApp', [ 'ngAnimate', 'ngRoute','ngCookies','ui.router.state', 'ui.bootstrap', 'ncy-angular-breadcrumb','datatables', 'ngResource' ])
.config(function($breadcrumbProvider) {
	$breadcrumbProvider.setOptions({
		prefixStateName: 'home',
		template: 'bootstrap2'
	});
})
.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('home', {
		url: '/',
		templateUrl : 'views/dashboard.html',
		controller : 'DashboardCtrl',
		ncyBreadcrumb: {
			label: 'Home'
		}
	})
	.state('login', {
		url: '/login',
		templateUrl : 'views/login.html',
		controller : 'LoginCtrl',
		ncyBreadcrumb: {
			label: 'Login'
		}
	})
	.state('dashboard', {
		url: '/home',
		templateUrl : 'views/dashboard.html',
		controller : 'DashboardCtrl',
		ncyBreadcrumb: {
			label: 'Home'
		}
	})
	.state('userdetails', {
		url: '/userdetails',
		templateUrl : 'views/userDetails.html',
		controller : 'userDetailsCtrl',
		ncyBreadcrumb: {
			label: 'User Details',
			parent: 'home'
		}
	})
	.state('adduser', {
		url: '/adduser',
		templateUrl : 'views/addUser.html',
		controller : 'AddUserCtrl',
		ncyBreadcrumb: {
			label: 'Add User',
			parent: 'home'
		}
	});

	$urlRouterProvider.otherwise('/');
});

/**
 * @class angular_module.ercModule
 * @runnable
 * @param $rootScope {service} {@link https://docs.angularjs.org/api/ng/service/$rootScope}
 * @param  $route {service} {@link https://docs.angularjs.org/api/ngRoute/service/$route}
 * @param  $location {service} {@link https://docs.angularjs.org/api/ng/service/$location}
 * @param $cookieStore {service} {@link https://docs.angularjs.org/api/ngCookies/service/$cookieStore}
 * @description Init function for ercModule initiating rootScope and checkinf if user is logged in or not
 */

ercModule.run(function($rootScope,$cookieStore,$route,$location) {
	var userObj = $cookieStore.get('user');
	$rootScope.loggedIn = false;
	if(userObj == undefined || userObj.loggedIn == false){
		$location.path("/login");
		$location.replace();
		$route.reload();
		return false;
	}else{
		$rootScope.userName = userObj["userName"];
		$rootScope.userRole = userObj["userRole"];
		$rootScope.loggedIn = true;
		$rootScope.showLoader = true;
		$rootScope.toggleAccountMenu = false;
	}
});


/**
 * @class angular_module.ercModule
 * @factory
 * @name Excel
 * @return 'Excel' named factory for downloading Excel sheet from table
 */
ercModule.factory('Excel',function($window){
	var uri='data:application/vnd.ms-excel;base64,',
	template='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
	base64=function(s){return $window.btoa(unescape(encodeURIComponent(s)));},
	format=function(s,c){return s.replace(/{(\w+)}/g,function(m,p){return c[p];})};
	return {
		tableToExcel:function(tableId,worksheetName){
			var table=$(tableId),
			ctx={worksheet:worksheetName,table:table.html()},
			href=uri+base64(format(template,ctx));
			return href;
		}
	};
});
