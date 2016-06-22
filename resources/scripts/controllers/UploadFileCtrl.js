angular.module('DynFiles')
   .controller('UploadFileCtrl', ['$scope', '$rootScope', 'FileUploader',
      function($scope, $rootScope, FileUploader) {
         var vm = this;
         /************/

         vm.fileUploader = new FileUploader();
         vm.fileUploader.url = $rootScope.ajaxHostPrefix + "upload";

         bSuccessMessage = true; // Show success message for ajax calls
         bFailMessage = true; // Show faul message for ajax calls
         /*----------  Init function  ----------*/
         function init() {}

         /*----------  Construct  ----------*/

         //After selecting file
         //Testing purpose
         vm.fileUploader.onAfterAddingFile = function(fileItem) {
            console.info('onAfterAddingFile', fileItem);
         };
         vm.upload = function() {
            vm.fileUploader.uploadItem(0);
            vm.fileUploader.onSuccessItem = function(fileItem, re, status, headers) {
               console.log(1);
            };

            vm.fileUploader.onErrorItem = function(fileItem, res, status, headers) {
               console.log(2);
            };
         }

         init();
      }
   ]);