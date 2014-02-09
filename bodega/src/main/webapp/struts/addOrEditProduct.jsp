<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:text name="struts.edit.product.title"/></title>
	<link rel="stylesheet" type="text/css" href="<s:url value="/css/bodega.css" />" />
<sj:head />
</head>
<body>
<h3><s:text name="struts.edit.product.title"/></h3>
<div id="edit">
<s:form action="saveProduct">
<a href="<s:url action="allProducts"/>">Products</a>

	<s:hidden key="product.id" />
	<s:textfield key="product.productName" size="80" />
	<s:textfield key="product.productDescription" size="120"/>
	<s:select key="product.productType" list="productTypes" emptyOption="true" listKey="id" listValue="productTypeDescription" />
	<s:textfield key="product.productCountry" size="80"/>
	<s:select key="product.productYear" list="years" emptyOption="true" listKey="id" listValue="year" />
    <s:textfield key="product.productGrape" size="80"/>
    <s:textfield key="product.productPrice" size="10"/>
    <s:textfield key="product.productCeller" size="80"/>
    <s:textfield key="product.productVender" size="80"/>
    <s:textfield key="product.productAlcohol" size="10"/>
    <sj:datepicker value="%{product.productDatePurchased}" id="product.productDatePurchased" name="product.productDatePurchased" displayFormat="dd.mm.yy" label="Product Date Purchased" />
    <sj:datepicker value="%{product.productDateOpened}" id="product.productDateOpened" name="product.productDateOpened" displayFormat="dd.mm.yy" label="Product Date Opened" />
	<s:textarea maxlength="300" key="product.productComments" rows="10" cols="80"/>
	<p/>
	<s:submit action="saveProduct" key="submit.save.product"/>
</s:form>
</div>
</body>

</html>