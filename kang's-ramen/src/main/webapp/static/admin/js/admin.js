'use strict'

const header_menu = document.querySelector('.header_menu');
const info_containers = document.querySelectorAll('.info_container');
const menu_btns = document.querySelectorAll('.header_menu li');
const search_date = document.querySelector('.search_date');
const user_search_icons = document.querySelectorAll('.user_search_icon');
const reservation_search_icons = document.querySelectorAll('.reservation_search_icon');
const user_search_selects = document.querySelectorAll('.user_search_select');
const reservation_search_selects = document.querySelectorAll('.reservation_search_select');
const user_search_inputs = document.querySelectorAll('.user_search_input');
const reservation_search_inputs = document.querySelectorAll('.reservation_search_input');
const user_infos = document.querySelectorAll('.user_infos');
const reservation_infos = document.querySelectorAll('.reservation_infos');
const sales_infos = document.querySelector('.sales_infos');

// filtering when click header menu 
header_menu.addEventListener('click', (e) => {
	let target = e.target;
	let targetType = target.dataset.type;
	if (targetType == null) {
		return;
	}
	menu_btns.forEach(menu_btn => {
		menu_btn.classList.remove('color_dark');
	});
	info_containers.forEach(info_container => {
		if (info_container.dataset.type == targetType) {
			info_container.classList.remove('invisible');
			target.classList.add('color_dark');
		} else
			info_container.classList.add('invisible');
	});
});

//click user search icon
user_search_icons.forEach((user_search_icon, user_search_icon_index) => {
	user_search_icon.addEventListener('click', () => {
		let searchType = user_search_selects[user_search_icon_index].value;
		let url = '';
		if (searchType == '電話番号' && user_search_inputs[user_search_icon_index].value.length == 0) {
			alert('ユーザーの電話番号を入力してください。');
			return;
		}
		if (user_search_icon_index == 0) {
			if (searchType == 'すべて') {
				url = 'user/all/no';
			} else if (searchType == '電話番号') {
				url = 'user/phone/' + user_search_inputs[user_search_icon_index].value;
			}
		} else if (user_search_icon_index == 1) {
			if (searchType == 'すべて') {
				url = 'withdrawal-user/all/no';
			} else if (searchType == '電話番号') {
				url = 'withdrawal-user/phone/' + user_search_inputs[user_search_icon_index].value;
			}
		}
		getUserInfo(url, user_search_icon_index);
	});
});

//user情報を取得のためにサーバーに送信
function getUserInfo(url, iconIndex) {
	$.ajax({
		type: "get",
		url: url,
		dataType: "text",
		success: function(data) {
			let userInfo = JSON.parse(data);
			showUserInfo(userInfo, iconIndex);
		},
		error: function() {
			alert('error')
		}
	});
}

//show user, withdrawal user info
function showUserInfo(userInfo, userType) {
	user_infos[userType].textContent = '';
	for (let user of userInfo) {
		user_infos[userType].innerHTML += `
				<ul class="user_info info">
				<li>${user.id}</li>
				<li>${user.user_email}</li>
				<li>${user.user_password}</li>
				<li>${user.user_phone}</li>
				<li>${user.user_birthday}</li>
				<li>${user.user_gender}</li>
				<li>${user.user_date}</li>
				</ul>			 `
	}
}

//click reservation search icon
reservation_search_icons.forEach((reservation_search_icon, reservation_search_icon_index) => {
	reservation_search_icon.addEventListener('click', () => {
		let searchType = reservation_search_selects[reservation_search_icon_index].value;
		let url = '';
		if (searchType == '電話番号' && reservation_search_inputs[reservation_search_icon_index].value.length == 0) {
			alert('ユーザーの電話番号を入力してください。');
			return;
		}
		if (reservation_search_icon_index == 0) {
			if (searchType == 'すべて') {
				url = 'reservations/all/no';
			} else if (searchType == '電話番号') {
				url = 'reservations/phone/' + reservation_search_inputs[reservation_search_icon_index].value;
			}
		} else if (reservation_search_icon_index == 1) {
			if (searchType == 'すべて') {
				url = 'cancel-reservation/all/no';
			} else if (searchType == '電話番号') {
				url = 'cancel-reservation/phone/' + reservation_search_inputs[reservation_search_icon_index].value;
			}
		}
		getReservation(url, reservation_search_icon_index);
	});
});

//reservation情報を取得のためにサーバーに送信
function getReservation(url, iconIndex) {
	$.ajax({
		type: "get",
		url: url,
		dataType: "text",
		success: function(data) {
			let reservationInfo = JSON.parse(data);
			showReservationInfo(reservationInfo, iconIndex);
		},
		error: function() {
			alert('error')
		}
	});
}

//show user, withdrawal user info
function showReservationInfo(reservationInfo, reservationType) {
	let payment = '未決済';
	reservation_infos[reservationType].textContent = '';
	for (let reservation of reservationInfo) {
		if (reservation.payment_key != null) {
			payment = '未決完了';
		}
		reservation_infos[reservationType].innerHTML += `
				<ul class="reservation_info info">
				<li>${reservation.reservation_code}</li>
				<li>${reservation.date}</li>
				<li>${reservation.time}</li>
				<li>大人${reservation.adult}子供${reservation.child}</li>
				<li>${reservation.seat}</li>
				<li>辛いラーメン${reservation.karaiRamen}醤油${reservation.shoyu}
				味噌${reservation.miso}豚骨${reservation.tonkotsu}</li>
				<li>${reservation.price}</li>
				<li>${payment}</li>
				<li>${reservation.reservation_date}</li>
				</ul>			 `
	}
}

//change date input
search_date.addEventListener('change', () => {
	$.ajax({
		type: "get",
		url: "sales/" + search_date.value,
		dataType: "text",
		success: function(data) {
			let salesInfo = JSON.parse(data);
			showSalesInfo(salesInfo);
		},
		error: function() {
			alert('error');
		}
	});
});

//show sales
function showSalesInfo(salesInfo) {
	sales_infos.textContent = '';
	sales_infos.innerHTML += `
		<ul class="sales_info info">
				<li>${salesInfo.total_reservation}</li>
				<li>${salesInfo.total_karaiRamen}</li>
				<li>${salesInfo.total_shoyu}</li>
				<li>${salesInfo.total_miso}</li>
				<li>${salesInfo.total_tonkotsu}</li>
				<li>${salesInfo.total_price}</li>
				</ul>				
	`
}
