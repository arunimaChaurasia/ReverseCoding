var app = angular.module('Sectors', []);
	
	var score;
	var count;
	var skipcount;
	var cntques=1;
	app.controller('getSector', function($scope,$http,$timeout) {

		window.onload=function()
			{
			  
				document.getElementById('signup').style.display='block';
				document.getElementById('start').style.display='none';
				document.getElementById('question').style.display='none';
				document.getElementById('lastpage').style.display='none';	
				document.getElementById('board').style.display='none';
				document.getElementById('submitbtn').style.display='none';
					
			};
			
			
			this.start=function()
			{
				document.getElementById('signup').style.display='none';
				document.getElementById('start').style.display='none';
				document.getElementById('question').style.display='block';
				document.getElementById('lastpage').style.display='none';
	            
				document.getElementById('submitbtn').style.display='none';
				document.getElementById("insert").innerHTML = count;
				count++;
		
			this.rand();
				this.startTime();
				
				
			
			};
				
			this.rand=function() {
				var number=Math.floor(Math.random() * $scope.questions.length);
				
				var randNo=new Array();
				
						if(!randNo.includes(number))
						{
							$scope.randomQuestion= $scope.questions[number]; 
							randNo.push(number);
						}
				
				/*
				else
				{
					this.rand();
				}*/
			};
			
			this.startTime=function() {
				$scope.timeInSec =0;
				$scope.timeInMin =30;
  
  
				var countUp = function() {
					if($scope.timeInSec ===0)
					{
											

						$scope.timeInMin-=1;
						$scope.timeInSec =60;
					}
				$scope.timeInSec-= 1;
				if($scope.timeInMin ===-1)
				{
					document.getElementById('signup').style.display='none';
					document.getElementById('start').style.display='none';
					document.getElementById('question').style.display='none';
					document.getElementById('lastpage').style.display='block';
					document.getElementById('submitbtn').style.display='none';
					document.getElementById("showsc").innerHTML = "YOUR SCORE :"+score;
				}
				else
				{
					$timeout(countUp, 1000);
				}
				
			}
    
			$timeout(countUp, 1000);
			}
			
			
			this.showscore=function()
			{
				document.getElementById('signup').style.display='none';
				document.getElementById('start').style.display='none';
				document.getElementById('question').style.display='none';
				document.getElementById('lastpage').style.display='block';
				document.getElementById('submitbtn').style.display='none';
				document.getElementById("showsc").innerHTML = "YOUR SCORE :"+score;
			}
			
			this.next=function()
			{
				if(document.getElementById('o1').checked || document.getElementById('o2').checked || document.getElementById('o3').checked || document.getElementById('o4').checked)
					{
					
					document.getElementById("score").innerHTML = "SCORE :"+score;
					this.qno();	
					this.rand();
					var sco=score;
					
					var serviceName='http://172.16.26.3:8080/RestDemoService/Savenew';
					var varname = {email_id:$scope.Uname,points:sco};
					var jsonv = JSON.stringify(varname);
						console.log(jsonv);
					$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
					.then(function(response){			//Anonymus function for success callback
			
						console.log(response.data);		//Prints success log
				        $scope.content_new = response.data;
					},function(response){				//Anonymus function for error callback
			
							console.log("There was an error: " + response.status + " " + response.statusText);
												//Prints error log
								});
					
					 document.getElementById("o1").checked = false;
					 document.getElementById("o2").checked = false;
					 document.getElementById("o3").checked = false;
					 document.getElementById("o4").checked = false;

					}
				else
					{
						alert("PLEASE CHOOSE AN OPTION ");
					}
					
	 
				
			};

			
			this.skip=function()
			{
				if(skipcount<3)
				{
					this.qno();	
					this.rand();
					skipcount+=1;
				}
				if(skipcount===3)
				{
					window.alert("YOU CAN SKIP ONLY 3 QUESTIONS");
					//document.getElementById("skipbtn").style.display='none';
					
				}
								

			};
			
			this.submitest=function()
			{
				this.showscore();
				var sco=score;

								var serviceName='http://172.16.26.3:8080/RestDemoService/Submit';
				var varname = {email_id:$scope.Uname};
				var jsonv = JSON.stringify(varname);
					console.log(jsonv);
				$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
				.then(function(response){			//Anonymus function for success callback
		
					console.log(response.data);		//Prints success log
			        $scope.content_new = response.data;
				},function(response){				//Anonymus function for error callback
		
						console.log("There was an error: " + response.status + " " + response.statusText);
											//Prints error log
							});
				
			};
			
		this.check=function(ono,corrans)
	{
		var o_no;
		var myans="";
		var corr_ans;
		
		this.o_no=ono;
		
		this.corr_ans=corrans;
		if(this.o_no===1)
			this.myans=document.getElementById('o1').value;
		if(this.o_no===2)
			this.myans=document.getElementById('o2').value;
		if(this.o_no===3)
			this.myans=document.getElementById('o3').value;
		if(this.o_no===4)
			this.myans=document.getElementById('o4').value;
		if((this.myans.localeCompare(this.corr_ans))===0)
			score+=4;
		else
			score-=1;
		

	}
	

	this.qno=function()
	{
		if(count<51)
			{
			document.getElementById("insert").innerHTML = count;
			count++;
			}
		else
			{
			alert("THANK YOU !! PLEASE PRESS SUBMIT");
			document.getElementById('question').style.display='none';
			document.getElementById('submitbtn').style.display='block';
			}
		
	}
	
	this.question=function(lev)
	{
		count=1;
		score=0;
		skipcount=0;
		var Lev=lev;
		 
		 $scope.x=0;
			 
		document.getElementById("score").innerHTML = "SCORE: "+score;

				
				serviceName='http://172.16.26.3:8080/RestDemoService/requestQuestion';
				
				
				
					var varname = {level:Lev};
					    var jsonv = JSON.stringify(varname);

				
				$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
								.then(function(response) {
										$scope.questions = response.data;
        
										$scope.statustext = response.status;
											console.log($scope.questions);
											
											//console.log(statustext);

        
											},function(response){				//Anonymus function for error callback
							
								console.log("There was an error: " + response.status + " " + response.statusText);
																//Prints error log
												});
												
		
					
					
	};

	this.leader=function()
	{
		$http.get('http://172.16.26.3:8080/RestDemoService/Leader')
		.then(function(response) {
$scope.lead = response.data;

console.log($scope.lead);

$scope.statustext = response.status;
document.getElementById('lastpage').style.display='none';
document.getElementById('submitbtn').style.display='none';
document.getElementById('board').style.display='block';


								});
	}
	
	
	this.signup=function()
	{
		


		$scope.Uname=document.getElementById('uname').value;
	    var email=document.getElementById('email_id').value;
		  
		  if($scope.Uname=="" || email=="")
			  {
			  alert("FILL ALL THE DETAILS PLEASE!!!");
			  
			  }
		  else {
			  
			  var serviceName='http://172.16.26.3:8080/RestDemoService/SignUp';
			 	var varname = {email_id:$scope.Uname,password:email};
		    var jsonv = JSON.stringify(varname);
			console.log(jsonv);
				$http.post(serviceName,jsonv,{'Content':'application/json','Accept':'application/json'})
				.then(function(response){			//Anonymus function for success callback
				
					console.log(response.data);		//Prints success log
					        $scope.content_new = response.data;

							
					        document.getElementById('start').style.display='block';
							document.getElementById('signup').style.display='none';
							document.getElementById('question').style.display='none';
					       
							alert("You are now logged in , Think beyond ;)");
							
							
				
				},function(response){				//Anonymus function for error callback
				
					console.log("There was an error: " + response.status + " " + response.statusText);
													//Prints error log
									});
			
			  
			}
			
			

		  };
	  	
	});
	
	
