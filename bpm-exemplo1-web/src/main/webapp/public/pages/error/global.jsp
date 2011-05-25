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
<link href="${pageContext.request.contextPath}/public/resources/styles/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br/>
		Error Page: Global
	<br/>
	
	<c:out value="${pageContext.exception.message}"></c:out>
	<c:out value="${pageContext.errorData}"></c:out>
	
<!--	<c:if test="${pageContext.errorData != null}">-->
<!--		<c:out value="Request URI: ${pageContext.errorData.requestURI}" /><br/>-->
<!--		<c:out value="Status Code: ${pageContext.errorData.statusCode}"/><br/>-->
<!--		<c:out value="Servlet Name: ${pageContext.errorData.servletName}" /><br/>-->
<!--		<c:out value="Message: ${pageContext.errorData.throwable.message}"/><br/>-->
<!--		<c:forEach var="st" items="${pageContext.errorData.throwable.stackTrace}">-->
<!--			<samp>${st}<br/></samp>-->
<!--		</c:forEach>-->
<!--	</c:if>-->
	
	

	</body>
</html>
</jsp:root>
