const plus_icons = document.querySelectorAll('.plus_btn');
const minus_icons = document.querySelectorAll('.minus_btn');
const num_menus = document.querySelectorAll('.num_menu');
const submit_btn = document.querySelector('.submit_btn');
const select_num_adult = document.querySelector('.select_num_adult');
const select_num_child = document.querySelector('.select_num_child');
const select_date = document.querySelector('.select_date');
const select_time = document.querySelector('.select_time');
const select_seat = document.querySelector('.select_seat');
const menu_price = document.querySelector('.menu_price');
const reservation_code = document.querySelector('.reservation_code');
const discount = document.querySelector('.discount');

let child = 0;
let adult = 0;
let sum_menu = parseInt(num_menus[0].textContent) + parseInt(num_menus[1].textContent)
		+ parseInt(num_menus[2].textContent) + parseInt(num_menus[3].textContent);

var updateReservationInfo = {
	reservation_code: reservation_code.value,
	date: '',
	time: '',
	adult: 0,
	child: 0,
	seat: '',
	karaiRamen: 0,
	shoyu: 0,
	miso: 0,
	tonkotsu: 0,
	price: 0
}



plus_icons.forEach((plusIcon, plusIconIndex) => {
	plusIcon.addEventListener('click', () => {
		countMenu(plusIconIndex, 0);

	});
});

minus_icons.forEach((minusIcon, minusIconIndex) => {
	minusIcon.addEventListener('click', () => {
		countMenu(minusIconIndex, 1);

	});
});

submit_btn.addEventListener('click', () => {
	if (checkInputService()) {
		if (confirm('このまま予約を変更してもよろしいですか？')) {
			updateReservation();
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
		updateReservationInfo.date = select_date.value;
		updateReservationInfo.time = select_time.value;
		updateReservationInfo.adult = adult;
		updateReservationInfo.child = child;
		updateReservationInfo.seat = select_seat.value;
		updateReservationInfo.karaiRamen = num_menus[0].textContent;
		updateReservationInfo.shoyu = num_menus[1].textContent;
		updateReservationInfo.miso = num_menus[2].textContent;
		updateReservationInfo.tonkotsu = num_menus[3].textContent;
		updateReservationInfo.price = calcMenuPrice(sum_menu);
		if (discount.value == 1) {
			reservationInfo.discount = '割引あり'
		}
		return true;
	}
	return false;
}

//menu price service 
function calcMenuPrice(sum_menu) {
	let price
	if (discount.value == '割引あり') {
		price = 500 * sum_menu;

	} else if (discount.value == '割引なし') {
		price = 700 * sum_menu;
	}
	return price;
}

function updateReservation() {
	$.ajax({
		type: "put",
		url: "reservations/" + updateReservationInfo.reservation_code,
		data: JSON.stringify(updateReservationInfo),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			if (data == 0) {
				alert('予約の変更に失敗しました');
			} else if (data == 1) {
				alert('予約を変更しました');
				location.replace('reservations');
			}
		},
		error: function() {

		}
	});
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
