var myApp = angular.module("myApp", [ 'ngRoute' , 'ngCookies' ]);
myApp.config(function($routeProvider) {
	alert("Route Provider");
	$routeProvider.when("/login", {templateUrl : "web/c_user/LogIn.html"})
				  .when("/register", {templateUrl : "web/c_user/SignUp.html"})
				  .when("/addBlog", {templateUrl : "web/c_blog/AddBlog.html"})
				  .when("/manageAllBlogs", {templateUrl : "web/c_user/ManageAllBlogs.html"})
				  .when("/showAllBlogs", {templateUrl : "web/c_user/LogIn.html"})
				  
			

});
