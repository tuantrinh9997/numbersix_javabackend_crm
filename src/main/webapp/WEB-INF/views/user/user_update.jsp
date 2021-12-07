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
							<li class="breadcrumb-item active" aria-current="page">Update
							</li>
						</ol>
					</nav>
					<h1 class="m-0">Update user</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<form action="" method="post">
			<label for="email">Email:</label><br> <input type="text"
				id="email" name="email"><br>
			<br> <label for="password">Password:</label><br> <input
				type="text" id="password" name="password"><br>
			<br> <label for="fullname">Fullname:</label><br> <input
				type="text" id="fullname" name="fullname"><br>
			<br> <label for="phone">Phone:</label><br> <input
				type="text" id="phone" name="phone"><br>
			<br> <label for="role">Role:</label><br> <input
				type="number" id="role" name="role"><br>
			<br> <label for="address">Address:</label><br> <input
				type="text" id="address" name="address"><br>
			<br> <input type="submit" value="Update">
		</form>
	</div>
</body>
