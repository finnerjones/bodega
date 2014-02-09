<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><s:text name="struts.index.title"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<s:url value="/css/bodega.css" />" />
</head>
<body>

<div id="banner">
<table>
	<tbody>
		<tr class="logo">
			<td><img src="<s:url value="/images/wine-dude.jpg"/>" /></td>
			<td><s:text name="struts.index.title"/></td>
		</tr>
	</tbody>
</table>
</div>

<div id="addProduct">
<s:form action="addOrEditProduct">
	<s:submit src="<s:url value='/images/create.jpg'/>" key="submit.add.product" />
</s:form>
</div>

<div id="list">
<table class="products">
	<tbody>
		<tr class="list-header">
			<th><s:text name="product.productName"/></th>
			<th><s:text name="product.productType"/></th>
			<th><s:text name="product.productDescription"/></th>
			<th><s:text name="product.productYear"/></th>
			<th><s:text name="product.productCountry"/></th>
			<th><s:text name="product.productGrape"/></th>
			<th><s:text name="product.productPrice"/></th>
			<th><s:text name="product.productCeller"/></th>
			<th><s:text name="product.productVender"/></th>
			<th><s:text name="product.productAlcohol"/></th>
			<th><s:text name="product.productDatePurchased"/></th>
			<th><s:text name="product.productDateOpened"/></th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		<s:iterator status="rowNum" value="products" >
		<tr class="${rowNum.index % 2 == 0 ? 'odd' : 'even'} }">
			<td><s:property value="productName"/></td>
			<td><s:property value="productType"/></td>
			<td><s:property value="productDescription"/></td>
			<td><s:property value="productYear"/></td>
			<td><s:property value="productCountry"/></td>
			<td><s:property value="productGrape"/></td>
			<td><s:property value="productPrice"/></td>
			<td><s:property value="productCeller"/></td>
			<td><s:property value="productVender"/></td>
			<td><s:property value="productAlcohol"/></td>
			<td><s:property value="productDatePurchased"/></td>
			<td><s:property value="productDateOpened"/></td>
			<td>
				<a href="<s:url action="deleteProduct"><s:param  name="product.id" value="%{id}"></s:param></s:url>"><img alt="delete" src="<s:url value="/images/delete.jpg"/>" /></a>
			</td>
			<td>
				<a href="<s:url action="addOrEditProduct"><s:param  name="product.id" value="%{id}"></s:param></s:url>"><img alt="add" src="<s:url value="/images/edit.jpg"/>" /></a>
			</td>
		</tr>
		</s:iterator>
		<tr>
		</tr>
	</tbody>
</table>
</div>
</body>
</html>