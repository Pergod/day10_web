<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script type="text/javascript">
	function deleteItem(id){
		var b=window.confirm("确定删除?");
		if(b){
			window.location.href="${pageContext.request.contextPath}/servlet/deleteItem?id="+id;
		}
	}
	
	function clearAll(){
		var b=window.confirm("确定清空?");
		if(b){
			window.location.href="${pageContext.request.contextPath}/servlet/clearAll";
		}
	}
	
	function changeQuantity(input,id,oldValue){
		var quantity=input.value;
		
		//判断是否是数字
		if(isNaN(quantity)){
			alert("请输入数字");
			input.value=oldValue;
			return ;
		}
		//判断是否是正整数（上步可省略)
		if(quantity<0 || quantity!=parseInt(quantity)){
			alert("请输入正整数");
			input.value=oldValue;
			return ;
		}
		
		var b=window.confirm("确定修改?");
		if(b){
			window.location.href="${pageContext.request.contextPath}/servlet/changeItemQuantity?id="+id+"&quantity="+quantity;
		}
	}
</script>
</head>
<body style="text-align:center">
	<h1>书籍列表</h1>
	<c:if test="${empty(cart.map)}">
		购物车为空
	</c:if>
	<c:if test="${!empty(cart.map)}">
		<table width="70%" border="1">
			<c:forEach items="${cart.map}" var="entry">
				<tr>
					<td>名称:${entry.value.book.name}</td>
					<td>作者:${entry.value.book.author}</td>
					<td>单价:${entry.value.book.price}</td>
					<td>数量:<input type="text" name="quantity" value="${entry.value.quantity}" style="width:35px" onchange="changeQuantity(this,${entry.key },${entry.value.quantity})"></input></td>
					<td>小计:${entry.value.price}</td>
					<td>操作:<a href="javascript:void(0)" onclick="deleteItem(${entry.key})">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">总计</td>
				<td colspan="2">${cart.price }</td>
				<td colspan="1"><a href="javascript:void(0)" onclick="clearAll()">清空购物车</a></td>
			</tr>
		</table>
	</c:if>
</body>
</html>