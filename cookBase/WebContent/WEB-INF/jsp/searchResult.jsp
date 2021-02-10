<%--製作途中です --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Recipe"%>
<%@page import="java.util.List"%>

<%
	//リクエストスコープに保存されたレシピ検索情報を取得
	List<Recipe> r = (List<Recipe>)request.getAttribute("recipeList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookBase -検索結果- </title>
</head>
<body>
料理名：<%=  %>
所要時間：<%= r.getTime() %>
材料：<%= r.getItem() %>

<form action="" method="post">
<input type="hidden" value="<%= r.getName() %>" name="rName">
<input type="hidden" value="<%= r.getTime() %>" name="rTime">
<input type="hidden" value="<%= r.getItem() %>" name="rItem">

<input type="image" >
</form>
</body>
</html>