'use strict';

/**
 * Login Section Controller
 *
 * @type Controller
 * @module indusApp
 * @class LoginCtrl
 * @name indusApp.controller:LoginCtrl
 * @param $scope {service} scope of controller
 * @param apiService {Factory} AJAX calling service
 * @param $location {service} Document location service
 * @param $cookieStore {service} Browser cookies service
 * @param $rootScope {service} Application global objects service
 */


indusModule.controller('LoginCtrl',
		[
		 '$scope',
		 '$location',
		 '$rootScope',
		 'apiService',
		 '$cookieStore','$route','$timeout',
		 function ($scope, $location, $rootScope,apiService,$cookieStore,$route,$timeout) {

			 $rootScope.showLoader = false;
			 $scope.userId="";
			 $scope.password="";
			 $scope.emptyCol = "";
			 $scope.login404Error = false;
			 $scope.loginError = false;
			 $scope.errorMessage = "";
			 $scope.loginUser = function() {
				 if($scope.userId == ""){
					 $scope.emptyCol = "User";
					 return false;
				 }
				 if($scope.password == ""){
					 $scope.emptyCol = "Password";
					 return false;
				 }
				 $scope.hideLoader = false;
				 var login_data = {
					 username : $scope.userId,
					 password : $scope.password
				 }; 
				 var _args = {
						 username : $scope.userId,
						 password : $scope.password
				 };
				 $rootScope.showLoader = true;
				 apiService.execute("login", _args,
						 function(srvData) {
					 $rootScope.showLoader = false;
					 if (srvData.status == 200) {
						 var userObj = {
								 "loggedIn": true,
								 "userName" : $scope.userId,
								 "userRole" : "admin"
						 };
						 $cookieStore.put('user',userObj);
						 $rootScope.loggedIn = true;
						 $rootScope.toggleAccountMenu = false;
						 $rootScope.userName = userObj["userName"];
						 $rootScope.userRole = userObj["userRole"];
						 $location.path("/Home");
						 $route.reload();
					 } else if(srvData.status == 404) {
						 $scope.login404Error = true;
					 } else {
					 	$scope.errorMessage = srvData.data;
						 $scope.loginError = true;
					 }
				 });


			 };

		 }]
);
