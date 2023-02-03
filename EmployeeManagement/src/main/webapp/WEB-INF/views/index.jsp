<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center;box-shadow: inset 0 0 50px rgba(0,0,0,0.5);">
	<div class="container mt-3">
		<c:if test="${not empty msg }">

			<div class="alert alert-success">

				<b><c:out value="${msg }"></c:out></b>
			</div>

		</c:if>
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mt-2 mb-2">Employee Table</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Employee Id</th>
							<th scope="col">Age</th>
							<th scope="col">Employee Name</th>
							<th scope="col">Department</th>
							<th scope="col">Mobile Number</th>
							<th scope="col">Email</th>
							<th scope="col">Address</th>
							<th scope="col">Gender</th>
							<th scope="col">Status</th>
							<th scope="col">View</th>
							<!--th scope="col">Created By</th>
							<th scope="col">Creation Time</th>
							<th scope="col">Modified By</th>
							<th scope="col">Modification Time</th>
							<th scope="col">Remark</th> -->
							<th scope="col">Update</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${employee }" var="e">
							<tr>
								<th scope="row" style="background-color: green">${e.employeeId }</th>
								<td style="background-color: green">${e.age }</td>
								<td style="background-color: green">${e.name }</td>
								<td style="background-color: green">${e.department.name }</td>
								<td style="background-color: green">${e.mobileNumber }</td>
								<td style="background-color: green">${e.email }</td>
								<td style="background-color: green">${e.address }</td>
								<td style="background-color: green">${e.gender }</td>

								<%-- <td>${e.createdBy }</td>
								<td>${e.creationTime }</td>
								<td>${e.modifiedBy }</td>
								<td>${e.modificationTime }</td>
								<td>${e.remark }</td> --%>
								<td  class="text-center"><c:if test="${e.status == true }">
										<a
											href='<%=request.getContextPath()%>/update_employee_status?id=${e.id }&status=${e.status}'
											class="btn btn-success">Active</a>
									</c:if> <c:if test="${e.status == false }">
										<a
											href='<%=request.getContextPath()%>/update_employee_status?id=${e.id }&status=${e.status}'
											class="btn btn-danger">DeActive</a>
									</c:if></td>
								<td class="text-center"><a
									href='<%=request.getContextPath()%>/view_employee?id=${e.id }'
									class="btn btn-success">View</a></td>
								<td>
									<%-- <a href="delete/${e.id }"><i
										class="fa-solid fa-user-minus text-danger"></i></a> --%> <a
									href="update?id=${e.id }"><i
										class="fa-solid fa-pen-nib text-success"></i><!-- updatess --></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="addemployee" class="btn btn-success">Add
						Employee</a> <a href="home" class="btn btn-warning">Home</a>
						<!-- <a href="departments">deps</a> -->
				</div>

			</div>


		</div>




	</div>


</body>
</html>
