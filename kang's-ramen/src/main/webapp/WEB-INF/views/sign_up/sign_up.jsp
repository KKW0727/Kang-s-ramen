<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員の登録</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable= no">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/sign.css">
<script src="js/sign_up.js" defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<div class="sign_container">
		<h1>新規会員の登録</h1>
		<p class="signUp_discription">会員登録のために電話番号を作成してください</p>
		<div class="form_container">
			<h4>電話番号</h4>
			<input type="text" data-input="電話番号" placeholder="010-3401-2679"
				autofocus="autofocus">
			<button type="button" class="submit_btn">続ける</button>
		</div>

		<div class="form_container invisible">
			<h4>メールアドレス</h4>
			<input type="text" data-input="メールアドレス" placeholder="japan@gmail.com"
				autofocus="autofocus">
			<h4>パスワード</h4>
			<input type="password" data-input="パスワード"
				placeholder="パスワードを入力してください">
			<h4>パスワード(確認用)</h4>
			<input type="password" name="repassword" data-input="パスワード"
				placeholder="パスワードを入力してください">
			<h4>生年月日</h4>
			<input type="text" data-input="誕生日" placeholder="yyyy-mm-dd">
			<h4>性別</h4>
			<button type="button" class="gender_btn" name="gender">男性</button>
			<button type="button" class="gender_btn" name="gender">女性</button>
			<button type="button" class="submit_btn">確認画面へ</button>
		</div>
	</div>

</body>

</html>