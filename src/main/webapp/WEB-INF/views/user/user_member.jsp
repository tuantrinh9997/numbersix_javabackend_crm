<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<title>Leader Page</title>
<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="${root}/home">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">List
							</li>
						</ol>
					</nav>
					<h1 class="m-0">List Member</h1>
				</div>

			</div>
		</div>
	</div>
	<div class="container page__container">

		<form method="post" action="">
			<input type="text" name="keyword" />
			<button type="submit">Search</button>
		</form>
		
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Address</th>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.phone}</td>
						<td>${user.address}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>