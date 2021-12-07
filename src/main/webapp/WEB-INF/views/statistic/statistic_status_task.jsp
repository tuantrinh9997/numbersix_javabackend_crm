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
							<li class="breadcrumb-item active" aria-current="page">List
							</li>
						</ol>
					</nav>
					<h1 class="m-0">List</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<table class="table">
			<thead>
				<tr>
					<th>Status</th>
					<th>SumOfTask</th>
			</thead>
			<tbody>
				<c:forEach var="statisticStatus" items="${statisticStatus}">
					<tr>
						<td>${statisticStatus.nameTask}</td>
						<td>${statisticStatus.sumOfMember}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>