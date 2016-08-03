<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@include file="/WEB-INF/views/common.jsp"%>

        <spring:url value="/resources/css/regstyle.css" var="regstyecss"/>
<link rel="stylesheet" href="${regstyecss}">
        
</head>
    <body>
        <h1>Register</h1>
        <div class="container rock">
        <form:form modelAttribute="prod"  cssClass="form-horizontal" action="addingPro" method="POST">
         <div class="form-group">
    <label for="Name">Name</label>
    <form:input path="id" type="text" class="form-control" id="Name" placeholder="Enter your name"/>
  </div>
  <div class="form-group">
    <label for="Ph no">Mobile Number</label>
    <form:input path="name" type="text" class="form-control" id="Ph no" placeholder="Enter your number"/>
  </div>
  <div class="form-group">
    <label for="Name">Email address</label>
    <form:input path="mailId"type="email" class="form-control" id="Email" placeholder="Enter your Email-Id"/>
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <form:input path="" type="password" class="form-control" id="Password" placeholder="Password"/>
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-warning">Submit</button>
     </div>
</form:form>
        </div>
    </body>
</html>