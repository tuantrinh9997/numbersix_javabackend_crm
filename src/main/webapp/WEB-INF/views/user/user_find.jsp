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
							<li class="breadcrumb-item"><a href="${root}/user">User</a></li>
							<li class="breadcrumb-item active" aria-current="page">Find
							</li>
						</ol>
					</nav>
					<h1 class="m-0">Information user</h1>
				</div>

			</div>
		</div>
	</div>
	<div class="container page__container">
		<table class="table">
			<thead>
				<tr>
					<th>Action</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Role_name</th>
					<th>Description</th>
			</thead>
			<tbody>
				<tr>
					<td><a href="${root}/user/delete?id=${user.id}"><i
							class="fas fa-trash"></i> Delete</a> | <a
						href="${root}/user/update?id=${user.id}"><i
							class="fas fa-edit"></i> Update</a> | <a
						href="${root}/user/profile?id=${user.id}"><i
							class=" fas fa-info"></i> Profile</a></td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td>${user.role.name}</td>
					<td>${user.role.description}</td>
			</tbody>
		</table>
	</div>
</body>