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
							<li class="breadcrumb-item"><a href="${root}/task">Task</a></li>
							<li class="breadcrumb-item active" aria-current="page">Update
							</li>
						</ol>
					</nav>
					<h1 class="m-0">Update</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<form action="" method="post">
			<label for="status">Status:</label><br> <input type="number"
				id="status" name="status"><br>
			<br> <input type="submit" value="Submit">
		</form>
	</div>
</body>
