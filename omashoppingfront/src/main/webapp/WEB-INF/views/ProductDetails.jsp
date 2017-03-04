<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Product Page</title>
<s:url value="/resources/css/" var="css" />
<s:url value="/resources/js/" var="js" />
<s:url value="/resources/Images" var="imgs" />
<link href="${css}bootstrap.css" rel="stylesheet">
<link href="${css }dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}bootstrap-glyphicons.css" rel="stylesheet">
<script type="text/javascript" src="${js}jquery-3.1.1.js"></script>
<script type="text/javascript" src="${js}bootstrap.min.js"></script>
<script type="text/javascript" src="${js}jquery.dataTables.js"></script>
<script type="text/javascript" src="${js }dataTVables.bootstrap.js"></script>
<script type="text/javascript" src="${js}modernizr-2.6.2.min.js"></script>
<script type="text/javascript" src="${js}mytable.js"></script>

</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><IMG
					src="${imgs }/benefits-mobile-access.jpg" alt="Your Logo"
					height="25px" width="25px"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/oma/Home">Home <span
							class="sr-only">(current)</span></a></li>
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
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

<%-- 	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading">ALL PRODUCTS</div>

		<!-- Table -->
		<table class="table table-bordered">
			<thead>
				<tr>
					<TH class="col-sm-1">Sl No</TH>
					<th class="col-sm-4">Product Name</th>
					<th class="col-sm-1">Price</th>
					<th class="col-sm-1">Image</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Defender Case</td>
					<td>500</td>
					<td><img src="${imgs}/defender_case.jpg" height="50px"
						width="50px" alt="defender_case"></td>
					<td></td>
				</tr>
				<tr>
					<td>2</td>
					<td>TPU Case</td>
					<td>350</td>
					<td><img src="${imgs}/tpu_case.jpg" height="50px" width="50px"
						alt="tpu_case"></td>
					<td></td>
				</tr>
				<tr>
					<td>3</td>
					<td>Samsung Headphone</td>
					<td>250</td>
					<td><img src="${imgs}/samsung_headphone.jpg" height="50px"
						width="50px" alt="samsung_headphone"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
 --%>
 
 
 	<table id="mytable" class="table table-striped">
 	<thead>
 <!-- 	<th>image name</th> -->
 <!-- 	<th>active</th> -->
 	<th>id</th>
 	<th>description</th>
 	<th>PNAME</th>
 	<th>Image</th>
 	<th>Link</th>
 	</thead>
<!-- <tfoot>
 	<tr>image name</tr>
 	<tr>active</tr>
 	<tr>id</tr>
 	<tr>description</tr>
 	<tr>PNAME</tr>
 	<tr>Image</tr>
 	<tr>link</tr>
 	</tfoot> -->
  	</table>
 
 
 </body>
</html>