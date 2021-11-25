<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="shortcut icon" href="${root}/assets/images/favicon.ico" />
		<title><dec:title></dec:title></title>
		<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
		<dec:head></dec:head>
		</head>
	<body class="layout-login">
		<div class="layout-login__overlay"></div>
    	<div class="layout-login__form bg-white" data-perfect-scrollbar>
        <div class="d-flex justify-content-center mt-2 mb-5 navbar-light">
            <a href="index.html" class="navbar-brand" style="min-width: 0">
                <img class="navbar-brand-icon" src="${root}/assets/images/logo.png" width="250" alt="Stack">
            </a>
        </div>

        <dec:body />
        
    	</div>
		
		<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
		
		<dec:getProperty property="page.scripts" />
	</body>
</html>