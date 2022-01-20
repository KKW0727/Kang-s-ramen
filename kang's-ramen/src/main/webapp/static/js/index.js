'use strict'

const main_icons = document.querySelector('.main_icons');
const main_info_icons = document.querySelectorAll('.main_info_icon');
const main_infos = document.querySelectorAll('.main_info');
const logout_icon = document.querySelector('.logout');
const login_user = document.querySelector('.login_user');
const reservation_icons = document.querySelectorAll('.reservation');
const my_team_score = document.querySelector('.my_team_score');
const opponent_team_score = document.querySelector('.opponent_team_score');

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
	reservation_icon.addEventListener('click' ,() => {
		if(login_user.value == '') {
			alert('ログインが必要です!!');
		}else {
			if(reservation_iconIndex == 0) {
				let game_result = 0;
				if(my_team_score.textContent > opponent_team_score.textContent){
					game_result = 1;
				}else if(my_team_score.textContent < opponent_team_score.textContent || my_team_score.textContent == opponent_team_score.textContent){
					game_result = 2;
				}
				location.href = 'reservation?game_result=' + game_result;
			}else if(reservation_iconIndex == 1) {
				location.href = 'confirm-reservation';
			}
		}
	})
});

logout_icon.addEventListener('click', () => {
	if (confirm('本当にログアウトしますか')) {
		location.href = 'logout';
	}
});