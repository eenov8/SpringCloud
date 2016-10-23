'use strict';

/**
 * @class angular_module.indusModule.AddUserCtrl
 * @param  $scope {object} {@link https://docs.angularjs.org/guide/scope}
 * @param  Excel-Directive {object} {@link https://docs.angularjs.org/guide/directive}
 * @param $timeout {object} {@link https://docs.angularjs.org/api/ngMock/service/$timeout}
 * @return DashboardCtrl-Constructor Instance of DashboardCtrl 
 * @description Controller for controlling Home Page of Indus Root
 */

indusModule
.controller(
		'AddUserCtrl',
		[
		 '$scope','$timeout','$rootScope','apiService','$location','$route',
		 function($scope,$timeout,$rootScope,apiService,$location,$route) {
			 $rootScope.showLoader = false;
			 $scope.login404Error = false;
			 $scope.loginError = false;
			 $scope.errorMessage = "";
			 $scope.user = {
					 "firstName": "",
					 "lastName": "",
					 "loginName": "",
					 "password": "",
					 "isactive": "true",
					 "role": "",
					 "roleDescription": "",
					 "email": "",
					 "enterprise": ""
			 };

			 /**
			  * @function addUser
			  * @name $scope.addUser
			  * @memberOf angular_module.indusModule.AddUserCtrl
			  * @description Creates User in Database
			  */
			 $scope.addUser = function(){
				 if($scope.user.firstName == "" || $scope.user.firstName.length > 20){
					 $scope.emptyCol = "FirstName";
					 return false;
				 }
				 if($scope.user.lastName == "" || $scope.user.lastName.length > 20) {
					 $scope.emptyCol = "LastName";
					 return false;
				 }
				 if($scope.user.password == ""){
					 $scope.emptyCol = "Password";
					 return false;
				 }
				 if($scope.user.loginName == "" || $scope.user.loginName.length > 20){
					 $scope.emptyCol = "LoginName";
					 return false;
				 }
				 if($scope.user.email == ""){
					 $scope.emptyCol = "Email";
					 return false;
				 }
				 if($scope.user.enterprise == ""){
					 $scope.emptyCol = "Enterprise";
					 return false;
				 }
				 if($scope.user.role == "Select Role.."){
					 $scope.emptyCol = "Role";
					 return false;
				 }
				 if($scope.emailVal == "wrongValue") {
					 $scope.emptyCol = "emailVal";
					 return false;
				 }
				 if($scope.enterpriseVal == "wrongEntValue") {
					 $scope.emptyCol = "enterpriseVal";
					 return false;
				 }
				 if($scope.loginNameVal == "wrongLoginVal") {
					 $scope.emptyCol = "loginNameVal";
					 return false;
				 }
				 if($scope.passwordVal == "wrongPwdVal") {
					 $scope.emptyCol = "passwordVal";
					 return false;
				 }
				 
				 for(var key in $scope.user){
					 if($scope.user[key] == undefined){
						 alert(key + " contains invalid value.");
						 $rootScope.showLoader = false;
						 return false;
					 }
				 }
				 $rootScope.showLoader = true;

				 apiService.execute("createUser", $scope.user,
						 function(srvData) {
					 $rootScope.showLoader = false;
					 if (srvData.data == "User created sucessfully.") {
						 $location.path("/userdetails");
						 $location.replace();
						 $route.reload();
					 } else if(srvData.status == 404) {
						 $scope.login404Error = true;
					 }else{
					 	$scope.errorMessage = srvData.data;
						 $scope.loginError = true;
					 }
				 });
			 };
			 
			 $scope.textChanged = function(){
				 var exp = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
				 if(!exp.test($scope.user.password)){
					 $scope.emptyCol = "passwordVal";
					 $scope.passwordVal = "wrongPwdVal";
					 $rootScope.showLoader = false;
					 return false;
				 }else{
					 $scope.emptyCol = "";
					 $scope.passwordVal = "";
					 return true;
				 }
			 }
			 
			 $scope.loginNameTextChanged = function(){
				 var regex = new RegExp("^[a-zA-Z0-9.]*$");
				 if(!regex.test($scope.user.loginName)){
					 $scope.emptyCol = "loginNameVal";
					 $scope.loginNameVal = "wrongLoginVal";
					 $rootScope.showLoader = false;
					 return false;
				 }else{
					 $scope.emptyCol = "";
					 $scope.loginNameVal = "";
					 return true;
				 }
			 }
			 
			 $scope.enterpriseTextChanged = function(){
				 var regex = new RegExp("^[a-zA-Z0-9.]*$");
				 if(!regex.test($scope.user.enterprise)){
					 $scope.emptyCol = "enterpriseVal";
					 $scope.enterpriseVal = "wrongEntValue";
					 $rootScope.showLoader = false;
					 return false;
				 }else{
					 $scope.emptyCol = "";
					 $scope.enterpriseVal = "";
					 return true;
				 }
			 }
			 
			 $scope.emailTextChanged = function(){
				 var atpos = $scope.user.email.indexOf("@");
				 var dotpos = $scope.user.email.lastIndexOf(".");
				 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=$scope.user.email.length) {
					 $scope.emptyCol = "emailVal";
					 $scope.emailVal = "wrongValue";
					 return false;
				 } else{
					 $scope.emptyCol = "";
					 $scope.emailVal = "";
					 return true;
				 }
			 }
			 
		 } ]);
