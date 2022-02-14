<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/cda6a13e2d.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="admin/css/admin.css">
<link rel="stylesheet" href="css/reset.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="admin/js/admin.js" defer></script>
<title>管理者</title>
</head>

<body>
	<div class="main_container">
		<header>
			<ul class="header_menu">
				<li data-type="registered_user">登録会員</li>
				<li data-type="withdrawn_user">退会会員</li>
				<li data-type="registered_reservation">登録予約</li>
				<li data-type="canceled_reservation">キャンセル予約</li>
				<li data-type="sales">売上管理</li>
			</ul>
		</header>
		<!-- 登録会員管理 -->
		<section class="info_container invisible" data-type="registered_user">
			<article class="search">
				<select class="search_select user_search_select">
					<option>すべて</option>
					<option>電話番号</option>
				</select>
				<input class="search_input user_search_input" type="text"> <i class="fas fa-search search_icon user_search_icon"></i>
			</article>
			<ul class="user_info_menu info_menu" data-type="info_menu">
				<li>id</li>
				<li>メールアドレス</li>
				<li>パスワード</li>
				<li>電話番号</li>
				<li>生年月日</li>
				<li>性別</li>
				<li>登録日</li>
			</ul>
			<article class="infos user_infos"></article>

		</section>

		<!-- 退会会員管理 -->
		<section class="info_container invisible" data-type="withdrawn_user">
			<article class="search">
				<select class="search_select user_search_select">
					<option>すべて</option>
					<option>電話番号</option>
				</select>
				<input class="search_input user_search_input" type="text"> <i class="fas fa-search search_icon  user_search_icon"></i>
			</article>
			<ul class="user_info_menu info_menu" data-type="info_menu">
				<li>id</li>
				<li>メールアドレス</li>
				<li>パスワード</li>
				<li>電話番号</li>
				<li>生年月日</li>
				<li>性別</li>
				<li>退会日</li>
			</ul>
			<article class="infos user_infos"></article>

		</section>
		<!-- 登録予約管理 -->
		<section class="info_container invisible" data-type="registered_reservation">
			<article class="search">
				<select class="search_select reservation_search_select">
					<option>すべて</option>
					<option>電話番号</option>
				</select>
				<input class="search_input reservation_search_input" type="text"> <i class="fas fa-search search_icon reservation_search_icon"></i>
			</article>
			<ul class="reservation_info_menu info_menu">
				<li>コード</li>
				<li>日付</li>
				<li>時間</li>
				<li>人数</li>
				<li>座席</li>
				<li>メニュー</li>
				<li>金額</li>
				<li>決済</li>
				<li>登録日</li>

			</ul>

			<ul class="infos reservation_infos"></ul>
		</section>

		<!-- キャンセル予約管理 -->
		<section class="info_container invisible" data-type="canceled_reservation">
			<article class="search">
				<select class="search_select reservation_search_select">
					<option>すべて</option>
					<option>電話番号</option>
				</select>
				<input class="search_input reservation_search_input" type="text"> <i class="fas fa-search search_icon reservation_search_icon"></i>
			</article>
			
			<ul class="reservation_info_menu info_menu">
				<li>コード</li>
				<li>日付</li>
				<li>時間</li>
				<li>人数</li>
				<li>座席</li>
				<li>メニュー</li>
				<li>金額</li>
				<li>決済</li>
				<li>キャンセル</li>
			</ul>
			
			<ul class="infos reservation_infos"></ul>
		</section>

		<!-- 売上管理 -->
		<section class="info_container invisible" data-type="sales">
			<article class="search">
				<input type="date" class="search_date" type="text">
			</article>

			<ul class="sales_info_menu info_menu">
				<li>予約数</li>
				<li>辛いラーメン</li>
				<li>醤油</li>
				<li>味噌</li>
				<li>豚骨</li>
				<li>売上</li>
			</ul>

			<ul class="infos sales_infos"></ul>
		</section>
	</div>
</body>

</html>