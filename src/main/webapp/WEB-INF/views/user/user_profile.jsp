<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    


<body>
<h1>Name: ${user.name}</h1>
<h1>Emai: ${user.email}</h1>
<h1>Password: ${user.password}</h1>
<h1>Phone: ${user.phone}</h1>
<h1>Address: ${user.address}</h1>
<h1>Chuc vu: ${user.role.name}</h1>
<h1>Description: ${user.role.description}</h1>
</body>
