'use strict';

describe('Controller: LogbookCtrl', function () {

    beforeEach(module('home'));

    var controller, scope;

    beforeEach(inject(function ($controller, $rootScope) {
        scope = $rootScope.$new();
        controller = $controller('LogBookCtrl', { $scope: scope });
    }));

    it('should attach a list of exercises to the scope', function () {
        expect(scope.exercises.length).toBeDefined();
    });

    it('should give each exercise a name, notes, last and current', function () {
        expect(scope.exercises.length).toBeGreaterThan(0);
        _.forEach(scope.exercises, function (exercise) {
            expect(exercise.name).toBeDefined();
            expect(exercise.notes).toBeDefined();
            expect(exercise.last).toBeDefined();
            expect(exercise.current).toBeDefined();
        });
    });
});
