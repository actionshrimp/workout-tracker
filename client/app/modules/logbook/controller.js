'use strict';

angular.module('home').controller('LogBookCtrl', function ($scope) {
    $scope.exercises = [{
        name: 'name',
        notes: 'notes',
        last: 'last',
        current: 'current'
    }];
});
