'use strict';

describe('Controller: LogbookCtrl', function () {

    beforeEach(module('home'));

    var scope, httpBackend, createController;

    beforeEach(inject(function ($injector, $controller, $rootScope) {
        scope = $rootScope.$new();
        httpBackend = $injector.get('$httpBackend');
        httpBackend.expectGET('/api/exercises').respond([
            { name: 'name', notes: 'notes', last: 'last', current: 'current' }
        ]);

        createController = function () {
            var controller = $controller('LogBookCtrl', {
                $scope: scope
            });
            httpBackend.flush();
            return controller;
        };
    }));

    it('fetches exercises from the api', function () {
        createController();
    });

    it('should attach a list of exercises to the scope', function () {
        createController();
        expect(scope.exercises.length).toBeDefined();
    });

    it('should give each exercise a name, notes, last and current', function () {
        createController();
        expect(scope.exercises.length).toBeGreaterThan(0);
        _.forEach(scope.exercises, function (exercise) {
            expect(exercise.name).toBeDefined();
            expect(exercise.notes).toBeDefined();
            expect(exercise.last).toBeDefined();
            expect(exercise.current).toBeDefined();
        });
    });
});
