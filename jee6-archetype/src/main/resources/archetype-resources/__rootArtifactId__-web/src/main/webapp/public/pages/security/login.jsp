#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions">
	<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-BR">
<head>
	<title>Login</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link href="${symbol_dollar}{pageContext.request.contextPath}/public/resources/styles/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form method="post" action="j_security_check"><br />
	<table align="center">
		<tr>
			<td><label for="txt_username">Login:</label></td>
			<td><input id="txt_username" type="text" name="j_username" tabindex="1" title="Informe o usuário" /></td>
		</tr>
		<tr>
			<td><label for="txt_password">Senha:</label></td>
			<td><input id="txt_password" type="password" name="j_password" tabindex="2" title="Informe a senha do usuário" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="login" tabindex="3" /></td>
		</tr>
	</table>
	</form>
</body>
</html>
</jsp:root>
