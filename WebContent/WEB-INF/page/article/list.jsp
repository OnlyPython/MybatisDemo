<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>List Articles</title>
</head>
<body>
<h1>Articles</h1>
<c:forEach items="${articles}" var="item">
	${item.id } -- ${item.title } -- ${item.content }<br/>
</c:forEach>
</body>
</html>