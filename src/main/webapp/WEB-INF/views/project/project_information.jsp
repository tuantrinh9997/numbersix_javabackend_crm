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
							<li class="breadcrumb-item"><a href="${root}/project">Project</a></li>
							<li class="breadcrumb-item active" aria-current="page">Information</li>
						</ol>
					</nav>
					<h1 class="m-0">Information project</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<h1>Name:${project.name}</h1>
		<h1>Start_date:${project.start_date}</h1>
		<h1>End_date:${project.end_date}</h1>
		<h1>Description:${project.description}</h1>
		<h1>Name_creat:${project.user.name}</h1>
	</div>
</body>
