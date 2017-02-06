<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body style="text-align:center">
	<h1>书籍列表</h1>
	<table width="70%" border="1">
		<c:forEach items="${books}" var="entry">
			<tr>
				<td>名称:${entry.value.name}</td>
				<td>作者:${entry.value.author}</td>
				<td>价格:${entry.value.price}</td>
				<td>描述:${entry.value.description}</td>
				<td>操作:<a href="${pageContext.request.contextPath }/servlet/buy?id=${entry.key}">购买</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>