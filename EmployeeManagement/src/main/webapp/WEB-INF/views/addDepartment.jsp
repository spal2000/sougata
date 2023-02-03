<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center;box-shadow: inset 0 0 50px rgba(0,0,0,0.5);height: 697px; width: 1500px">
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">FILL THE DEPATRMENT DETAILS</h1>
				<form action="add_department" method="post">

					<div class="form-group">
						<label for="depId">Department Id</label> <input type="text"
							required="required" class="form-control" id="depId" name="depId"
							placeholder="ENTER DEPARTMENT ID">
					</div>
					<div class="form-group">
						<label for="name">Department Name</label> <input type="text"
							required="required" class="form-control" id="name" name="name"
							placeholder="ENTER NAME">
					</div>

					<div class="form-group">
						<label for="description">Description</label> <textarea
							class="form-control" rows="5" required="required" id="description"
							name="description" placeholder="ENTER DESCRIPTION"></textarea>
					</div>

					<div class="container text-center">

						<a href="${pageContext.request.contextPath }/departments"
							class="btn btn-warning">BACK</a>
						<button type="submit" class="btn btn-success">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
