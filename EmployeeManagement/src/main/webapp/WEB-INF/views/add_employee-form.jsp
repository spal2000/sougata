<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center;box-shadow: inset 0 0 50px rgba(0,0,0,0.5);height: 697px; width: 1500px">
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12 ">
				<h1 class="text-center mb-3">FILL THE EMPLOYEE DETAILS</h1>
				<form action="add-employee" method="post"
					enctype="multipart/form-data">
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="employeeId">Employee Id</label> <input type="text"
								required="required" class="form-control" id="employeeId"
								name="employeeId" placeholder="ENTER EMPLOYEE ID">
						</div>
						<div class="form-group col-md-4">
							<label for="name">Employee Name</label> <input type="text"
								required="required" class="form-control" id="name" name="name"
								placeholder="ENTER EMPLOYEE NAME">
						</div>
						<div class="form-group col-md-2">
							<label for="age">Employee Age</label> <input type="text"
								class="form-control" required="required" id="age" name="age"
								placeholder="ENTER Employee Age">
						</div>
						<div class="form-group col-md-2">
							<label for="gender">Employee Gender</label> <select
								class="form-control" id="gender" required="required"
								name="gender">
								<option>Male</option>
								<option>Female</option>
								<option>Others</option>
							</select>
						</div>
					</div>
					<br>
					<div class="form-row">

						<div class="form-group col-md-4">
							<label for="department">Employee Department</label> <select
								class="form-control" id="department" required="required"
								name="department">
								<c:forEach var="dept" items="${department}">
									<c:if test="${dept.status==true }">
										<option value="${dept.id}">${dept.name}</option>
									</c:if>
								</c:forEach>

							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="mobileNumber">Employee Mobile Number</label> <input
								required="required" type="text" class="form-control"
								id="mobileNumber" name="mobileNumber"
								placeholder="Mobile Number">
						</div>
						<div class="form-group col-md-4">
							<label for="email">Employee Email</label> <input
								required="required" type="email" class="form-control" id="email"
								name="email" placeholder="Email">
						</div>
					</div>
					<br>
					<div class="form-row">
						<div class="form-group col-md-8">
							<label for="address">Address</label>
							<textarea class="form-control" rows="4" 
								id="address" name="address" placeholder="ENTER Address"></textarea>
						</div>
						<div class="form-group col-md-4">
							<label for="aadharNumber">Employee Aadhar Number</label> <input
								required="required" type="text" class="form-control"
								id="aadharNumber" name="aadharNumber"
								placeholder="Aadhar Number"> <label for="remark">Employee
								Remark</label> <input type="text" class="form-control" id="remark"
								name="remark" placeholder="Remark">
						</div>
					</div>
					<br>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="employeePhoto">Choose Employee Photo</label> <input
								type="file" name="employeePhoto" class="form-control-file"
								id="employeePhoto">
						</div>
						<div class="form-group col-md-4">
							<label for="policeVerificationPhoto">Choose Police
								Verification Photo</label> <input type="file"
								name="policeVerificationPhoto" class="form-control-file"
								id="policeVerificationPhoto">
						</div>
						<div class="form-group col-md-4">
							<label for="employeeAadharPhoto">Choose Aadhar Card Photo</label>
							<input type="file" name="employeeAadharPhoto"
								class="form-control-file" id="employeeAadharPhoto">
						</div>
					</div>

					<br> <br>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/employee"
							class="btn btn-warning">BACK</a>
						<button type="submit" class="btn btn-success">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
