<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Table</title></head>
<spring:url value="/resources/css/bootstrap.css" var="boot"/>
        <link rel="stylesheet" href="${boot}">
<body>
<%@include file="/WEB-INF/views/suppliermenu.jsp"%>
<div class="text-center">
<h2>Users</h2>
</div>
<div class="container">
<form class="form-group">
</form>
	<table class="table table-bordered table-striped">
	<tr>
		<th>User_id</th>
		<th>Mail_id</th>
		<th>Mobile_number</th>
		<th>Role</th>
		<th>Address</th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="cart" items="${list}" varStatus="status">
	<tr>
	<td>${cart.userid}</td>
	<td>${cart.mail_id}</td>
	<td>${cart.mobile_no}</td>
	<td>${cart.urole}</td>
	<td>${cart.address}</td>
	<th><a class="btn btn-primary" href="cpdelete?id=${pageContext.request.userPrincipal.name}&pid=${cart.userid}">Delete</a></th>
	</tr>
	</c:forEach>
</table>	
<br/>
</div>
	

</body>
<spring:url value="/resources/js/jquery.js" var="jq"/><script src="${jq}"></script>
<spring:url value="/resources/js/angular.min.js" var="a"/><script src="${a}"></script>       
</html>