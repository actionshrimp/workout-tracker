'use strict';

angular.module('home', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
])
.config(function ($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'modules/home/view.html',
        controller: 'HomeCtrl'
    })
    .when('/logbook', {
        templateUrl: 'modules/logbook/view.html',
        controller: 'LogBookCtrl'
    })
    .otherwise({
        redirectTo: '/'
    });
});
