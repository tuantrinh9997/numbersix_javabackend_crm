<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<body>
	<div class="container page__container">
		<div class="container page__heading-container">
			<div class="page__heading">
				<div class="d-flex align-items-center">
					<div>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">
									Task</li>
								<li class="breadcrumb-item active" aria-current="page">Add</li>
							</ol>
						</nav>
						<h1 class="m-0">Add Task</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<form action="" method="post">
			<label for="name">Name:</label><br> <input type="text" id="name"
				name="name"><br> <br> <label for="start_date">Start_date:</label><br>
			<input type="date" id="start_date" name="start_date"><br>
			<br> <label for="end_date">End_date:</label><br> <input
				type="date" id="end_date" name="end_date"><br> <br>
			<label for="description">Description:</label><br> <input
				type="text" id="description" name="description"><br> <br>
			<label for="user_id">Assignee:</label><br> <input type="number"
				id="user_id" name="user_id"><br> <br> <input
				type="submit" value="Submit">
		</form>
	</div>
</body>
