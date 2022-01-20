<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/confirm_reservation.css">
<script src="js/confirm_reservation.js" defer></script>
<script src="https://kit.fontawesome.com/cda6a13e2d.js" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://checkout.stripe.com/checkout.js"></script>
<title>kang'sラーメン予約確認</title>
</head>

<body>
	<div class="confirm_reservation_container">
		<button class="toHome_btn" onclick="location.href ='index'">
			<i class="fas fa-arrow-left"></i>ホームへ
		</button>
		<h1 class="confirm_reservation_title">予約確認</h1>
		<h3>予約件数 ${fn:length(reservationList) }件</h3>
		<c:if test="${fn:length(reservationList) == 0}">
			<h1 class="empty_reservation">
				<img src="images/confirm_reservation_img.png">
			</h1>
		</c:if>
		<!-- reservation info -->
		<section class="confirm_reservations">
			<c:forEach var="reservation" items="${reservationList }">
				<input type="hidden" class="reservation_code" value="${reservation.reservation_code }">
				<input type="hidden" class="payment" value="${reservation.payment }">
				<article class="confirm_reservation">
					<section class="confirm_reservation_items">
						<article class="confirm_reservation_item">
							<i class="fas fa-calendar-alt"></i>
							<p>${reservation.date }</p>
						</article>
						<article class="confirm_reservation_item">
							<i class="fas fa-clock"></i>
							<p>${reservation.time }</p>
						</article>
						<c:if test="${reservation.adult ne 0}">
							<article class="confirm_reservation_item">
								<i class="fas fa-user-alt"></i>
								<p>大人${reservation.adult }名</p>
							</article>
						</c:if>
						<c:if test="${reservation.child ne 0}">
							<article class="confirm_reservation_item">
								<i class="fas fa-child"></i>
								<p>子供${reservation.child }名</p>
							</article>
						</c:if>
						<article class="confirm_reservation_item">
							<i class="fas fa-chair"></i>
							<p>${reservation.seat }</p>
						</article>
						<article class="confirm_reservation_item">
							<i class="fas fa-yen-sign"></i>
							<p class="menu_price">${reservation.price }円</p>
						</article>
					</section>
					<section class="confirm_reservation_menus">
						<c:if test="${reservation.karaiRamen ne 0}">
							<article class="confirm_reservation_menu">
								<p>辛いラーメン</p>
								<img src="images/reservation/ramen1.png">
								<p>${reservation.karaiRamen}</p>
							</article>
						</c:if>
						<c:if test="${reservation.shoyu ne 0}">
							<article class="confirm_reservation_menu">
								<p>醤油</p>
								<img src="images/reservation/ramen2.png">
								<p>${reservation.shoyu}</p>
							</article>
						</c:if>
						<c:if test="${reservation.miso ne 0}">
							<article class="confirm_reservation_menu">
								<p>味噌</p>
								<img src="images/reservation/ramen3.png">
								<p>${reservation.miso}</p>
							</article>
						</c:if>
						<c:if test="${reservation.tonkotsu ne 0}">
							<article class="confirm_reservation_menu">
								<p>とんこつ</p>
								<img src="images/reservation/ramen4.png">
								<p>${reservation.tonkotsu}</p>
							</article>
						</c:if>
					</section>
					<!-- 決済する、決済キャンセル、決済キャンセル、予約キャンセル button  -->
					<section class="confirm_reservation_btns">
						<c:choose>
							<c:when test="${reservation.payment eq '未決済'}">
								<input type="hidden" name="reservation_code" value="${reservation.reservation_code }">
								<input type="hidden" name="payment" value="決済完了">
								<input type="hidden" name="user_email" value="${login_user.user_email }">
								<button type="button" class="payment_btn">決済する</button>
							</c:when>
							<c:otherwise>
								<button type="button" class="payment_btn">決済キャンセル</button>
							</c:otherwise>
						</c:choose>
						<button type="button" class="update_reservation_btn">予約変更</button>
						<button type="button" class="delete_reservation_btn">予約キャンセル</button>
					</section>
				</article>
			</c:forEach>
		</section>
	</div>
</body>

</html>