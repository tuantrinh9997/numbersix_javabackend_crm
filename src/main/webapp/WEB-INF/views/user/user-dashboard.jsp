<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
</head>
<body>
	<h1>User list</h1>
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
</body>
</html>