<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Details of Employee</title>
<%@include file="./base.jsp"%>
<style>
#container {
	display: flex;
	justify-content: space-between;
}

table {
	width: 100%;
}
</style>
</head>
<body
	style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center; box-shadow: inset 0 0 50px rgba(0, 0, 0, 0.5); height: 713px; width: 1500px">
	<h1 class="text-center">Individual Employee Details</h1>
	<div id="container" class="col-12 mt-3">
		<table
			class="table table-striped table-success table-bordered table-hover">
			<tr>
				<td><strong>ID:</strong></td>
				<td>${employee.id}</td>
			</tr>
			<tr>
				<td><strong>EmployeeId:</strong></td>
				<td>${employee.employeeId}</td>
			</tr>
			<tr>
				<td><strong>Name:</strong></td>
				<td>${employee.name}</td>
			</tr>
			<tr>
				<td><strong>Age:</strong></td>
				<td>${employee.age}</td>
			</tr>
			<tr>
				<td><strong>Email:</strong></td>
				<td>${employee.email}</td>
			</tr>
			<tr>
				<td><strong>Gender:</strong></td>
				<td>${employee.gender}</td>
			</tr>
			<tr>
				<td><strong>Mobile No:</strong></td>
				<td>${employee.mobileNumber}</td>
			</tr>
			<tr>
				<td><strong>Aadhar number:</strong></td>
				<td>${employee.aadharNumber}</td>
			</tr>
			<tr>
				<td><strong>Department:</strong></td>
				<td>${employee.department.getName()}</td>
			</tr>
			<tr>
				<td><strong>Address:</strong></td>
				<td>${employee.address}</td>
			</tr>
			<tr>
				<td><strong>Created By:</strong></td>
				<td>${employee.createdBy}</td>
			</tr>
		</table>
		<table
			class="table table-striped table-success table-bordered table-hover">
			<tr>
				<td><strong>CreationTime:</strong></td>
				<td>${employee.creationTime}</td>
			</tr>
			<tr>
				<td><strong>Modified By:</strong></td>
				<td>${employee.modifiedBy}</td>
			</tr>
			<tr>
				<td><strong>Modification Time:</strong></td>
				<td>${employee.modificationTime}</td>
			</tr>
			<tr>
				<td><strong>Remark:</strong></td>
				<td>${employee.remark}</td>
			</tr>
			<tr>
				<td><strong>Status:</strong></td>
				<td><c:if test="${employee.status ==true }">Active</c:if> <c:if
						test="${employee.status ==false }">Deactive</c:if></td>
			</tr>
			<tr>
				<td><strong>Employee Photo:</strong></td>
				<td><img src="data:image/jpg;base64,${employeePhoto} "
					height="70" width="70" alt="Employee Photo"></td>
			</tr>
			<tr>
				<td><strong>Police Verification Photo:</strong></td>
				<td><img
					src="data:image/jpg;base64,${policeVerificationPhoto} " height="70"
					width="70" alt="Employee Photo"></td>
			</tr>
			<tr>
				<td><strong>Employee AadharCard Photo:</strong></td>
				<td><img src="data:image/jpg;base64,${employeeAadharPhoto} "
					height="70" width="70" alt="Employee Photo"></td>
			</tr>
		</table>
	</div>
	<br>
	<div class="container text-center">
		<a href="${pageContext.request.contextPath }/employee"
			class="btn btn-danger">BACK</a> <a href="home"
			class="btn btn-warning">Home</a>

	</div>
</body>
</html>