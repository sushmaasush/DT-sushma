<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@include file="/WEB-INF/views/common.jsp"%>

                
</head>
    <body class="reg">
        <h1 class="h">Register</h1>
        <div class="container rock">
        <c:if test="${message == true}">
  <div class="alert alert-danger fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Error !</strong> Password in incorrect ! Try Again
  </div>
  </c:if> 
  <h6></h6>
       <form:form commandName="userd"  cssClass="form-horizontal" action="addinguser" method="POST">
    <div class="form-group">
    <label for="username">UserName</label>
    <form:input path="username" type="text" required="true" class="form-control" id="Name"/>
  </div>
  <div class="form-group">
    <label for="Ph no">Mobile Number</label>
    <form:input path="mobile_no" maxlength="10" type="number" required="true" class="form-control" id="Ph no" />
  </div>
  <div class="form-group">
    <label for="Address">Address</label>
    <form:input path="address" type="text" required="true" class="form-control" id="address"/>
  </div>
  <div class="form-group">
    <label for="Email">Email address</label>
    <form:input path="mail_id" type="email" required="true" class="form-control" id="Email" />
  </div>
  <div class="form-group">
    <label for="userid">User_id</label>
    <form:input path="userid" type="number" required="true" class="form-control" id="userId" />
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <form:input path="password" type="password" id="pwd" required="true" pattern=".{6,9}" class="form-control" title="password should contain 6 to 9 characters "/>
  </div>
  <div class="form-group">
    <label for="cpwd">Re-Enter Password</label>
    <input type="password" name="cpwd" required class="form-control" />
  </div>
   <div class="text-center">
 <input  class="btn btn-danger" type="submit" value="Submit"/>
     </div>
</form:form> 
 <script>
    /* function myFunction() {
        var pwd = document.getElementById("pwd").value;
        var cpwd = document.getElementById("cpwd").value;
        if (pwd != cpwd) {
            alert("Passwords Do not match");
            document.getElementById("pass1").style.borderColor = "#E34234";
            document.getElementById("pass2").style.borderColor = "#E34234";
        }
        else{
        	alert("Password confirmed");
        }
    } */
</script>

        </div>
    </body>
</html>