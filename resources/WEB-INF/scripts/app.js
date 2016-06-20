'use strict';

/**
 * @ngdoc overview
 * @name smashApp
 * @description
 * # smashApp
 *
 * Main module of the application.
 */

angular
    .module('smashApp', [
        'ngRoute',
        'routeStyles',
        'ngTable',
    ])
    .config(function ($routeProvider, $locationProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm',
                css: 'styles/main.css'
            })
            .when('/home', {
                templateUrl: 'views/home.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm',
                css: 'styles/main.css'
            });

    });
