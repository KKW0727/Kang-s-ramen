<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ログイン</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable= no">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/sign.css">
<script src="js/sign_in.js" defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<div class="sign_container">
		<h1>ログイン</h1>
		<p class="signUp_discription">ご登録のメールアドレスとパスワードをご入力ください。</p>
		<div class="form_container">
			<h4>メールアドレス</h4>
			<input type="text" name="email" data-input="メールアドレス"
				placeholder="japan@gmail.com">
			<h4>パスワード</h4>
			<input type="password" name="password" data-input="パスワード"
				placeholder="パスワードを入力してください">
			<button class="submit_btn" type="button">確認画面へ</button>
		</div>
	</div>
</body>

</html>