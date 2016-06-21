(function() {
   'use strict';

   angular.module('DynFiles').controller('HomeCtrl', ['$scope',
      function($scope) {
         var vm = this;
         vm.mario = '';

         vm.files = [{
            name: 'File 1'
         }, {
            name: 'File 2'
         }, {
            name: 'File 3'
         }, {
            name: 'File 4'
         }, {
            name: 'File 5'
         }, {
            name: 'File 6'
         }, {
            name: 'File 7'
         }, {
            name: 'File 8'
         }, {
            name: 'File 9'
         }, {
            name: 'File 10'
         }]

         function init() {

         }

         /*----------  Construct  ----------*/
         init();
      }
   ])
})();