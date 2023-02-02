<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>
	this is add product

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">FILL THE DETAILS</h1>
				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text" required="required"
							class="form-control" id="name" name="name"
							placeholder="ENTER PRODUCT NAME">
					</div>

					<div class="form-group">
						<label for="description">Product Description</label> <input required="required"
							type="text" class="form-control" id="description"
							name="description" rows="5"
							placeholder="ENTER PRODUCT DESCRIPTION">
					</div>
           <div class="form-group">
       <label for="price">Product Price</label>
       <input type="text" class="form-control" required="required" id="price" name="price" placeholder="ENTER PRODUCT PRICE">
       </div>
       
       <div class="container text-center">
       
       <a href="${pageContext.request.contextPath }/"
         class="btn btn-outline-danger">BACK</a>
         <button type="submit" class="btn btn-primary">ADD</button>
       
       
       </div>
       
       








				</form>









			</div>





		</div>









	</div>
</body>
</html>