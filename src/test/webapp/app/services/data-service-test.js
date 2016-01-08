describe('MainApp', function () {

    var service,
        mockHttp = {
        };

    beforeEach(function () {
        module('MainApp');
    });

    describe('DataService', function () {

        beforeEach(inject(function (_dataService_, $http) {
            service = _dataService_,
            mockHttp = $http;
        }));

        it("should return list data", function() {
            // to do.
        });
    });
});