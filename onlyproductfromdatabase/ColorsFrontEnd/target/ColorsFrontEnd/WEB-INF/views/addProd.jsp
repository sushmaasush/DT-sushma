<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<title>Insert title here</title>
 <spring:url value="/resources/css/bootstrap.css" var="boot"/>
        <link rel="stylesheet" href="${boot}">
</head>
<body>


<h1 class="text-center">Add Products</h1>
<br/>
<br/>
<form:form modelAttribute="prod"  cssClass="form-horizontal" action="addingPro" method="POST">

				<div class="form-group">
					<label for="pid" class="col-sm-2 control-label" > Product Id:</label>
					<div class="col-sm-8">
						<form:input path="pid" cssClass="form-control" title="Enter product id" required="true"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"> Name:</label>
					<div class="col-sm-8">
						<form:input path="pname" cssClass="form-control" title="Enter product name" />
					</div>
				</div>
					<div class="form-group">
					<label for="pprice" class="col-sm-2 control-label"> Price:</label>
					<div class="col-sm-8">
						<form:input path="pprice" cssClass="form-control" title="Enter price of the product" />
					</div>
				</div>
				<label for="pstock" class="col-sm-2 control-label"> Stock:</label>
					<div class="col-sm-8">
						<form:input path="pstock" cssClass="form-control" title="Enter price of the product" />
					</div>
				</div>
					<div class="form-group">
					<label for="pdes" class="col-sm-2 control-label"> Description:</label>
					<div class="col-sm-8">
						<form:input path="pdes" cssClass="form-control" title="Enter description of the product" />
					</div>
				</div>
		<div class="form-group text-center">
						<input type="submit" value="SAVE" class="btn btn-primary " />
					</div>

			</form:form>
</body>
</html>