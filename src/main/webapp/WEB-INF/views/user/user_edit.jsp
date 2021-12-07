<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />


<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="${root}/home">User</a></li>
							<li class="breadcrumb-item active" aria-current="page">Edit
							</li>
						</ol>
					</nav>
					<h1 class="m-0">Edit Account</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<form action="" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="email">Email</label> <input type="text"
						class="form-control" id="email" placeholder="Email" name="email">
				</div>
				<div class="form-group col-md-6">
					<label for="fullname">Fullname</label> <input type="text"
						class="form-control" id="fullname" placeholder="Nguyen Van A"
						name="fullname">
				</div>
				<div class="form-group col-md-6">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password">
				</div>
			</div>
			<div class="form-group">
				<label for="address">Address</label> <input type="text"
					class="form-control" id="address" placeholder="Address"
					name="address">
			</div>
			<div class="form-group">
				<label for="inputAddress2">Phone</label> <input type="text"
					class="form-control" id="inputAddress2" placeholder="000....."
					name="phone">
			</div>

			<input type="submit" class="btn btn-primary" value="Save">
		</form>
	</div>
</body>
