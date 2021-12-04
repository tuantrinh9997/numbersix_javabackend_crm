<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="session" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="shortcut icon" href='<c:url value="/assets/images/favicon.ico"></c:url>' />
		<title>${role} Page</title>
		<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
		<dec:head></dec:head>
		</head>
	<body class="layout-fixed">
		<div class="preloader"></div>
    	<!-- Header Layout -->
    	<div class="mdk-header-layout js-mdk-header-layout">
    	<jsp:include page="/WEB-INF/views/layout/topbar.jsp"></jsp:include>
    	
    		<div class="mdk-header-layout__content page">
    			<jsp:include page="/WEB-INF/views/layout/navbar_${role}.jsp"></jsp:include>
				<dec:body></dec:body>
  			</div>
  		</div>
		
		<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
		<dec:getProperty property="page.scripts"></dec:getProperty>
	</body>
</html>
