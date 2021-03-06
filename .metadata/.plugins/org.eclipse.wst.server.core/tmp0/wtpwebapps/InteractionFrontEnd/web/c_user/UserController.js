myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
{

	$scope.user={'loginname':'','password':'','username':'','emailid':'','mobileno':'','address':'','role':''};
	
	$scope.register=function()
	{
		console.log('Entered the Register Function');
		$scope.User.role='ROLE_USER';
		$http.post('http://localhost:8083/InteractionMiddleware/registerUser',$scope.user)
			.then(function(response)
			{
				console.log('Registered');
				$location.path("/login");
			});
	}
	
	$scope.logincheck=function()
	{
		console.log('Enter the Login Check Function')
		$http.post('http://localhost:8083/InteractionMiddleware/checkUser',$scope.user)
		.then(function(response)
		{
			console.log('Login Checked');
			$scope.User=response.data;
			$rootScope.currentUser=response.data;
			$cookieStore.put('userDetails',response.data);
			console.log($rootScope.currentUser);
			$location.path("/userhome");
		});
	}
	
	$scope.logout=function()
	{
		console.log('I am in logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("/logout");
	}
	
	
});