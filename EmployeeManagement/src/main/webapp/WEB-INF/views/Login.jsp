<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Login page</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>
<%@include file="./base.jsp"%>
</head>
<body
	style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center; box-shadow: inset 0 0 50px rgba(0, 0, 0, 0.5); height: 713px; width: 1500px">

	<marquee scrollmount="12" direction="left" height="100px">
		<h1 class="alert-heading" style="color: red;">WELCOME TO EMPLOYEE MANAGEMENT SYSTEM</h1>
	</marquee>
	<div class="container mt-3">

		<c:if test="${not empty msg }">

			<div class="alert alert-success">

				<b><c:out value="${msg }"></c:out></b>
			</div>

		</c:if>
		<form action="login_user" method="post" class="form signin">

			<h1 class="h3 mb-3 font-weight-normal text-center">Please sign
				in</h1>
			<div class="col-md-4 offset-md-4">
				<!-- User Name input -->
				<div class="form-group">
					<label for="userName">UserName</label> <input type="text"
						required="required" class="form-control" id="userName"
						name="userName" placeholder="ENTER USERNAME" width="48"
						height="48">
				</div>

				<!-- Password input -->
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" required="required" id="password"
						name="password" placeholder="ENTER PASSWORD" width="48"
						height="48">
				</div>

				<br> <br>

				<!-- 2 column grid layout for inline styling -->
				<!-- <div class="row mb-4">
				<div class="col d-flex justify-content-center">
					Checkbox
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="form2Example31" checked /> <label class="form-check-label"
							for="form2Example31"> Remember me </label>
					</div>
				</div>

				<div class="col">
					Simple link
					<a href="#!">Forgot password?</a>
				</div>
			</div> -->

				<!-- Submit button -->
				<button type="submit" class="btn btn-primary btn-block mb-4">Sign
					in</button>
			</div>
			<!-- Register buttons -->
			<!-- <div class="text-center">
				<p>
					Not a member? <a href="Register">Register</a>
				</p>
				<p>or sign up with:</p>
				<button type="button" class="btn btn-link btn-floating mx-1">
					<i class="fab fa-facebook-f"></i>
				</button>

				<button type="button" class="btn btn-link btn-floating mx-1">
					<i class="fab fa-google"></i>
				</button>

				<button type="button" class="btn btn-link btn-floating mx-1">
					<i class="fab fa-twitter"></i>
				</button>

				<button type="button" class="btn btn-link btn-floating mx-1">
					<i class="fab fa-github"></i>
				</button>
			</div> -->

			<p class="mt-5 mb-3 text-muted text-center">© 2023-2024</p>
			<h4 class="text-center" style="color: yellow;">By Sougata</h4>

		</form>
	</div>
</body>
</html>