
/*
 * Controller for about page
 *
 * Style guide:
 *
 * avoid using a variable and instead use chaining with the getter syntax
 * produces more readable code and avoids variable collisions or leaks.
 *
 * Place bindable members at the top of the controller, not spread through the controller code.
 * Helps you instantly identify which members of the controller can be bound and used in the View
 *
 * Always include "initialize" method to initialize the controller on instantiation
 * Having a single always present initialization method helps with readability.
 *
 * Wrap AngularJS components in an Immediately Invoked Function Expression (IIFE).
 * Removes variables from the global scope
 *
 * Use named functions instead of passing an anonymous function
 * Produces more readable code, reduces the amount of nested callback code
 */

angular
    .module('MainApp')
    .controller('AboutController', function ($scope, dataService) {

        $scope.aboutContent = '';
        $scope.setContent = setContent;

        function setContent() {
            dataService.getAboutContent(function(data) {
                $scope.pojos = data.content;
            });
        }

        function initialize() {
            $scope.setContent();
        }

        initialize();
    });
