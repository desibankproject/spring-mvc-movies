<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">

  		//loadData();
  		
  		alert("_@__@Loading page wait please");
  		
  		function loadData() {
  			fetch('http://localhost:444/movie-spring-jdbc/movies/json').then(function(response) { 
  				//Reading raw jason data from body Convert to JavaScript object
  					return response.json();
  			}).then(function(data) {
  					console.log(data); 
  					var listdata="<ul>";
  					for(var x=0;x<data.length;x++) {
  						var item=data[x];
						console.log(item);
						listdata=listdata+"<li>"+item.title+"</li>";
  		  	  		}
  					listdata=listdata+"</ul>"
					//alert(listdata);
					document.getElementById("showData").innerHTML=listdata;
  					
  			});
  	  	 }

  </script>
  
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <h2>Factorial of num</h2>
<img src="img/math.jpg"  style="height: 200px;">
  		<br/> 	<br/> 	
  		<button type="button" class="btn btn-primary" onclick="loadData();">Load Data Now!</button>
  		<br/> 
  		<hr/>
  		<h2>Movies Lists</h2>
  		<div  id="showData">
  		
  		</div>
  	
</div>

</body>
</html>
