<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <%@include file="header.jsp" %>
  	<br/> 	<br/> 	<br/> 
  	<form action="addMovie" method="post">
			Title :
			<input type="text" name="title" class="form-control" style="width: 50%"> 	
			<br/> 	
			Year :
			<select name="year"  class="form-control" style="width: 50%">
					<option>2018</option>
					<option>2019</option>
					<option>2020</option>
					<option>2021</option>
					<option>2022</option>
			</select>
			<br/> 	
				Director :
			<input type="text" name="director" class="form-control" style="width: 50%"> 	
			<br/> 	
			Language :
			<select name="language"  class="form-control" style="width: 50%">
					<option>English</option>
					<option>Hindi</option>
						<option>Russian</option>
			</select>
			<br/> 	
			Poster :
			<input type="text" name="poster" class="form-control" style="width: 80%"> 	
			<br/> 	
				Story  :
				<textarea  name="story" rows="4" cols=""  class="form-control" style="width: 50%"></textarea>
			<br/> 	
			<button type="submit" class="btn btn-primary">Add Movie</button>
	</form>
	<hr/>
	
</div>

</body>
</html>
