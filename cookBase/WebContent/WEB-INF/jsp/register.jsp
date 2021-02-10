<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, java.util.List" %>
<%
	//リクエストスコープに保存されたエラーメッセージ・サクセスメッセージを取得
	String errorMsg = (String)request.getAttribute("errorMsg");
	String successMsg = (String)request.getAttribute("successMsg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookBase-ユーザー登録-</title>
<link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">
<style>
body{
	background-image:url("img/kitchen.jpg");
	background-size:cover;
	background-attachment:fixed;
	background-position:center center;
}
h1 {
	text-align:center;
	margin:0 auto;
	color:#663300;
	font-size:3rem;
	font-family: 'Galada', cursive;
}
input[type='text']{
  display: block;
  margin: 0 auto;
  width: 100%;
  max-width: 400px;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #663300;
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
}

input[type='password']{
  display: block;
  margin: 0 auto;
  width: 100%;
  max-width: 400px;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #663300;
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
}

input[type='submit']{
  border: none;
  display: block;
  width: 100%;
  max-width: 300px;
  padding: 10px;
  border-radius: 5px;
  background-color: #663300;
  color: #fff;
  font-weight: bold;
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  cursor: pointer;
  margin: 0 auto;
}
.res {
	text-align:center;
	font-weight:bold;
}
.msg-box {
	font-size:20px;
	color:#663300;
	font-weight:bold;
	text-align:center;
}
.btn-box {
	text-align:center;
	margin-bottom:10px
}

.btn {
  display: inline-block;
  padding: 0.5em 1em;
  margin-bottom:10px;
  text-decoration: none;
  background: #f7f7f7;
  border-left: solid 6px #ff7c5c;/*左線*/
  color: #ff7c5c;/*文字色*/
  font-weight: bold;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.29);
}

.btn:active {
  box-shadow: inset 0 0 2px rgba(128, 128, 128, 0.1);
  transform: translateY(2px);
}
</style>

</head>
<body>
<h1>cookBase</h1>
<form action="/cookBase/Register" method="post">
<div class="res">ユーザー名<span style="color:red">（必須）</span>：</div>
<input type="text" name="username" placeholder="例）田中　太郎"><br>
<div class="res">パスワード<span style="color:red">（必須）</span>：</div>
<input type ="password" name="pass" ><br>
<input type="submit" value="登録">
</form>
<div class="msg-box">
	<%if(errorMsg != null){ %>
	<p><%=errorMsg %></p>
	<%}else{%>
	<p><%=successMsg %></p>
	<%} %>
</div>
<div class="btn-box">
	<a href="/cookBase/RecipeSearch" class="btn">レシピ検索</a>
</div>
</body>
</html>