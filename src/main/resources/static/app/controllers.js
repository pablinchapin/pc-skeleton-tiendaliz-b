app.controller('AppController', [
    '$scope', '$q', '$http', 'Item',
    function($scope, $q, $http, Item){
        
        Item.query(function(response){
            console.log(response);
           $scope.items = response ? response : [] 
        });
        
        $scope.addItem = addItem;
        $scope.updateItem = updateItem;
        $scope.deleteItem = deleteItem;
        
        function addItem(description){
            new Item({
                description:description,
                checked:false
            }).$save(function(item){
                $scope.items.push(item);
            });
            $scope.newItem = "";
        };
        
        function updateItem(item){
            console.log("update");
            item.$update();
        };
        
        function deleteItem(item){
            console.log("delete");
            item.$remove(function(){
               $scope.items.splice($scope.items.indexOf(item), 1);
            });
        }
        
    }
])