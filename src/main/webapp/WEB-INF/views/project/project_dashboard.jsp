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
								
							</ol>
						</nav>
						<h1 class="m-0">Project</h1>
					</div>
				</div>
			</div>
		</div>

		<div class="container page__container">

			<a href="${root}/project/add"><i class="fas fa-plus"></i> Add project</a><br>
			<table class="table">
				<thead>
					<tr>
						<th>Action</th>
						<th>Name</th>
						<th>Description</th>
						<th>Start_date</th>
						<th>End_date</th>
						<th>User_name</th>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<tr>
							<td>
								<a href="${root}/project/delete?id=${project.id}">
									<i class="fas fa-trash"></i> Delete</a> | 
								<a href="${root}/project/update?id=${project.id}">
									<i class="fas fa-edit"></i> Update</a> | 
								<a href="${root}/project/information?id=${project.id}">
									<i class=" fas fa-info"></i> Information</a>
							</td>
							<td>${project.name}</td>
							<td>${project.description}</td>
							<td>${project.start_date}</td>
							<td>${project.end_date}</td>
							<td>${project.user.name}</td>
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