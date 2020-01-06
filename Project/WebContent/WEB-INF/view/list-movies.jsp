<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
 
<html>
 
<head>
	<title>List Movies</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Movie Tracker</h2>
		</div>
	</div>
  
  	<div id="container">
  	
  		<!-- add our html table here -->
  	
  		<table>
  			<tr>
  				<th>Id</th>
  				<th>Name</th>
  				<th>Year</th>
  				<th>Rating</th>
  			</tr>
  			
  		<!-- loop over and print our movies -->
		<c:forEach var="tempMovie" items="${movies}">
  		 <tr>
  		 	<td>${tempMovie.id}</td>
  		 	<td>${tempMovie.name}</td>
  		 	<td>${tempMovie.year}</td>
  		 	<td>${tempMovie.rating}</td>
  		 </tr>
  		 
  		 </c:forEach>
  		</table>
  
  	</div>
  
</body>
 
</html>