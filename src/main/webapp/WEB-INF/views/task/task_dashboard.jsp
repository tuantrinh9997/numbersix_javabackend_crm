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
									Project</li>
								<li class="breadcrumb-item active" aria-current="page">
									Project Creat Project</li>
							</ol>
						</nav>
						<h1 class="m-0">Project Creat Project</h1>
					</div>
					<div class="ml-auto">
						<a href="" class="btn btn-light"><i
							class="material-icons icon-16pt text-muted mr-1">settings</i>
							Settings</a>
					</div>
				</div>
			</div>
		</div>

		<div class="container page__container">

			<a href="${root}/task/add"><i class="fas fa-plus"></i> Add task</a><br>
			<table class="table">
				<thead>
					<tr>
						<th>Action</th>
						<th>Name</th>
						<th>Description</th>
						<th>Start_date</th>
						<th>End_date</th>
						<th>Assignee</th>
						<th>Project</th>
						<th>Status</th>
				</thead>
				<tbody>
					<c:forEach var="task" items="${tasks}">
						<tr>
							<td>
								<a href="${root}/task/delete?id=${task.id}">
									<i class="fas fa-trash"></i> Delete</a> | 
								<a href="${root}/task/update?id=${task.id}">
									<i class="fas fa-edit"></i> Update</a> | 
								<a href="${root}/task/information?id=${task.id}">
									<i class=" fas fa-info"></i> Information</a>
							</td>
							<td>${task.name}</td>
							<td>${task.description}</td>
							<td>${task.start_date}</td>
							<td>${task.end_date}</td>
							<td>${task.assignee.name}</td>
							<td>${task.project.name}</td>
							<td>${task.status.name}</td>
							<td></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<content tag="scripts"> <!-- Chart.js --> <script
		src='<c:url value="assets/vendor/Chart.min.js" />'></script> <!-- App Charts JS -->
	<script src='<c:url value="assets/js/chartjs-rounded-bar.js" />'></script>
	<script src='<c:url value="assets/js/charts.js" />'></script> <!-- Chart Samples -->
	<script src='<c:url value="assets/js/page.dashboard.js" />'></script> </content>
</body>