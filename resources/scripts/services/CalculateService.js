angular.module('DynFiles')
   .factory('CalculateService', ['$http', '$rootScope',
      function($http, $rootScope) {
         var service = {};

         var ajaxPrefix = $rootScope.ajaxHostPrefix;



         return service;
      }
   ])