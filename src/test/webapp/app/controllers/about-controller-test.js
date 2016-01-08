describe('MainApp', function () {

    var scope,
        controller,
        mockDataService = {
            getAboutContent : function(callbackfn) {
                return 'about-content';
            }
        };

    beforeEach(function () {
        module('MainApp');
    });

    describe('AboutController', function () {

        beforeEach(inject(function ($rootScope, $controller) {
            scope = $rootScope.$new();
            controller = $controller('AboutController', {
                '$scope': scope,
                'dataService' : mockDataService
            });
        }));

        it("contains spec with an expectation", function() {
            expect(true).toBe(true);
        });

        it('makes a call to get about content', function () {
            spyOn(mockDataService, 'getAboutContent');
            scope.setContent();
            expect(mockDataService.getAboutContent).toHaveBeenCalled();
        });

    });
});