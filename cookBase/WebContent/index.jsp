<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 文字が浮かび上がって数秒して検索ページに飛ぶようにする -->
<meta http-equiv="refresh" content="3; URL=http://localhost:8080/cookBase/RecipeSearch">
<link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">
<title>cookBase</title>
<style>
body{
	background-image:url("img/kitchen.jpg");
	background-size:cover;
	background-attachment:fixed;
	background-position:center center;
}
.sub{
	font
}
.center {
	<!-- 親要素 -->
	position:relative;
}
.center h1 {
	color:#663300;
	font-size:6rem;
	font-family: 'Galada', cursive;
	position:absolute;
	top:50%;
	left:50%;
	-weblit-transform:translate(-50%, -60%);
	transform : translate(-50%, -60%);
	text-align:center;
}
.fade {
	animation-name:fadein;
	animation-duration:2s;
	animation-iteration-count:1
}
@keyframes fadein {
	from {
		opacity:0;
		transform:translateY(-50%, -60%);
	}
	to {
		opacity:1;
		transform:translateY(-50%, -60%);
	}
}
</style>
</head>
<body>
<div class="center fade">

<h1>welcome to cookBase</h1>
</div>
</body>
</html>