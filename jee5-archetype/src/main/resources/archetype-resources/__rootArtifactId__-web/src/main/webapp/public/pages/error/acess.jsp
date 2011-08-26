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
<title>Access Denied</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="${symbol_dollar}{pageContext.request.contextPath}/public/resources/styles/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="error-top"></div>
	
	<div id="error">
		<span id="erro-title">Error Page: Access Denied</span>
		<span id="erro-detail">Nono nono nono no no no nononon no nonn non onon nonon onono no noonon no nonno no non non on noono n no nonono non onon noonno onn onon nono nn</span>
	</div>

	<div id="error-bottom"></div>

</body>
</html>
</jsp:root>