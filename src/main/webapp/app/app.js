/*
 * Main Angular module
 *
 * Style guide:
 * avoid polluting global namespace:
 *  var app = angular.module('app');
 *
 */

angular.module('MainApp', []);

/*
 * Add SPA Routing using route provider
 *
 * Style guide:
 * avoid using a variable and instead use chaining with the getter syntax
 *
 */

angular
    .module('MainApp')
    .config(function ($routeProvider) {
        $routeProvider
            .when('/about',
            {
                controller: 'AboutController',
                templateUrl: '/app/partials/about.html'
            })
            .otherwise({ redirectTo: '/about' });
    });