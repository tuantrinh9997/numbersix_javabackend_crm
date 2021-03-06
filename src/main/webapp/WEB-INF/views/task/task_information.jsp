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
							<li class="breadcrumb-item active" aria-current="page">Information
							</li>
						</ol>
					</nav>
					<h1 class="m-0">Task information</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Start_date</th>
					<th>End_date</th>
			</thead>
			<tbody>
				<tr>
					<td>${task.name}</td>
					<td>${task.description}</td>
					<td>${task.start_date}</td>
					<td>${task.end_date}</td>
					<td></td>
			</tbody>
		</table>
	</div>
</body>
