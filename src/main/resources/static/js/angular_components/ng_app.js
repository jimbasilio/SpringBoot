var springboot = angular.module('springboot', []);
  
springboot.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/hello', {
        templateUrl: 'templates/hello.html',
        controller: 'HelloController'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);