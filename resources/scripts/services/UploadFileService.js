angular.module('DynFiles')
   .factory('UploadFileService', ['$http', '$rootScope',
      function($http, $rootScope) {
         var service = {};

         var ajaxPrefix = $rootScope.ajaxHostPrefix;

         return service;
      }
   ])