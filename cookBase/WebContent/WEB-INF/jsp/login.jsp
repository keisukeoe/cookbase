<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/recipe.css">
<title>cookBase -ログイン-</title>
<style>

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
<form action="/cookBase/Login" method="post">
	<div class="res">ユーザー名<span style="color:red">（必須）</span>：</div>
	<input type="text" name="username" placeholder="例）田中　太郎"><br>
	<div class="res">パスワード<span style="color:red">（必須）</span>：</div>
	<input type ="password" name="pass" ><br>
	<input type="submit" value="ログイン">
</form>
	<div class="btn-box">
		<a href="/cookBase/RecipeSearch" class="btn">レシピ検索</a>
	</div>
</body>
</html>