'use strict';

/**
 * @function apiService
 * @memberOf angular_module.indusModule
 * @param $http {service} {@link https://docs.angularjs.org/api/ng/service/$http}
 * @description This service provides the API Interaction of UI with Server
 * @returns registered apiService provider instance with execute function for calling APIs
 */

indusModule
.factory(
		'apiService',
		[
		 '$http',
		 function($http) {
			 return {
				 execute : function(type, args, cb) {
					 var apiData = {};
					 switch (type) {
					 case 'login': {
						 apiData.url = "http://localhost:8001/usermanager/EatRest/User/authenticate";
						 apiData.type = "POST";
						 break;
					 }
					 case 'getUsers': {
						 apiData.url = "https://localhost:8004/fetchUsers";
						 apiData.type = "GET";
						 break;
					 }
					 case 'getRoles': {
						 apiData.url = config.apiServer()
						 + "roles/fetchAll";
						 apiData.type = "GET";
						 break;
					 }
					 case 'createUser': {
						 apiData.url = "https://localhost:8004/addUser";
						 apiData.type = "POST";
						 break;
					 }
					 case 'fetchCSPAccount': {
						 apiData.url = "https://localhost:8006/IndusRoot/CSP/Account/fetchCSPAccounts";
						 apiData.type = "GET";
						 break;
					 }
					 }
					 var xhr = $http({
						 method : apiData.type,
						 url : apiData.url,
						 headers : apiData.headers || {},
						 data : JSON.stringify(args),
						 contentType : "application/json; charset=utf-8",
						 dataType : "json"
					 });
					 xhr
					 .success(function(srvData) {
						 if (srvData.status == 200
								 || srvData.status == 250
								 || srvData.status == 404) {
							 cb(srvData);
						 } else if (srvData.status == 503) {
							 console
							 .log("No data available");
							 cb({status:"503",data: [],message: "No data available."});
						 } else if (srvData.status == 500) {
							 console
							 .log(srvData.message);
							 cb({status:"500",data : [],message: "Internal server occured."});
						 } else if (srvData.status == 420) {
							 cb(srvData);
						 } else if (srvData
								 .indexOf("Your session has been expired, please") > 0) {
						 }
					 });
					 xhr
					 .error(function(srvData) {
						 cb({status:"505",data: "Some unexpected error has occured. Please try after sometime."});
					 });
					 return xhr;
				 }
			 };

		 } ]);
