<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center;box-shadow: inset 0 0 50px rgba(0,0,0,0.5);">
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<h2 class="text-center mt-2 mb-2">Available Departments</h2>

				<table class="table">
					<thead class="thead-dark">
						<tr>

							<th scope="col">Department Id</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Total Employee</th>
							<th scope="col">Total Active Employee</th>
							<th scope="col">Total DeActive Employee</th>
							<th scope="col">Created By</th>
							<th scope="col">Creation Time</th>
							<th scope="col">Modified By</th>
							<th scope="col">Modification Time</th>
							<th scope="col">Status</th>
							<th scope="col">Update</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${department }" var="d">
							<tr>
								<td style="background-color: green">${d.depId }</td>
								<td style="background-color: green">${d.name }</td>
								<td style="background-color: green">${d.description }</td>
								<td style="background-color: green">${d.totalEmployee}</td>
								<td style="background-color: green">${d.totalActiveEmployee }</td>
								<td style="background-color: green">${d.totalDeactiveEmployee }</td>
								<td style="background-color: green">${d.createdBy }</td>
								<td style="background-color: green">${d.creationTime }</td>
								<td style="background-color: green">${d.modifiedBy }</td>
								<td style="background-color: green">${d.modificationTime }</td>
								<td class="text-center"><c:if test="${d.status == true }">
										<a
											href='<%=request.getContextPath()%>/update_department_status?id=${d.id }&status=${d.status}'
											class="btn btn-success">Active</a>
									</c:if> <c:if test="${d.status == false }">
										<a
											href='<%=request.getContextPath()%>/update_department_status?id=${d.id }&status=${d.status}'
											class="btn btn-danger">DeActive</a>
									</c:if></td>
								<td><a href='department/update?id=${d.id }'><i
										class="fa-solid fa-pen-nib text-success"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="addDepartment" class="btn btn-success">Add
						Department</a> <a href="home" class="btn btn-warning">Home</a>
					<!-- <a href="employee">emps</a> --> 
				</div>

			</div>


		</div>




	</div>


</body>
</html>