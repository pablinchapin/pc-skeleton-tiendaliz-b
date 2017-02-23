angular.module('appService', [ 
    'ngResource'    
])
.factory('Item', [
    '$resource',
    function($resource){
        return $resource('http://localhost:8080/items',
        {id: '@id'},
        {
            update: {
                method: 'PUT'
            },
            remove: {
                method: 'DELETE'
            }
        });
    }
]);