<%@include file="/WEB-INF/views/common.jsp"%>

        <spring:url value="/resources/css/style1.css" var="stye1css"/>
<link rel="stylesheet" href="${stye1css}">
        
    </head>
    <body>
        <header>Sign In</header>
    <div class="container for">
 <form class="well">
  <div class="form-group">
    <label for="Name">Email address</label>
    <input type="email" class="form-control" id="Email" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <input type="password" class="form-control" id="Password" placeholder="Password">
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-warning">Submit</button>
     </div>
</form>
        </div>
        <div class="mg">
        <spring:url value="/resources/img/w3.png" var="w3"/>
<img src="${w3}" class="center-block">
        </div>
    </body>
</html>