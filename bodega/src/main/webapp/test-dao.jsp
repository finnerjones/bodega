<%@page import="com.finnerjones.bodega.persistence.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test DAO</title>
</head>
<body>
<%
	
	Product product =  (Product)session.getAttribute("product"); 

%>
<h2>Connection successful!</h2>
The product name is : <%= product.getProductName() %><br/>
The product year is : <%= product.getProductYear() %><br/>
<p/>
<a href="index.jsp">back</a>
</body>
</html>