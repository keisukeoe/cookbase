<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/recipe.css">
<title>cookBase -レシピ検索-</title>
</head>
<body>
<h1>cookBase</h1>

<form action="/cookBase/RecipeSearch" method ="post">
	<div class="text-wrap">
		<input type="text" name="recipe_name" placeholder="例）カレーライス">
	</div>
	<div class="submit-wrap">
		<input type="submit" name="search" value="検索">
	</div>
</form>

<div class="btn-box">
	<a href="/cookBase/RecipePost" class="btn">レシピ投稿</a>
</div>

<div class="btn-box">
	<a href="/cookBase/Login" class="btn">ログイン</a>
</div>

<div class="btn-box">
	<a href="/cookBase/Register" class="btn">ユーザー登録</a>
</div>

</body>
</html>