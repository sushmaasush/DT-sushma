<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     <%@include file="/WEB-INF/views/common.jsp"%>

        <spring:url value="/resources/css/style.css" var="styecss"/>
<link rel="stylesheet" href="${styecss}">
 <spring:url value="/resources/css/w3.css" var="w3css"/>
<link rel="stylesheet" href="${w3}">
        
    </head>
    <body>
        <div class="hi"> <h1>Colors</h1></div>
        
        <div class="container text-justify ask">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat deserunt maiores perspiciatis quos. Recusandae deserunt earum, inventore nisi repellat, sint placeat reiciendis iste corrupti aliquid magnam, voluptatum, eveniet ad ea.Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat deserunt maiores perspiciatis quos.</p>
        </div>
            
        <div class="button text-center">
            <a href="signin" class="btn btn-danger">Sign In</a>
            <a href="register" class="btn btn-success">Register</a>
            <a href="products" class="btn btn-success">Products</a>
        </div>
      <div>
      <a href="apro">Add Products</a>
            <div class="img" style="max-width:100% height:50vh">
  <!-- <img class="mySlides" src="img/Womens Accessories hof ss16.jpg" style="width:100%"> -->
  <spring:url value="/resources/img/Womens Accessories hof ss16.jpg" var="w3"/>
<img class="mySlides "src="${w3}" class="center-block" style="width:100%">
  <!-- <img class="mySlides" src="img/access.jpg" style="width:100%"> -->
  <spring:url value="/resources/img/access.jpg" var="w2"/>
<img class="mySlides "src="${w2}" class="center-block" style="width:100%" >
 <!--  <img class="mySlides" src="img/ogheaders-accessories.jpg" style="width:100%"> -->
 <spring:url value="/resources/img/ogheaders-accessories.jpg" var="w4"/>
<img class="mySlides "src="${w4}" class="center-block" style="width:100%" >
 <!--  <img class="mySlides" src="img/fwb_baby-accessories_20151026.jpg" style="width:100%"> -->
  <spring:url value="/resources/img/fwb_baby-accessories_20151026.jpg" var="w5"/>
<img class="mySlides "src="${w5}" class="center-block" style="width:100%" >
  <!-- <img class="mySlides" src="img/cos.jpg" style="width:100%"> -->
  <spring:url value="/resources/img/cos.jpg" var="w6"/>
<img class="mySlides "src="${w6}" class="center-block" style="width:100%" >
  
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
        </div>
    </body>
</html>