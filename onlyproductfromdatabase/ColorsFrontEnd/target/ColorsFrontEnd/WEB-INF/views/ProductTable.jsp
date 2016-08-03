<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Table</title></head>
<spring:url value="/resources/css/bootstrap.css" var="boot"/>
        <link rel="stylesheet" href="${boot}">
<body>
<div class="text-center">
<h2>Products</h2>
</div>
<form:form method="post" action="save.html" modelAttribute="contactForm">
	<table ng-app="admintable" ng-controller="admincontroller">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Stock</th>
		<th>Description</th>
	</tr>
	
	<tr ng-repeat="show in list">
	<td>{{show.pid}}</td>
	<td>{{show.pname}}</td>
	</tr>
</table>	
<br/>

	
</form:form>
</body>
<spring:url value="/resources/js/jquery.js" var="jq"/><script src="${jq}"></script>
<spring:url value="/resources/js/angular.min.js" var="a"/><script src="${a}"></script>
<spring:url value="/resources/js/admincontroller.js" var="aa"/><script src="${aa}"></script>        
</html>