<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="struts.index.title"/></title>
</head>
<body>
<h3><s:text name="struts.index.h3" /></h3>

<s:url id="localeEN" namespace="/" action="locale" >
   <s:param name="request_locale" >en</s:param>
</s:url>
<s:url id="localeES" namespace="/" action="locale" >
   <s:param name="request_locale" >es</s:param>
</s:url>

<s:a href="%{localeEN}" >English</s:a>
<s:a href="%{localeES}" >Español</s:a>

<s:form action="allProducts">
<s:text name="struts.index.line1"/>	  
   	  <s:submit  key="struts.index.submit" />
   	  
</s:form>


</body>
</html>