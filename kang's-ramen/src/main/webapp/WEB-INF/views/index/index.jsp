<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>Kang'sラーメン</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index.css">
<script src="https://kit.fontawesome.com/cda6a13e2d.js" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&family=Oswald:wght@200;300;400;500;600;700&family=Roboto+Mono:wght@100&family=Yuji+Syuku&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="js/index.js" defer></script>
</head>

<body>
	<div class="index_container">
		<input type="hidden" class="login_user" value="${login_user }">
		<!-- header -->
		<header>
			<section class="main_logo">
				<img src="images/index/main_logo.png">
			</section>
		</header>
		<!-- main -->
		<main>
			<!-- main icons -->
			<section class="main_icons">
				<c:choose>
					<c:when test="${empty login_user }">
						<img src="images/index/user_menu1.png" class="main_user_icon" onclick="location.href = 'login'">
						<img src="images/index/user_menu2.png" class="main_user_icon" onclick="location.href = 'registry'">
					</c:when>
					<c:otherwise>
						<img src="images/index/user_menu3.png" class="main_user_icon" onclick="location.href = 'users/${login_user.id}'">
						<img src="images/index/user_menu4.png" class="logout main_user_icon">
					</c:otherwise>
				</c:choose>
				<img src="images/index/user_menu5.png" class="reservation main_user_icon">
				<img src="images/index/user_menu6.png" class="reservation main_user_icon">
				<img src="images/index/sub_menu1.png" class="main_info_icon">
				<img src="images/index/sub_menu2.png" class="main_info_icon" data-type="game_info">
				<img src="images/index/sub_menu3.png" class="main_info_icon" data-type="access">
				<img src="images/index/sub_menu4.png" class="main_info_icon">
				<img src="images/index/menu_icon1.png" class="main_info_icon" data-type="karaiRamen">
				<img src="images/index/menu_icon2.png" class="main_info_icon" data-type="shoyu">
				<img src="images/index/menu_icon4.png" class="main_info_icon" data-type="miso">
				<img src="images/index/menu_icon3.png" class="main_info_icon" data-type="tonkotsu">


			</section>
			<!-- main infos -->
			<section class="main_infos">
				<article class="main_info invisible"></article>
				<article class="main_info game_info invisible" data-type="game_info">
					<section class="teams">
						<article class="my_team team">
							<img class="team_logo" src="images/index/hanshin.png">
							<span class="my_team_score team_score">3</span>
						</article>
						<article class="opponent_team team">
							<span class="opponent_team_score team_score">1</span>
							<img class="team_logo" src="images/index/kyojin.png">
						</article>
					</section>
					<a href="https://hanshintigers.jp/game/schedule/2022/03.html" target="black">詳しくはこちら</a>
					<!-- show update game info button when administrator account -->
					<c:if test="${login_user.user_email eq 'gig2010@naver.com' }">
						<button type="button" class="to_update_game_btn" data-type="update_game">修正</button>
					</c:if>
					<form class="update_game_form invisible">
						<article class="update_game_form_input">
							<p>マイチーム</p>
							<input type="text" value="hanshin">
						</article>
						<article class="update_game_form_input">
							<p>相手チーム</p>
							<input type="text">
						</article>
						<article class="update_game_form_input">
							<p>マイチームスコア</p>
							<input type="text">
						</article>
						<article class="update_game_form_input">
							<p>相手チームスコア</p>
							<input type="text">
						</article>
						<article class="update_game_form_input">
							<p>試合情報url</p>
							<input type="text">
						</article>
						<button class="update_game_btn">修正</button>
					</form>
				</article>
				<article class="main_info invisible" data-type="access">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3241.3739328617157!2d139.70305814035706!3d35.66779361954841!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188ca468112079%3A0xa93b4c85f75d9135!2z5LiA6JitIOWOn-Wuv-W6lw!5e0!3m2!1sja!2skr!4v1640008747334!5m2!1sja!2skr" width="250" height="250" style="border: 0;" allowfullscreen="" loading="lazy"></iframe>
					<p>
						営業時間: 10:00 ~ 19:00<br> 定休日なし<br> 来店予約がおすすめです!!
					</p>
				</article>
				<article class="main_info invisible">連絡先: 010-3401-2679</article>

				<!-- show when click menu icon -->
				<article class="main_info invisible" data-type="karaiRamen">
					<img src="images/index/ramen1.png" class="main_info_menu_img">
					<p>鳥出汁に唐辛子をベースに30数種類の材料を調合し何昼夜も寝かせ熟成させたソースを混ぜます。 そうすることで単なる辛さだけではなく様々な旨味が口の中に広がり、より一層ラーメンが奥深い味になります。</p>
				</article>

				<article class="main_info invisible" data-type="shoyu">
					<img src="images/index/ramen2.png" class="main_info_menu_img">
					<p>鶏肉と野菜を基本とする出汁に魚や牛肉などを入れて味をつけます。 醤油ソースを入れて味を増すので、すっきりとした黒味のスープが特徴です。 醤油ラーメンには、縮れたラーメンを使い、竹の子を漬けて作ったメンマやワケギ、蒲鉾、海苔、調味卵（味玉）、もやしを供えます。 チャーシューの代わりに牛肉を薄く切ったり、辛い唐辛子や中国風のスパイスを入れます。</p>
				</article>

				<article class="main_info invisible" data-type="miso">
					<img src="images/index/ramen3.png" class="main_info_menu_img">
					<p>野菜や肉を中華鍋で炒めたときにダシとタレ（味噌）を入れてスープを作ります。 醤油ラーメンの場合、ダシとタレを1杯ずつ器で混ぜて作りますが味噌ラーメンは中華鍋で調理しながらスープを作ることが特徴です。</p>
				</article>

				<article class="main_info invisible" data-type="tonkotsu">
					<img src="images/index/ramen4.png" class="main_info_menu_img">
					<p>豚骨ラーメンは、名前のとおり豚骨を使用したスープが特徴です。 強火で炊くことで白く濁ったスープを作ることができます。 豚骨の中に含まれているゼラチンが溶けることで、 鮮やかな色とうまみを感じることができるのです。</p>
				</article>
			</section>

		</main>
	</div>
</body>

</html>