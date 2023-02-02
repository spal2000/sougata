<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">

		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">WELCOME TO PRODUCT APP</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">NAME</th>
							<th scope="col">DESCRIPTION</th>
							<th scope="col">PRICE</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="prod">
							<tr>
	                            <th scope="row">${prod.id }</th>
								<td>${prod.name }</td>
								<td>${prod.description }</td>
								<td>${prod.price }</td>
								<td><a href="delete/${prod.id }"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
								<td><a href="update/${prod.id }"><i class="fa fa-pen-nib" aria-hidden="true"></i></a></td>
							</tr>
					
						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">ADD</a>

				</div>
			</div>

		</div>



	</div>
</body>
</html>