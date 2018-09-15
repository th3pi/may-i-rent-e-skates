// var cartApp = angular.module("cartApp",[]);
// cartApp.controller("cartCtrl", function ($scope, $http) {
//    $score.refreshCart = function (cartId) {
//        $http.get('/mayi/rest/cart/'+$scope.cartId).success(function (data) {
//            $scope.cart=data;
//        });
//    };
//
//    $scope.clearCart = function () {
//        $http.delete('/mayi/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId))
//    };
//
//    $scope.initCartId =function (cartId) {
//        $scope.cartId = cartId;
//        $scope.refreshCart(cartId);
//    };
//
//    $scope.addToCart = function (productId) {
//        $http.put('/mayi/rest/cart/add/'+productId).success(function (data) {
//            $scope.refreshCart($http.get('/rentskates/rest/cart/cartId'));
//            alert("Product successfully added to the cart!")
//        });
//    };
//
//    $scope.removeFromCart = function (productId) {
//        $http.put('/mayi/rest/cart/remove/'+productId).success(function (data) {
//            $scope.refreshCart($http.get('/rentskates/rest/cart/cartId'));
//        });
//    };
// });


// var cartApp = angular.module ("cartApp", []);
//
// cartApp.controller("cartCtrl", function ($scope, $http){
//
//     $scope.refreshCart = function () {
//         $http.get('/rest/cart/'+$scope.cartId).success(function (data) {
//             $scope.cart=data;
//         });
//     };
//
//     $scope.clearCart = function () {
//         $http.delete('/rest/cart/'+$scope.cartId).success($scope.refreshCart());
//     };
//
//     $scope.initCartId = function (cartId) {
//         $scope.cartId = cartId;
//         $scope.refreshCart(cartId);
//     };
//
//     $scope.addToCart = function (productId) {
//         $http.put('/rest/cart/add/'+productId).success(function () {
//             alert("Product successfully added to the cart!")
//         });
//     };
//
//     $scope.removeFromCart = function (productId) {
//         $http.put('/rest/cart/remove/'+productId).success(function (data) {
//             $scope.refreshCart();
//         });
//     };
//
//     $scope.calGrandTotal = function () {
//         var grandTotal=0;
//
//         for(var i = 0; i < $scope.cart.cartItems.length;i++){
//             grandTotal+=$scope.cart.cartItems[i].totalPrice;
//         }
//
//         return grandTotal;
//     };
// });

var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/rest/cart/add/'+productId).success(function () {
            return null;
        });
    };

    $scope.addMore = function (productId) {
        $http.put('/rest/cart/add/'+productId).success($scope.refreshCart());
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    };
});