<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body onload="hideMessage()"
	style="background-image: url(https://www.yirontechnologies.com/wp-content/uploads/2022/04/about-ban.png); background-repeat: no-repeat; background-size: cover; background-position: center center; box-shadow: inset 0 0 50px rgba(0, 0, 0, 0.5);">



	<div class="container mt-3">

		<c:if test="${not empty msg }">

			<div id="msg" class="show alert alert-success">

				<b><c:out value="${msg }"></c:out></b>
			</div>

		</c:if>
		<script>
			function hideMessage() {
				setTimeout(function() {
					var message = document.getElementById('msg');
					message.style.display = 'none';
				}, 3000);
			}
		</script>
		<div class="row">
			<div class="col-md-12">


				<h2 class="text-center mt-2 mb-2">User Table</h2>

				<table class="table">
					<thead class="thead-dark">
						<tr>

							<th scope="col">Name</th>
							<th scope="col">UserName</th>
							<th scope="col">Password</th>
							<th scope="col">Created By</th>
							<th scope="col">Creation Time</th>
							<th scope="col">Modified By</th>
							<th scope="col">Modification Time</th>
							<th scope="col">Status</th>
							<th scope="col">Update</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${user }" var="u">
							<tr>

								<td style="background-color: green">${u.name }</td>
								<td style="background-color: green">${u.userName }</td>
								<td style="background-color: green">${u.password }</td>
								<td style="background-color: green">${u.createdBy }</td>
								<td style="background-color: green">${u.creationTime }</td>
								<td style="background-color: green">${u.modifiedBy }</td>
								<td style="background-color: green">${u.modificationTime }</td>

								<td class="text-center"><c:choose>
										<c:when test="${u.id == 2 }">
											<button class="btn btn-primary">Admin</button>
										</c:when>
										<c:otherwise>
											<c:if test="${u.status == true }">
												<a
													href='<%=request.getContextPath()%>/update_status?id=${u.id }&status=${u.status}'
													class="btn btn-success">Active</a>
											</c:if>
											<c:if test="${u.status == false }">
												<a
													href='<%=request.getContextPath()%>/update_status?id=${u.id }&status=${u.status}'
													class="btn btn-danger">DeActive</a>
											</c:if>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${u.id == 2 }">
											<button class="btn btn-primary">Head</button>
										</c:when>
										<c:otherwise>
											<a href='user/update?id=${u.id }'><i
												class="fa-solid fa-pen-nib text-success"></i></a>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="Register" class="btn btn-success">Add User</a> <a
						href="home" class="btn btn-warning">Home</a>
				</div>

			</div>

		</div>

	</div>


</body>
</html>