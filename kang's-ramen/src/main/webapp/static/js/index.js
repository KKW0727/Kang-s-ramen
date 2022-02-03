'use strict'

const main_icons = document.querySelector('.main_icons');
const main_info_icons = document.querySelectorAll('.main_info_icon');
const main_infos = document.querySelectorAll('.main_info');
const logout_icon = document.querySelector('.logout');
const login_user = document.querySelector('.login_user');
const reservation_icons = document.querySelectorAll('.reservation');
const teams_score = document.querySelectorAll('.team_score');
const teams_logo = document.querySelectorAll('.team_logo');
const to_update_game_btn = document.querySelector('.to_update_game_btn');
const update_game_form = document.querySelector('.update_game_form');
const game_info_dtl = document.querySelector('.game_info_dtl');

//click main icon
main_icons.addEventListener('click', (e) => {
	main_info_icons.forEach((main_info_icon) => {
		main_info_icon.classList.remove('rotate');
	});
	console.log(e.target)
	let target = e.target;
	let type = target.dataset.type;
	if (type == null) {
		return;
	}
	if (type = 'game_info') {
		getGameInfo();
	}
	main_infos.forEach((main_info) => {
		if (type == main_info.dataset.type) {
			target.classList.add('rotate');
			main_info.classList.remove('invisible');
		} else {
			main_info.classList.add('invisible');
		}
	});

});

reservation_icons.forEach((reservation_icon, reservation_iconIndex) => {
	reservation_icon.addEventListener('click', () => {
		if (login_user.value == '') {
			alert('ログインが必要です!!');
		} else {
			if (reservation_iconIndex == 0) {
				location.href = 'reservation?game_result=' + game_result;
			} else if (reservation_iconIndex == 1) {
				location.href = 'reservations';
			}
		}
	})
});

//click to update game button
window.addEventListener('click', (e) => {
	if (e.target.dataset.type == 'update_game') {
		to_update_game_btn.classList.add('invisible')
		update_game_form.classList.remove('invisible');
	}
});

//get game info
function getGameInfo() {
	$.ajax({
		type: "get",
		url: "game",
		dataType: 'text',
		success: function(data) {
			let gameInfo = JSON.parse(data);
			teams_logo[0].setAttribute('src', `images/index/${gameInfo.my_team}.png`);
			teams_logo[1].setAttribute('src', `images/index/${gameInfo.opponent_team}.png`);
			teams_score[0].textContent = gameInfo.my_team_score;
			teams_score[1].textContent = gameInfo.opponent_team_score;
			game_info_dtl.setAttribute('href', gameInfo.game_info_dtl_url);
		},
		error: function() {

		}
	})

}

logout_icon.addEventListener('click', () => {
	if (confirm('本当にログアウトしますか')) {
		$.ajax({
			type: "delete",
			url: "logout",
			dataType: "text",
			success: function(data) {
				if (data == 1) {
					alert('ログアウトしました。');
					location.replace('index');
				} else {
					alert('ログアウトに失敗しました。');
				}
			},
			error: function() {

			}
		})
	}
});