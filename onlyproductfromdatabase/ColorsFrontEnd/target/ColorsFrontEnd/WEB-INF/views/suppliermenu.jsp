<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
            
            
            
             <nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_SUP')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		</sec:authorize>
    <div class="navbar-header">
      <a class="navbar-brand" href="#">colors</a>
      
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active text-primary"><sec:authorize access="hasRole('ROLE_USER')">
          <a href="cart-table?nam=${pageContext.request.userPrincipal.name}"><span class="glyphicon glyphicon-shopping-cart"></span>  cart</a>
        </sec:authorize> </li>

    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a onClick="javascript:formSubmit();"><span class="glyphicon glyphicon-log-out"></span>  Sign out</a></li>
    </ul>
  </div>
</nav>
<%@include file="/WEB-INF/views/includes1.jsp"%>
   
         


	
