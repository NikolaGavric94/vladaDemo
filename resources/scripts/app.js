angular
   .module('DynFiles', [
      'ngRoute',
      'routeStyles',
      'ngTable',
      'ui.ace'
   ])
   .config(function($routeProvider, $locationProvider, $httpProvider) {
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
         })
         .when('/calculate', {
            templateUrl: 'views/calculate.html',
            controller: 'CalculateCtrl',
            controllerAs: 'vm',
            css: 'styles/main.css'
         });
   })
   .run(function($rootScope) {
      $rootScope.ajaxHostPrefix = 'http://localhost:8091/vladaDemo/rest/';
   });