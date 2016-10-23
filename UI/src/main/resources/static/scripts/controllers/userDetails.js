'use strict';

/**
 * @class angular_module.ercModule.DashboardCtrl
 * @param  $scope {object} {@link https://docs.angularjs.org/guide/scope}
 * @param  Excel-Directive {object} {@link https://docs.angularjs.org/guide/directive}
 * @param $timeout {object} {@link https://docs.angularjs.org/api/ngMock/service/$timeout}
 * @return DashboardCtrl-Constructor Instance of DashboardCtrl 
 * @description Controller for controlling Home Page of Eat Rest Code
 */

ercModule
.controller(
		'userDetailsCtrl',
		[
		 '$scope','Excel','$timeout','$rootScope','apiService',
		 function($scope,Excel,$timeout,$rootScope,apiService) {
			 $rootScope.showLoader = true;
			 $scope.searchUser   = '';     // set the default search/filter term
			 $scope.searchOn = false;
			 $scope.sort = {
					 type: '',
					 reverse: false
			 };
			 $scope.filterOn = false;

			 $scope.ordered_columns = [];
			 $scope.all_columns = [];

			 $scope.selectedRow = "";
			 getUserList();

			 /**
			  * @function $scope.createColumns
			  * @memberOf angular_module.ercModule.DashboardCtrl
			  * @description Fetch columns from JSON received from Database
			  */
			 function createColumns(){
				 if(Object.keys($scope.userList).length > 0) {
				 var cols = Object.keys($scope.userList[0]);
				 $scope.all_columns = [];
				 for(var key in cols){
					 if(key  == 0)
						 $scope.sort.type = cols[key];
					 var obj = {
							 "title" : cols[key],
							 "type" : typeof(cols[key]),
							 "checked" : true,
							 'disabled' : false
					 }
					 $scope.all_columns.push(obj);
				 }	
				 $rootScope.showLoader = false;
				 }
			 }

			 /**
			  * @function $scope.exportToExcel
			  * @memberOf angular_module.ercModule.DashboardCtrl
			  * @description Export the Table on xls format excel sheet
			  */
			 $scope.exportToExcel=function(tableId){ 
				 var exportHref=Excel.tableToExcel(tableId,'MC Users');
				 $timeout(function(){
					 location.href=exportHref;
				 },100);
			 }

			 $scope.$watch('all_columns', function() {
				 update_columns();
			 }, true);

			 /**
			  * @function selectRow
			  * @name $scope.selectRow
			  * @memberOf angular_module.ercModule.DashboardCtrl
			  * @description Select the Row in Table
			  */
			 $scope.selectRow = function(id){
				 if($scope.selectedRow !== id)
					 $scope.selectedRow = id;
				 else
					 $scope.selectedRow = "";
			 }

			 /**
			  * @function update_columns
			  * @name update_columns
			  * @memberOf angular_module.ercModule.DashboardCtrl
			  * @description Hide/Show User table columns
			  */
			 var update_columns = function() {
				 $scope.ordered_columns = [];
				 for (var i = 0; i < $scope.all_columns.length; i++) {
					 var column = $scope.all_columns[i];
					 if (column.checked) {
						 $scope.ordered_columns.push(column);
					 }
				 }
			 };

			 /**
			  * @function getUserList
			  * @memberOf angular_module.ercModule.DashboardCtrl
			  * @description Fetch List of Users from Database
			  */
			 function getUserList(){
				 apiService.execute("getUsers", {},
						 function(srvData) {
					 $rootScope.showLoader = false;
					 if (srvData.status == 200) {
						 $rootScope.showLoader = false;
						 var users = srvData.data;
						 $scope.userList = users;
						 createColumns();
					 }  else if(srvData.status == 404) {
						 alert("Server cannot be reached. Please contact administrator.");
					 }else {
						 alert("Some error occured. Pleae try again.");
						 return [];
					 }
				 });
			 }

		 } ]);
