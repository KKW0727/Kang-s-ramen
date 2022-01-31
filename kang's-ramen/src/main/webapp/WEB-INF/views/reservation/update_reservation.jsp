<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>kang'sラーメン予約変更</title>
<script src="https://kit.fontawesome.com/cda6a13e2d.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${path }/css/reset.css">
<link rel="stylesheet" href="${path }/css/update_reservation.css">
<script src="${path }/js/update_reservation.js" defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<input type="hidden" class="reservation_code" value="${reservationOne.reservation_code }">
	<input type="hidden" class="discount" value="${reservationOne.discount }">
	<div class="update_reservation_container">
		<h1 class="update_reservation_title">予約変更</h1>
		<section id="update_reservation">
		<!-- update reservation left -->
			<article class="update_reservation_left">
				<i class="fas fa-calendar-alt"></i> 
				<input type="date" class="select_date" value="${reservationOne.date }"> 
				
				<i class="fas fa-clock"></i>
				<select class="select_time">
					<option>${reservationOne.time }</option>
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
					<option>${reservationOne.adult }</option>
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
					<option>${reservationOne.child }</option>
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
					<option>${reservationOne.seat }</option>
					<option>テーブル席</option>
					<option>カウンター席</option>
				</select>
			</article>
			
			<!-- update reservation right -->
			<article class="update_reservation_right">
				<section class="menu_container">
					<article class="menu">
						<p>辛いラーメン</p>
						<img src="${path }/images/reservation/ramen1.png" alt="" width="100" height="100">
						<section class="select_num">
							<i class="fas fa-plus-circle plus_btn"></i> 
							<span class="num_menu">${reservationOne.karaiRamen }</span> 
							<i class="fas fa-minus-circle minus_btn"></i>
						</section>
					</article>
					
					<article class="menu">
						<p>醤油</p>
						<img src="${path }/images/reservation/ramen2.png" alt="" width="100" height="100">
						<section class="select_num">
							<i class="fas fa-plus-circle plus_btn"></i> 
							<span class="num_menu">${reservationOne.shoyu }</span> 
							<i class="fas fa-minus-circle minus_btn"></i>
						</section>
					</article>
				</section>
				<!-- menu container -->
				<section class="menu_container">

					<article class="menu">
						<p>味噌</p>
						<img src="${path }/images/reservation/ramen3.png" alt="" width="100" height="100">
						<section class="select_num">
							<i class="fas fa-plus-circle plus_btn"></i> 
							<span class="num_menu">${reservationOne.miso }</span> 
							<i class="fas fa-minus-circle minus_btn"></i>
						</section>
					</article>
					<article class="menu">
						<p>とんこつ</p>
						<img src="${path }/images/reservation/ramen4.png" alt="" width="100" height="100">
						<section class="select_num">
							<i class="fas fa-plus-circle plus_btn"></i> 
							<span class="num_menu">${reservationOne.tonkotsu }</span> 
							<i class="fas fa-minus-circle minus_btn"></i>
						</section>
					</article>
				</section>
				
				<article class="menu_price_container">
						<span>お支払い金額</span> <span class="menu_price">${reservationOne.price }円</span>
					</article>
					
				<button class="submit_btn" type="button">確認画面へ</button>
			</article>
		</section>
	</div>
</body>

</html>