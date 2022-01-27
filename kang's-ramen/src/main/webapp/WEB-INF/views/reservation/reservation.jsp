<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable= no">
<title>kang's ラーメン予約</title>
<script src="https://kit.fontawesome.com/cda6a13e2d.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/reservation.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://checkout.stripe.com/checkout.js"></script>
<script src="js/reservation.js" defer></script>
</head>

<body>

	<input type="hidden" class="id" value="${login_user.id }">
	<input type="hidden" class="game_result" value="${game_result}">
	<div class="loading_img_container invisible">
	<img src="images/reservation/loading_img.gif" class="loading_img" width="150">
	</div>
	<div class="reservation_container">
		<!-- reservation left -->
		<section id="reservation_left">
			<h1 class="reservation_title">kang's ラーメンのかんたん予約</h1>
			<h3 class="reservation_description"></h3>
			<img src="images/reservation/reservation_main_img.png" class="reservation_img" alt="">
		</section>

		<!-- reservation center -->
		<section id="reservation_center">
			<i class="fas fa-calendar-alt"></i> <input type="date" class="select_date"> <i class="fas fa-clock"></i>
			<select class="select_time">
				<option>時間</option>
				<option>9:00</option>
				<option>10:00</option>
				<option>11:00</option>
				<option>12:00</option>
				<option>13:00</option>
				<option>14:00</option>
				<option>15:00</option>
				<option>16:00</option>
				<option>17:00</option>
				<option>18:00</option>
				<option>19:00</option>
			</select>
			<i class="fas fa-user-alt"></i>
			<select class="select_num_adult">
				<option>大人</option>
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
			<i class="fas fa-child"></i>
			<select class="select_num_child">
				<option>子供</option>
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>

			</select>
			<i class="fas fa-chair"></i>
			<select class="select_seat">
				<option>席</option>
				<option>テーブル席</option>
				<option>カウンター席</option>
			</select>
		</section>

		<!-- reservation right -->
		<section id="reservation_right">
			<article class="menu_container">
				<section class="menu">
					<p>辛いラーメン</p>
					<img src="images/reservation/ramen1.png" alt="" width="100" height="100">
					<section class="select_num">
						<i class="fas fa-plus-circle plus_btn"></i> <span class="num_menu">0</span> <i class="fas fa-minus-circle minus_btn"></i>
					</section>
				</section>
				<section class="menu">
					<p>醤油</p>
					<img src="images/reservation/ramen2.png" alt="" width="100" height="100">
					<section class="select_num">
						<i class="fas fa-plus-circle plus_btn"></i> <span class="num_menu">0</span> <i class="fas fa-minus-circle minus_btn"></i>
					</section>
				</section>
			</article>

			<article class="menu_container">
				<section class="menu">
					<p>味噌</p>
					<img src="images/reservation/ramen3.png" alt="" width="100" height="100">
					<section class="select_num">
						<i class="fas fa-plus-circle plus_btn"></i> <span class="num_menu">0</span> <i class="fas fa-minus-circle minus_btn"></i>
					</section>
				</section>
				<section class="menu">
					<p>とんこつ</p>
					<img src="images/reservation/ramen4.png" alt="" width="100" height="100">
					<section class="select_num">
						<i class="fas fa-plus-circle plus_btn"></i> <span class="num_menu">0</span> <i class="fas fa-minus-circle minus_btn"></i>
					</section>
				</section>
			</article>

			<article class="menu_price_container">
				<span>お支払い金額</span> <span class="menu_price">0円</span>
			</article>

			<button class="reservation_btn" type="button">現地で支払う(予約だけ)</button>
			<button class="payment_btn" type="button">今すぐ決済</button>
		</section>
	</div>
</body>

</html>