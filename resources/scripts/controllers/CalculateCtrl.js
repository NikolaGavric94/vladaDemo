angular.module('DynFiles')
   .controller('CalculateCtrl', ['$scope', 'CalculateService', 'HomeService',
      function($scope, CalculateService, HomeService) {
         var vm = this;
         /************/

         vm.files = []; // Array of files for list

         bSuccessMessage = true; // Show success message for ajax calls
         bFailMessage = true; // Show faul message for ajax calls
         /*----------  Init function  ----------*/
         function init() {
            vm.getFiles();
         }

         /*----------  Click methods  ----------*/
         vm.getFiles = function() { // Get all files for list
            HomeService.getFiles().then(function(result) {
               vm.files = result.data;
               if (bSuccessMessage) {
                  console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@ getFiles - SUCCESSFUL");
               }
            }, function() {
               if (bFailMessage) {
                  console.log("~~~~~~~~~~~~~~~~~~~~~~~~~~ getFiles - FAILED");
               }
            });
         }

         /*----------  Construct  ----------*/
         init();
      }
   ]);