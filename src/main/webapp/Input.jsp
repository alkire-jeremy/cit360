<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="system.css" />	
<script src="index.js"></script>	
<title>System Test: Input</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">System Test: Input</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form action="ClientServlet" method="post"
				class="form-inline my-2 my-lg-0">

				<!-- INPUT TEXT FIELD -->
				<input type="text" name="nextPage" class="form-control mr-sm-2"
					placeholder="Enter a test name.">
				<!-- SUBMIT BUTTON -->
				<button class="btn btn-danger my-2 my-sm-0" type="submit"
					onclick="playSound()">Submit</button>
			</form>
		</div>
	</nav>
	<!-- End Navigation -->

	<br>
	<br>
		<div class="container-fluid">	
	<p>Please enter two numbers.</p>
	<form action="/CIT/Logic.jsp">
		<input type="number" name="inputAddend1" min="1" max="100"><br><br>
		<input type="number" name="inputAddend2" min="1" max="100"><br><br>
		<input type="submit" value="Submit">
	</form>
	</div>

</body>
</html>