#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions">
	<jsp:directive.page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-BR">
<head>
<title>Global Error</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="${symbol_dollar}{pageContext.request.contextPath}/public/resources/styles/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br/>
		Error Page: Global
	<br/>
	
	<c:out value="${symbol_dollar}{pageContext.exception.message}"></c:out>
	<c:out value="${symbol_dollar}{pageContext.errorData}"></c:out>
	
<!--	<c:if test="${symbol_dollar}{pageContext.errorData != null}">-->
<!--		<c:out value="Request URI: ${symbol_dollar}{pageContext.errorData.requestURI}" /><br/>-->
<!--		<c:out value="Status Code: ${symbol_dollar}{pageContext.errorData.statusCode}"/><br/>-->
<!--		<c:out value="Servlet Name: ${symbol_dollar}{pageContext.errorData.servletName}" /><br/>-->
<!--		<c:out value="Message: ${symbol_dollar}{pageContext.errorData.throwable.message}"/><br/>-->
<!--		<c:forEach var="st" items="${symbol_dollar}{pageContext.errorData.throwable.stackTrace}">-->
<!--			<samp>${symbol_dollar}{st}<br/></samp>-->
<!--		</c:forEach>-->
<!--	</c:if>-->
	
	

	</body>
</html>
</jsp:root>
