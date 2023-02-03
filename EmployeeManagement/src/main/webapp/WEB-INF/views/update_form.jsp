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
			<div class="col-md-12">
				<h1 class="text-center mb-3">CHANGE THE EMPLOYEE DETAILS</h1>
				
				<form
					action="${pageContext.request.contextPath }/update-employee?id=${employee.id}"
					method="post">

					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="employeeId">Employee Id</label> <input type="text"
								required="required" class="form-control" id="employeeId"
								name="employeeId" value="${employee.employeeId }">
						</div>
						<div class="form-group col-md-4">
							<label for="name">Employee Name</label> <input type="text"
								required="required" class="form-control" id="name" name="name"
								placeholder="ENTER EMPLOYEE NAME" value="${employee.name }">
						</div>
						<div class="form-group col-md-2">
							<label for="age">Employee Age</label> <input type="text"
								class="form-control" required="required" id="age" name="age"
								value="${employee.age }">
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
									<c:if test="${dept.status == true }">
									<c:choose>
										<c:when test="${dept.id == employee.department.id }">
											<option selected="selected" value="${dept.id}">${dept.name}</option>
										</c:when>
										<c:otherwise>
											<option value="${dept.id}">${dept.name}</option>
										</c:otherwise>
									</c:choose>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="mobileNumber">Employee Mobile Number</label> <input
								required="required" type="text" class="form-control"
								id="mobileNumber" name="mobileNumber"
								value="${employee.mobileNumber }">
						</div>
						<div class="form-group col-md-4">
							<label for="email">Employee Email</label> <input
								required="required" type="email" class="form-control" id="email"
								name="email" value="${employee.email }">
						</div>
					</div>
					<br>
					<div class="form-row">
						<div class="form-group col-md-8">
							<label for="address">Address</label>
							<textarea class="form-control" rows="4" required="required"
								id="address" name="address" placeholder="ENTER Address">${employee.address }</textarea>
						</div>
						<div class="form-group col-md-4">
							<label for="aadharNumber">Employee Aadhar Number</label> <input
								required="required" type="text" class="form-control"
								id="aadharNumber" name="aadharNumber"
								value="${employee.aadharNumber }"> <label for="remark">Employee
								Remark</label> <input type="text" class="form-control" id="remark"
								name="remark" value="${employee.remark }">
						</div>
					</div>
					<div class="container text-center">

						<a href="${pageContext.request.contextPath }/employee"
							class="btn btn-warning">BACK</a>
						<button type="submit" class="btn btn-success">UPDATE</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
