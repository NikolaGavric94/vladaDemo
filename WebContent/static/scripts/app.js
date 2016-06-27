angular
   .module('DynFiles', [
      'ngRoute',
      'routeStyles',
      'ngTable',
      'ui.ace',
      'angularFileUpload'
   ])
   .config(function($routeProvider, $locationProvider, $httpProvider) {
      $routeProvider
         .when('/', {
            templateUrl: 'static/views/home.html',
            controller: 'HomeCtrl',
            controllerAs: 'vm'
         })
         .when('/home', {
            templateUrl: 'static/views/home.html',
            controller: 'HomeCtrl',
            controllerAs: 'vm'
         })
         .when('/calculate', {
            templateUrl: 'static/views/calculate.html',
            controller: 'CalculateCtrl',
            controllerAs: 'vm'
         })
         .when('/uploadFile', {
            templateUrl: 'static/views/upload_file.html',
            controller: 'UploadFileCtrl',
            controllerAs: 'vm'
         });
   })
   .run(function($rootScope) {
      $rootScope.ajaxHostPrefix = 'http://localhost:8091/vladaDemo/rest/';
   });