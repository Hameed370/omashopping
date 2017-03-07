<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<s:url var="css" value="/resources/css" />
<s:url var="js" value="/resources/js" />
<s:url var="img" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="omashop">
<meta name="author" content="Hameed">

<title>Homepage ${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme CSS -->
<link href="${css}/bootstrap-cus-theme.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">


    <!-- jQuery -->
<script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
<script src="${js}/bootstrap.min.js"></script>

<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>


<script type="text/javascript" src="${js}/dataTables.bootstrap.js"></script>


<script type="text/javascript" src="${js}/modernizr-2.6.2.min.js"></script>

</head>

<body>

<div class="wrapper">


    <!-- Navigation -->
 <%@include file="./shared/navbar.jsp" %>
 
 
 <div class="content">
    <!-- Page Content -->
    <!-- If user clicks home then do this -->

   <c:if test="${userClickHome == true}" >
   <%@include file="Home.jsp" %>
   </c:if>
   
<!-- If user clicks LOgin then do this -->
   <c:if test="${userClickLogin == true}" >
   <%@include file="Login.jsp" %>
   </c:if>
   
   
   
   <c:if test="${userClickProduct == true}">
   <%@include file="ProductDetails.jsp" %>
   </c:if>
   
   
   <c:if test="${userClickAdmin == true }" >
   <%@include file="Admin.jsp" %>
   </c:if>
   
   
   
   
   
    <!-- /.container -->
</div>
   

        <!-- Footer -->
       <%@include file="./shared/footer.jsp" %>

    <!-- /.container -->


</div>
</body>

</html>
