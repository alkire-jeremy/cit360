<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="hibernate.utils.GetAllData"%>

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
<title>System Test: Error</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg">
		<a class="navbar-brand" href="#">Systems Test</a>
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
	
	<div class="container-fluid">
	<br>Invalid input. Please provide a valid entry.<br>
	<br>Examples are:<br><br>
	<ul>
		<li>Hibernate</li>
		<li>Input</li>
		<li>Home</li>
	</ul>
	</div>
</body>
</html>