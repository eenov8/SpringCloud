'use strict';

/**
 * @class angular_module.ercModule.ngFileChosen
 * @param  $scope {object} {@link https://docs.angularjs.org/guide/scope}
 * @require ngModel {object} {@link https://docs.angularjs.org/api/ng/directive/ngModel}
 * @return DashboardCtrl-Constructor Instance of DashboardCtrl 
 * @description directive for file upload
 */


ercModule.directive('noSpace', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, modelCtrl) {
            modelCtrl.$parsers.push(function(inputValue) {
            	var transformedInput = inputValue.replace(/\s+/g,'');
                if (transformedInput != inputValue) {
                    modelCtrl.$setViewValue(transformedInput);
                    modelCtrl.$render();
                }
                return transformedInput;
            });
        }
    };
});
