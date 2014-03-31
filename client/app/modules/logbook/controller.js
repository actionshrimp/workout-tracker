'use strict';

angular.module('home').controller('LogBookCtrl', function ($scope, $resource) {
    var Exercise = $resource('/api/exercises/:id', { id: '@id' });
    $scope.exercises = Exercise.query();
});
