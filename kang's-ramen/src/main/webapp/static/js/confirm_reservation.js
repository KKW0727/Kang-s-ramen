'use strict'

const reservation_codes = document.querySelectorAll('.reservation_code');
const delete_reservation_btns = document.querySelectorAll('.delete_reservation_btn');
const update_reservation_btns = document.querySelectorAll('.update_reservation_btn');
const payment_btns = document.querySelectorAll('.payment_btn');
const menu_prices = document.querySelectorAll('.menu_price');
const payments = document.querySelectorAll('.payment');
const id = document.querySelector('.id');
const payment_keys = document.querySelectorAll('.payment_key');

let paymentInfo = {
	id: id.value,
	reservation_code: 0,
	payment_key: '',
	stripeToken: '',
	stripeTokenType: '',
	stripeEmail: '',
	price: 0
}

//stript handler
var handler = StripeCheckout.configure({
	key: 'pk_test_51K7ZqTJZ9QJfM1QbCiK3uwVmngqko90QG5dxfr5H0K6pye9gxUbdMQiqudGFodMkliZLa77UKvSHMx4i4jdT1Kj000c1FeVr6F',
	image: 'images/reservation/payment_img.png',
	locale: 'ja',
	token: function(token) {
		paymentInfo.stripeToken = token.id;
		paymentInfo.stripeTokenType = token.type,
			paymentInfo.stripeEmail = token.email;
		payment();
	},
});

//load payment modal when click payment button
payment_btns.forEach((payment_btn, payment_btn_index) => {
	payment_btn.addEventListener('click', (e) => {
		paymentInfo.reservation_code = reservation_codes[payment_btn_index].value;
		if (payment_keys[payment_btn_index].value != '') {
			if (confirm('本当に決済をキャンセルしますか?')) {
				paymentInfo.payment_key = payment_keys[payment_btn_index].value;
				refund();
			}
			return;
		}
		handler.open({
			name: "kang'sラーメン",
			description: 'ラーメン',
			currency: 'jpy',
			amount: menu_prices[payment_btn_index].textContent + '円'
		});
		paymentInfo.price = menu_prices[payment_btn_index].textContent;

	});
});

//cancel payment
function refund(refundType, btnIndex) {
	$.ajax({
		type: "post",
		url: "refund",
		data: JSON.stringify(paymentInfo),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			if (data == 1) {
				if (refundType == '決済') {
					deleteReservation(refundType, reservation_codes[btnIndex].value);
				}else {
				alert('決済をキャンセルしました。');
				location.replace('reservations');
				}				
			} else {
				alert('決済キャンセルに失敗しました。');
				location.replace('error');
			}
		},
		error: function() {

		}

	})
}


//request payment
function payment() {
	$.ajax({
		type: "post",
		url: "payment",
		data: JSON.stringify(paymentInfo),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			if (data == 1) {
				alert('決済を完了しました。');
				location.replace('reservations');
			} else {
				alert('決済に失敗しました。');
				location.replace('error');
			}

		},
		error: function() {

		}
	});
}

update_reservation_btns.forEach((update_reservation_btn, update_reservation_btn_index) => {
	update_reservation_btn.addEventListener('click', () => {
		if (payment_keys[update_reservation_btn_index].value != '') {
			alert('予約変更を利用するには、決済キャンセルが必要です。');
			return;
		}
		location.href = 'reservations/' + reservation_codes[update_reservation_btn_index].value;
	});

});

//click delete reservation button
delete_reservation_btns.forEach((delete_reservation_btn, delete_reservation_btn_index) => {
	delete_reservation_btn.addEventListener('click', () => {
		if (payment_keys[delete_reservation_btn_index].value != '') {
			if (confirm('本当に予約、決済をキャンセルしますか?')) {
				paymentInfo.reservation_code = reservation_codes[delete_reservation_btn_index].value;
				paymentInfo.payment_key = payment_keys[delete_reservation_btn_index].value;
				refund('決済', delete_reservation_btn_index);
			}
			return;
		}
		if (confirm('本当に予約をキャンセルしますか?')) {
			deleteReservation('予約',reservation_codes[delete_reservation_btn_index].value);
		}
	});
});

//delete reservation
function deleteReservation(refundType, reservation_code) {
	$.ajax({
		type: "delete",
		url: "reservations/" + reservation_code,
		dataType: "text",
		success: function(data) {
			if (data == 1) {
				if (refundType == '決済') {
					alert('予約と決済をキャンセルしました');
				} else {
					alert('予約をキャンセルしました');
				}
				location.replace('reservations');
			} else {
				alert('予約キャンセルに失敗しました');
				location.replace('error');
			}
		},
		error: function() {

		}

	});
}