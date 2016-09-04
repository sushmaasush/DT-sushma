<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/common.jsp"%>

<spring:url value="/resources/css/w3.css" var="w3css" />
<link rel="stylesheet" href="${w3}">

</head>
<body class="index">
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand text-info">Colors</a>
    </div>
    <ul class="nav navbar-nav">
      <!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li> -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      <li><a href="logins"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
    </ul>
  </div>
 <c:if test="${message == true}">
  <div class="alert alert-danger fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
     Register or signin to add product to the cart!! 
  </div>
  </c:if>
</nav>
	<div>
	
		<div class="img" style="max-width: 100% height:356px !important">
			<!-- <img class="mySlides" src="img/Womens Accessories hof ss16.jpg" style="width:100%"> -->
			<spring:url value="/resources/img/Womens Accessories hof ss16.jpg" var="w3" />
			<img class="mySlides " src="${w3}" class="center-block" style="width: 100%">
			<!-- <img class="mySlides" src="img/access.jpg" style="width:100%"> -->
		 <spring:url value="/resources/img/access.jpg" var="w2" />
			<img class="mySlides " src="${w2}" class="center-block" style="width: 100%"> 
			<!--  <img class="mySlides" src="img/ogheaders-accessories.jpg" style="width:100%"> -->
			<%-- <spring:url value="/resources/img/ogheaders-accessories.jpg" var="w4" />
			<img class="mySlides " src="${w4}" class="center-block" style="width: 100%"> --%>
			<!--  <img class="mySlides" src="img/fwb_baby-accessories_20151026.jpg" style="width:100%"> -->
			<spring:url value="/resources/img/fwb_baby-accessories_20151026.jpg" var="w5" />
			<img class="mySlides " src="${w5}" class="center-block" style="width: 100%">
			<!-- <img class="mySlides" src="img/cos.jpg" style="width:100%"> -->
			<spring:url value="/resources/img/cos.jpg" var="w6" />
			<img class="mySlides " src="${w6}" class="center-block" style="width: 100%">

		</div>
       
		<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}
    x[myIndex-1].style.display = "block";
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
<%-- <c:forEach var="product" items="${itemList}" varStatus="status"> --%>
				<%-- <div class="container ind">
 	<div class="row">
 	
				<div class="container">
				<c:forEach var="product" items="${itemList}" varStatus="status">
    <div class="col-sm-4 col-md-3 text-center">
    <img class="img-responsive" alt="Image" src="<c:url value="${imp}/${product.pid}.jpg" /> ">
      <spring:url value="/resources/img/${product.pid}.jpg" var="imgs" /><img class="img-responsive" height="400" width="1000" src="${imgs}"/> 
      
      <div class="text-center"> 
      <span>${product.pname}</span><br>
      <span>Rs.${product.pprice}</span><br>
	<a href="addc">AddToCart</a>
      </div>
    </div>
    </c:forEach>
   </div>
   
   </div>
 
	</div> --%></div>
	<div style="padding: 20px">
	<div class="container text-center">
   <div class="row">
   <c:forEach var="product" items="${itemList}" varStatus="status">
    <div class="col-md-4" style="padding-bottom: 10px">
   <div>
   
      <spring:url value="/resources/img/${product.pid}.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/> 
   <div class="text-center caption"> 
      
      <span>${product.pname}</span><br>
      <span>Rs.${product.pprice}</span><br>
	<a class="btn btn-warning" href="addc">AddToCart</a>
	
      </div>
   </div>
   </div>
   </c:forEach> 
   </div></div>
   </div>
	<%@include file="/WEB-INF/views/includes1.jsp"%>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>