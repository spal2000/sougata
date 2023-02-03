<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<%@include file="./base.jsp"%>
</head>
<body>

	<nav class="navbar navbar-dark bg-info">
		<p class="navbar-brand">Employee Management System</p>
		<!-- <button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button> -->
		<a class="nav-item nav-link bg-warning alert-dark" href="user">Users</a>
		<a class="nav-item nav-link bg-warning alert-dark" href="departments">Departments</a>
		<a class="nav-item nav-link bg-warning alert-dark" href="employee">Employees</a>
		<a class="nav-item nav-link bg-warning alert-dark" href="Register">Register</a>
		<a class="nav-item nav-link bg-warning alert-dark" href="log_out">Log Out</a>
		<!-- <div class="navbar-nav"></div>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		</div> -->
	</nav>
	<div id="carouselExampleControls" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://yirontechnologies.com/wp-content/uploads/2019/11/bg.jpeg"
					style="height: 641px; width: 1600px" alt="...">
			</div>
			<div class="carousel-item">
				<img
					src="https://girsberger.com/fileadmin/_processed_/4/4/csm_girsberger-linq-anwendungen-k-00_18890d3f9c.jpg"
					style="height: 641px; width: 1600px" alt="...">
			</div>
			<div class="carousel-item">
				<img
					src="https://images.unsplash.com/photo-1594235048794-fae8583a5af5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dGVjaCUyMG9mZmljZXxlbnwwfHwwfHw%3D&w=1000&q=80"
					style="height: 641px; width: 1600px" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" style="height: 64px; width: 40px" type="button"
			data-target="#carouselExampleControls" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
		</button>
		<button class="carousel-control-next" style="height: 64px; width: 40px" type="button"
			data-target="#carouselExampleControls" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
		</button>
	</div>
</body>
</html>