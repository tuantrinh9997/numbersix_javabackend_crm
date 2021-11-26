<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="root" value="${pageContext.request.contextPath }" />
<div class="page__header mb-0">
	<div class="container page__container">
		<div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
			<button class="navbar-toggler navbar-toggler-right"
				data-toggle="collapse" data-target="#navbarsExample03" type="button">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="navbar-collapse collapse" id="navbarsExample03">
				<ul class="nav navbar-nav flex">
					<li class="nav-item"><a class="nav-link active"
						href="home"> Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="home"> Leader test</a></li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown">
							Project </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href='<c:url value="http://localhost:8080/Java14CRM/project-manage" />'> Manage Project </a> <a
								class="dropdown-item" href='<c:url value="http://localhost:8080/Java14CRM/project-creat" />'> Project Create Project </a>
						</div></li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown"> User
					</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href='<c:url value="http://localhost:8080/Java14CRM/user-list" />'> User List </a> <a
								class="dropdown-item" href='<c:url value="http://localhost:8080/Java14CRM/user-creat" />'> Create User </a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">Task</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>