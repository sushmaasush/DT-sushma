 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@include file="/WEB-INF/views/common.jsp"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <spring:url value="/resources/css/common.css" var="common"/>
<link rel="stylesheet" href="${common}">
        
    </head>
    <body>
        <header>Sign In</header>
    <div class="container for">
    
    
 <form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<!-- <table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
					</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table> -->
			<div class="form-group">
    <label for="user_id">USERNAME</label>
    <input type="text" class="form-control"  name="username"  required/>
  </div>
         
         
         <div class="form-group">
    <label for="Password">PASSWORD</label>
    <input type="password"    class="form-control"  name="password" required/>
    
  </div>
  
  <div class="form-group text-center">
						<input type="submit" value="SignIn" class="btn btn-primary " />
					</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		
        </div>
        <%-- <h1> message ${msg}</h1>
        <c:if test="${msg == true}">
  <div class="alert alert-danger fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Error !</strong>Either User id or Password in incorrect ! Try Again
  </div>
  </c:if> --%>
        <%-- <div class="mg">
        <spring:url value="/resources/img/w3.png" var="w3"/><img src="${w3}" class="center-block">
        </div> --%>
    </body>
</html>