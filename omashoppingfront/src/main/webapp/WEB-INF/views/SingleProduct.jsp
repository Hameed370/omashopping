<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url value="/resources/css/" var="css"/>
<s:url value="/resources/js/" var="js"/>
<s:url value="/resources/Images" var="imgs" />
<link href="${css}bootstrap.css" rel="stylesheet" >
<link href="${css}bootstrap-glyphicons.css" rel="stylesheet">
<script type="text/javascript" src="${js}bootstrap.min.js"></script>
<script type="text/javascript" src="${js}modernizr-2.6.2.min.js"></script>
<title>My Landing Page</title>
<script >
footer
{
	
	}
</script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><IMG src="${imgs}/benefits-mobile-access.jpg" alt="Your Logo" height="25px" width="25px"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/oma/">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="/oma/products">Products</a></li>
        <li><a href="#">Headphones</a></li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/oma/Login">Login</a></li>
        
        </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
<table class="table tale-bordered">

<td class="col-sm-6 col-md-6">
<img src="${imgs}/${product.id}.jpg"  />
<%-- ${imgs}/${product.id} +".jpg" --%>
</td>
<td class="col-sm-6 col-md-6">
<table >
<tr height="100px" >
<td width="50%"><B>Product Name:</B></td>
<td allign="center">${product.pname}</td>
</tr>
<tr height="100px">
<td><b>Product Description</b></td>
<td allign="center">${product.description }</td>
</tr>
<tr height="100px">
<td><b>Quantity</b></td>
<td>${product.qty}</td>
</tr>
<tr>
<td allign="center"><button class="btn btn-success">Add To Cart</button></td>
</tr>
</table>
</td>

</table>

</div>
</body>
</html>