const plus_icons = document.querySelectorAll('.plus_btn');
const minus_icons = document.querySelectorAll('.minus_btn');
const num_menus = document.querySelectorAll('.num_menu');
const reservation_btn = document.querySelector('.reservation_btn');
const select_num_adult = document.querySelector('.select_num_adult');
const select_num_child = document.querySelector('.select_num_child');
const select_date = document.querySelector('.select_date');
const select_time = document.querySelector('.select_time');
const select_seat = document.querySelector('.select_seat');
const id = document.querySelector('.id');
const game_result = document.querySelector('.game_result');
const reservation_description = document.querySelector('.reservation_description');
const payment_btn = document.querySelector('.payment_btn');
const menu_price = document.querySelector('.menu_price');
const loading_img_container = document.querySelector('.loading_img_container');
const my_team_score = document.querySelector('.my_team_score');
const opponent_team_score = document.querySelector('.opponent_team_score');

let child = 0;
let adult = 0;
let sum_menu = 0;

let reservationInfo = {
	id: id.value,
	date: '',
	time: '',
	adult: 0,
	child: 0,
	seat: '',
	karaiRamen: 0,
	shoyu: 0,
	miso: 0,
	tonkotsu: 0,
	discount: '割引なし',
	price: 0,
}

let paymentInfo = {
	id: id.value,
	reservation_code: 0,
	payment_key: '',
	stripeToken: '',
	stripeTokenType: '',
	stripeEmail: '',
	price: 0
}

//when load reservation page show discount message
if (my_team_score.value > opponent_team_score.value) {
	reservation_description.textContent = '昨日阪神タイガーズ勝利!　すべてのメニューが2000円割引です';
} else {
	reservation_description.textContent = '本日は割引がありません。';
}

//click menu plus icon
plus_icons.forEach((plusIcon, plusIconIndex) => {
	plusIcon.addEventListener('click', () => {
		countMenu(plusIconIndex, 0);
	});
});

//click menu minus icon
minus_icons.forEach((minusIcon, minusIconIndex) => {
	minusIcon.addEventListener('click', () => {
		countMenu(minusIconIndex, 1);
	});
});

//click reservation button
reservation_btn.addEventListener('click', () => {
	if (checkInputService()) {
		if (confirm('このまま予約を確定してもよろしいですか？')) {
			reservation('予約');
		}
	}
});


//check input
function checkInputService() {
	if (select_num_adult.value == '大人') {
		adult = 0;
	} else {
		adult = select_num_adult.value;
	}
	if (select_num_child.value == '子供') {
		child = 0;
	} else {
		child = select_num_child.value;
	}

	let sum_person = parseInt(adult) + parseInt(child);

	const now = new Date();
	const input_date = new Date(select_date.value);
	if (select_date.value == 0) {
		alert('日にちを選択してください');
	} else if (now.getTime() > input_date.getTime()) {
		alert('今日以降の日にちを選択してください ');
	} else if (select_time.value == '時間') {
		alert('時間を選択してください');
	} else if (sum_person == 0) {
		alert('人数を選択してください');
	} else if (select_seat.value == '席') {
		alert('座席を選択してください');
	} else if (sum_person != sum_menu) {
		alert('人数とメニューの数が一致しません');
	} else {
		reservationInfo.date = select_date.value;
		reservationInfo.time = select_time.value;
		reservationInfo.adult = adult;
		reservationInfo.child = child;
		reservationInfo.seat = select_seat.value;
		reservationInfo.karaiRamen = num_menus[0].textContent;
		reservationInfo.shoyu = num_menus[1].textContent;
		reservationInfo.miso = num_menus[2].textContent;
		reservationInfo.tonkotsu = num_menus[3].textContent;
		reservationInfo.price = calcMenuPrice(sum_menu);
		if (my_team_score.value > opponent_team_score.value) {
			reservationInfo.discount = '割引あり'
		}
		return true;
	}
	return false;
}

//menu price service 
function calcMenuPrice(sum_menu) {
	let price = 0;
	if (my_team_score.value > opponent_team_score.value) {
		price = 500 * sum_menu;

	} else {
		price = 700 * sum_menu;
	}
	return price;
}

//menu amount service
function countMenu(iconIndex, countIndex) {
	let num_menu = num_menus[iconIndex].textContent;
	sum_menu = parseInt(num_menus[0].textContent) + parseInt(num_menus[1].textContent)
		+ parseInt(num_menus[2].textContent) + parseInt(num_menus[3].textContent);
	//plus
	if (countIndex == 0) {
		++sum_menu;
		num_menus[iconIndex].textContent = ++num_menu;
		//minus
	} else if (countIndex == 1) {
		if (num_menu <= 0) {
			return;
		}
		--sum_menu;
		num_menus[iconIndex].textContent = --num_menu;
	}
	menu_price.textContent = calcMenuPrice(sum_menu) + '円';
}

//reservation Insert
function reservation(msgType) {
	$.ajax({
		type: "post",
		url: "reservations",
		data: JSON.stringify(reservationInfo),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {

			if (data == 0) {
				alert(`${msgType}に失敗しました。`);
				if (msgType == '決済') {
					location.replace('error');
				}
			} else {
				if (msgType == '決済') {
					paymentInfo.reservation_code = data;
					payment();
				} else {
					alert(`${msgType}が完了しました。`);
					location.replace('reservations');
				}
			}
		},
		error: function() {

		}
	});
}

var handler = StripeCheckout.configure({
	key: 'pk_test_51K7ZqTJZ9QJfM1QbCiK3uwVmngqko90QG5dxfr5H0K6pye9gxUbdMQiqudGFodMkliZLa77UKvSHMx4i4jdT1Kj000c1FeVr6F',
	image: 'images/reservation/payment_img.png',
	locale: 'ja',
	token: function(token) {
		paymentInfo.stripeToken = token.id;
		paymentInfo.stripeTokenType = token.type;
		paymentInfo.stripeEmail = token.email;
		paymentInfo.price = reservationInfo.price;
		reservation('決済');
	},
});

//click payment button
payment_btn.addEventListener('click', () => {
	if (checkInputService()) {
		handler.open({
			name: "kang'sラーメン",
			description: '',
			currency: 'jpy',
			amount: reservationInfo.price + '円',
		});

	}
});


//request payment
function payment() {
	$.ajax({
		type: "post",
		url: "payment",
		data: JSON.stringify(paymentInfo),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		beforeSend: function() {
			loading_img_container.classList.remove('invisible');
		},
		success: function(data) {
			if (data == 1) {
				alert('決済が完了しました。');
				location.replace('reservations');
			} else {
				deleteReservation();
			}

		},
		error: function() {

		}
	});
}

//delete reservation
function deleteReservation() {
	$.ajax({
		type: "delete",
		url: "reservations/" + paymentInfo.reservation_code,
		dataType: "text",
		success: function(data) {
			if (data == 1) {
				alert('決済に失敗しました。');
			} else {
				alert('決済に失敗しました。');
			}
			location.replace('error');
		},
		error: function() {

		}

	});
}

//show message when leave reservation page before payment is completed
$(window).ajaxStart(function() {
	history.pushState(null, document.title, location.href);
	window.addEventListener('popstate', () => {
		alert('決済中です。少々お待ちください。');
	});
})