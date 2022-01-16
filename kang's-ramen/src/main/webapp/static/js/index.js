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

logout_icon.addEventListener('click', () => {
	if(confirm('本当にログアウトしますか')) {
		location.href = 'logout';
	}
});