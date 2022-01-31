<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable= no">
<link rel="stylesheet" href="${path }/css/reset.css">
<link rel="stylesheet" href="${path }/css/sign.css">
<link rel="stylesheet" href="${path }/css/mypage.css">
<script src="https://kit.fontawesome.com/cda6a13e2d.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path }/js/mypage.js" defer></script>
<title>新規会員の登録</title>
</head>

<body>
	<input type="hidden" class="id" value="${login_user.id }">
	<div class="sign_container">
		<h1>会員情報の変更</h1>
		<section class="form_container">
			<h4>電話番号</h4>
			<article class="updatable_input_box">
				<section class="updatable_input_box_top">
					<input type="text" class="input user_info"
						value="${login_user.user_phone }" data-type="電話番号"
						disabled="disabled"> <i
						class="fas fa-pen-square update_btn"></i>
				</section>
			</article>
			<h4>メールアドレス</h4>
			<input type="text" class="user_email"
				value="${login_user.user_email }" disabled="disabled">
			<h4>パスワード</h4>
			<article class="updatable_input_box">
				<section class="updatable_input_box_top">
					<input type="password" class="input" name="password"
						value="${login_user.user_password }" data-type="パスワード"
						disabled="disabled"> <i
						class="fas fa-pen-square update_btn"></i>
				</section>
			</article>
			<h4>生年月日</h4>
			<article class="updatable_input_box">
				<section class="updatable_input_box_top">
					<input type="text" class="input" name="birthday"
						value="${login_user.user_birthday }" data-type="誕生日"
						disabled="disabled"> <i
						class="fas fa-pen-square update_btn"></i>
				</section>
			</article>
			<h4>性別</h4>
			<input value="${login_user.user_gender }" disabled="disabled">
			<input type="hidden" value="${login_user.create_date }">
			<button class="withdraw_btn">会員退会する</button>
		</section>
	</div>

</body>

</html>