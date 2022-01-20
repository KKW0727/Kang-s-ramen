'use strict'

const reservation_codes = document.querySelectorAll('.reservation_code');
const delete_reservation_btns = document.querySelectorAll('.delete_reservation_btn');
const update_reservation_btns = document.querySelectorAll('.update_reservation_btn');
const payment_btns = document.querySelectorAll('.payment_btn');
const menu_prices = document.querySelectorAll('.menu_price');
const payments = document.querySelectorAll('.payment');

let paymentBtnIndex = 0;

let paymentRequest = {
	stripeToken: '',
	stripeTokenType: '',
	stripeEmail: '',
	price: 0
}

//update payment
function updatePayment() {
	$.ajax({
		type: "put",
		url: "update-payment?reservation_code=" + reservation_codes[paymentBtnIndex].value,
		dataType: "text",
		success: function(data) {
			if (data == 0) {
				alert(`決済に失敗しました。`);
			} else if (data == 1) {
				alert(`決済が完了しました。`);
				payment_btns[paymentBtnIndex].textContent = '決済キャンセル';
			}
		},
		error: function() {

		}
	});
}

//stript handler
var handler = StripeCheckout.configure({
	key: 'pk_test_51K7ZqTJZ9QJfM1QbCiK3uwVmngqko90QG5dxfr5H0K6pye9gxUbdMQiqudGFodMkliZLa77UKvSHMx4i4jdT1Kj000c1FeVr6F',
	image: 'images/reservation/payment_img.png',
	locale: 'ja',
	token: function(token) {
		paymentRequest.stripeToken = token.id,
			paymentRequest.stripeTokenType = token.type,
			paymentRequest.stripeEmail = token.email;
		payment();
	},
});

//load payment modal when click payment button
payment_btns.forEach((payment_btn, payment_btn_index) => {
	payment_btn.addEventListener('click', () => {
		handler.open({
			name: "kang'sラーメン",
			description: 'ラーメン',
			currency: 'jpy',
			amount: menu_prices[payment_btn_index].textContent + '円'
		});
		paymentBtnIndex = payment_btn_index;
		paymentRequest.price = menu_prices[payment_btn_index].textContent;
	});
});

//request payment
function payment() {
	$.ajax({
		type: "post",
		url: "payment",
		data: JSON.stringify(paymentRequest),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data, status) {
			if (status == 'success') {
				updatePayment();
			}

		},
		error: function() {

		}
	});
}

update_reservation_btns.forEach((update_reservation_btn, update_reservation_btn_index) => {
	update_reservation_btn.addEventListener('click', () => {
		if (payments[update_reservation_btn_index].value == '決済完了') {
			alert('決済キャンセル後、変更できます。');
		} else {
			location.href = 'update-reservation?reservation_code=' + reservation_codes[update_reservation_btn_index].value;
		}
	});
});