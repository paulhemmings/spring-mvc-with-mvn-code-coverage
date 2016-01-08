
/*
 * Data provider service.
 * Used to retrieve data from external service
 *
 * Style guide:
 * avoid using a variable and instead use chaining with the getter syntax
 * produces more readable code and avoids variable collisions or leaks.
 *
 */

angular
    .module('MainApp')
    .service('dataService', function($http) {

        this.getAboutContent = function (callback) {
            $http({
                url: '/content',
                method: "GET"
            })
                .success(function(data, status, headers, config) {
                    callback({ success: true, content: data, status: 'success'});
                })
                .error(function(data, status, headers, config) {
                    callback({ success: false, content: [], status: 'failed to load pojos set'});
                });
        };
    });