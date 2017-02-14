var app = angular.module('Sectors', []);
	
	app.controller('getSector', function($scope, $http) {	

			window.onload=function()
			{
			  
				document.getElementById('signup').style.display='block';
				document.getElementById('start').style.display='none';
				document.getElementById('question').style.display='none';
					
			};
			
			this.start=function()
			{
				document.getElementById('signup').style.display='none';
				document.getElementById('start').style.display='none';
				document.getElementById('question').style.display='block';
				/*var myVar = setInterval(function() {myTimer()}, 1080);
				var s = 60;
				var m= 30;

				function myTimer() {
					for(m=30; m<0; m--)
					{
						for(s=60; s<0; s--)
							document.getElementById("demo").innerHTML = m +":"+s;;
							
					}
				}*/
			};
			
			
	
	
	this.signup=function()
	{
		/*
		var Uname=document.getElementById('uname').value;
	    var email=document.getElementById('email_id').value;
		  
		  
	  var serviceName='http://localhost:8080/RestDemoService/SignUp';
	 	var varname = {name:Uname,email_id:email};
    var jsonv = JSON.stringify(varname);
	console.log(jsonv);
		$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
		.then(function(response){			//Anonymus function for success callback
		
			console.log(response.data);		//Prints success log
			        $scope.content_new = response.data;

					//this.select(1);*/
			        document.getElementById('start').style.display='block';
					document.getElementById('signup').style.display='none';
					document.getElementById('question').style.display='none';
			       
					alert("You are now logged in , Think beyond ;)");
		/*	
		},function(response){				//Anonymus function for error callback
		
			console.log("There was an error: " + response.status + " " + response.statusText);
											//Prints error log
							});
	
	  */
	};
	
	
	
	});