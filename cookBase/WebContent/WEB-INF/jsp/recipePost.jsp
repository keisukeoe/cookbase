<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//リクエストスコープに保存された結果メッセージを取得
	String message = (String)request.getAttribute("message");
	if(message == null){
		message="";
	}

	// リクエストスコープからアップロード済みのファイル名を取得
	String upfile = (String)request.getAttribute("upFile");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/recipe.css">
<title>cookBase -レシピ検索-</title>
<style>

</style>
</head>
<body>
<h1>cookBase</h1>

<form action="/cookBase/RecipePost?action=upload" method="post" enctype="multipart/form-data">
	<div class="element_wrap">
		<input type="file" name="photo_data" alt="料理画像">
	</div>
	<div class="submit-wrap">
		<input type="submit" name="search" value="アップロード">
	</div>

	<div class="uploarded_img">
		<img src="uploaded/<%= upfile %>" alt="uploaded_img">
	</div>


</form>
<form  action="/cookBase/RecipePost?action=toukou" method="post" >
	<div class="text-wrap">
		<input type="text" name="recipe_name" placeholder="例）カレーライス">
	</div>
	<div class="textarea-wrap">
		<textarea name="recipe_data" placeholder="具体的なレシピをお書き下さい（50文字以上500文字以下）"></textarea>
	</div>
	<div class="submit-wrap">
		<input type="submit" name="search" value="投稿">
	</div>
	<input type="hidden" name="fileName" value="<%= upfile  %>">
</form>
<div class="msg">
	<%=message %>
</div>
<div class="btn-box">
	<a href="/cookBase/RecipeSearch" class="btn">レシピ検索</a>
</div>

</body>
</html>