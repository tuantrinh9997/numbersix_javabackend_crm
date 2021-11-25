<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>User Page</title>
<body>
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="#">User</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            list
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Users</h1>
	            </div>
	            
	        </div>
	    </div>
	</div>
	<div class="container page__container">
	
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Role_name</th>
				<th>Description</th>
		</thead>
		<tbody>
			<c:forEach var="users" items="${users}">
				<tr>
					<td>${users.id}</td>
					<td>${users.name}</td>
					<td>${users.email}</td>
					<td>${users.password}</td>
					<td>${users.phone}</td>
					<td>${users.address}</td>
					<td>${users.role.name}</td>
					<td>${users.role.description}</td>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>