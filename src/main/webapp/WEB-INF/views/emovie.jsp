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
  	<form action="updateMovie" method="post">
  			<input type="hidden" name="mid" value="${danger.mid}"/> 
  		
			Title :
			<input type="text" name="title" class="form-control" style="width: 50%"  value="${danger.title}"> 	
			<br/> 	
			Year :
			<select name="year"  class="form-control" style="width: 50%">
					<option ${danger.year==2018?'selected':''}>2018</option>
					<option ${danger.year==2019?'selected':''}>2019</option>
					<option ${danger.year==2020?'selected':''}>2020</option>
					<option ${danger.year==2021?'selected':''}>2021</option>
					<option ${danger.year==2022?'selected':''}>2022</option>
			</select>
			<br/> 	
				Director :
			<input type="text" name="director" class="form-control" style="width: 50%" value="${danger.director}"> 	
			<br/> 	
			Language :
			<select name="language"  class="form-control" style="width: 50%">
			<option ${danger.language=='English'?'selected':''}>English</option>
			<option ${danger.language=='Hindi'?'selected':''}>Hindi</option>
			<option ${danger.language=='Russian'?'selected':''}>Russian</option>
			</select>
			<br/> 	
			Poster :
			<input type="text" name="poster" class="form-control" style="width: 80%"  value="${danger.poster}"> 
			<img src="${danger.poster}" class="img-thumbnail" style="height: 100px;">
				
			<br/> 	
				Story  :
				<textarea  name="story" rows="4" cols=""  class="form-control" style="width: 50%">${danger.story}</textarea>
			<br/> 	
			<button type="submit" class="btn btn-primary">Update Movie</button>
	</form>
	<hr/>
	
</div>

</body>
</html>
