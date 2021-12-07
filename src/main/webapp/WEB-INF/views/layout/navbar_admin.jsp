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
					<li class="nav-item"><a class="nav-link active" href="${root}/home"> Home</a></li>
						
					<li class="nav-item"><a class="nav-link active" href="${root}/user"> User</a></li>
					
					<li class="nav-item"><a class="nav-link active" href="${root}/project"> Project</a></li>
					
					<li class="nav-item"><a class="nav-link active" href="${root}/task"> Task</a></li>
					
					<li class="nav-item"><a class="nav-link active" href="${root}/statistic"> Statistic</a></li>
					
				</ul>
			</div>
		</div>
	</div>
</div>