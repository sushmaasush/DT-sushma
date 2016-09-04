<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/common.jsp"%>
</head>
<body>
<%@include file="/WEB-INF/views/suppliermenu.jsp"%>

<div style="padding: 100px">
	
   
   <div class="container text-center">
   <div class="row">
   <c:forEach var="product" items="${itemList}" varStatus="status">
    <div class="col-md-4">
   <div>
   
      <spring:url value="/resources/img/${product.pid}.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/> 
   <div class="text-center caption"> 
      
      <span>${product.pname}</span><br>
      <span>Rs.${product.pprice}</span><br>
	<a class="btn btn-warning" href="usr/cart/add?id=${product.pid}&nam=${pageContext.request.userPrincipal.name}">AddToCart</a>
	
      </div>
   </div>
   </div>
   </c:forEach> 
   </div></div>
   </div>
                <%-- <tr></tr>
                <tr><td>
                <table>
                    <tr><td> ${product.pid}</td></tr>
                    <tr><td> ${product.pname}</td></tr>
                    <tr><td>Rs.${product.pprice}</td></tr>

                    <img alt="" src="<c:url value="/resources/imgs/${product.pid}.jpg" /> ">
                   <tr><td><a href="usr/cart/add?id=${product.pid}&nam=${pageContext.request.userPrincipal.name}">AddToCart</a></td></tr>
                    <tr><td>----------------------</td></tr>
                  
                  
                  </td>
                </tr> --%>
                
		
	<!-- </table> -->
	</div>
<%-- <div class="container"  ng-app="admintable" ng-controller="admincontroller">
<div class="row">
<div class="col-sm-6 col-md-4 text-center" ng-repeat="show in list"><a href="brief.do?id={{show.pid}}">
<div class="image">
<spring:url value="/resources/img/gold-leaf.jpg"
				var="g" />
<img class="mySlides" src="${g}" class="center-block"
				style="width: 30%">
</div>

<span>Rs.{{show.pprice}}</span><br>
<span>{{show.pname}}</span><br>
<a class="btn btn-warning" href="usr/cart/add?id=${product.pid}&nam=${pageContext.request.userPrincipal.name}">Add to Cart</a>
</div></a></div></div> --%>
</body>
<%-- <%@include file="/WEB-INF/views/includes1.jsp"%>   --%>
<spring:url value="/resources/js/jquery.js" var="jq"/><script src="${jq}"></script>
<spring:url value="/resources/js/angular.min.js" var="a"/><script src="${a}"></script>
<spring:url value="/resources/js/admincontroller.js" var="aa"/><script src="${aa}"></script>        
</html>