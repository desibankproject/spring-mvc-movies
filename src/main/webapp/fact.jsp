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

  	function clearError() {
  		window.document.getElementById("numError").innerHTML="";
  		document.getElementById("resultimage").src="";
    }

	function computeFact(){
			console.log("This is called .....");
			var  num=window.document.fform.num.value;
			if(num.length==0) {
				window.document.getElementById("numError").innerHTML="Num cannot be empty.";
				window.document.fform.num.focus();
				//document.getElementById("resultimage") =>>> this will give you an object of img 
				document.getElementById("resultimage").src="img/error.jpg";
				return;
			}else{
				var f=1;
				for(var x=2;x<=num;x++){
					 f=f*x; 
				}
				document.getElementById("resultimage").src="img/result.png";
				window.document.getElementById("result").innerHTML="Factorial of "+num +" is  "+f;
			}
    }

  </script>
  
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <h2>Factorial of num</h2>
<img src="img/math.jpg"  style="height: 200px;">
  	<span style="color:red;font-size: 18px;">${message}</span>
  		<br/> 	<br/> 
  	<form name="fform">
			Number :
			<input type="text" name="num" class="form-control" style="width: 50%" onkeydown="clearError();"> 	
			<span style="color:red;font-weight: bold;"  id="numError">...</span>
			<br/> 	
			
			<br/> 	
			<button type="button" class="btn btn-primary"  onclick="computeFact();">Show Fact</button>
	</form>
	<hr/>
	<img src=""  id="resultimage" style="height: 200px;">
	<br/>
	 Result is <span style="color:red;font-weight: bold;"  id="result">coming soon</span>
</div>

</body>
</html>
