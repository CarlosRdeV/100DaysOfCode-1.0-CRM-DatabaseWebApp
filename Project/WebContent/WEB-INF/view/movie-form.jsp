<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
 
<html>
 
<head>
	<title>Save Movie</title>
	
	<!-- references our style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>

	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-movie-style.css"/>	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Save Movie</h2>
		</div>
	</div>

	<div id=container>
		<form:form action="saveMovie" modelAttribute="movie" method="POST">
		
			<table>
				<tbody>
						<tr>
							<td><label>Name: </label></td>
							<td><form:input path="name"/></td>
						</tr>
						<tr>
							<td><label>Year: </label></td>
							<td><form:input path="year"/></td>
						</tr>
						<tr>
							<td><label>Rating: </label></td>
							<td><form:input path="rating"/></td>
						</tr>
												
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/movie/list">
			Back to List
			</a>
		</p>
	</div>
  
</body>
 
</html>