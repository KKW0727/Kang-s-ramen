'use strict'

const update_btns = document.querySelectorAll('.update_btn');
const user_email = document.querySelector('.user_email');
const inputs = document.querySelectorAll('.input');
const updatable_input_boxs = document.querySelectorAll('.updatable_input_box');
const withdraw_btn = document.querySelector('.withdraw_btn');
const id = document.querySelector('.id');

var checkPhoneResult = true;
var passwordFormatResult = true;
var checkBirthdayResult = true;

var updateUser = {
	id: id.value,
	updateUserPassword: '',
	updateUserPhone: '',
	updateUserBirthday: '',
	updateUserFlag: 0
}

//keyup input
inputs.forEach((input, inputIndex) => {
	input.addEventListener('keyup', () => checkEmpty(input, inputIndex));

});

//click update button
update_btns.forEach((updateBtn, updateBtnIndex) => {
	updateBtn.addEventListener('click', (e) => {
		let targetInput = e.target.previousElementSibling;
		let targetUpdateBtn = e.target;
		activeInput(targetInput, targetUpdateBtn, updateBtnIndex);

		window.addEventListener('click', (e) => {
			if (e.target.classList.contains('update_btn') || e.target.tagName == 'INPUT') {
				return;
			}
			location.href = id.value;

		});

	});
});

//click withdraw button
withdraw_btn.addEventListener('click', () => {
	getNumberReservation();
});

//check empty
function checkEmpty(input, inputIndex) {

	errorInput(input, false);
	clearMsg(inputIndex);
	if (input.value.length == 0) {
		createMsg(`${input.dataset.type}を入力してください。`, inputIndex);
		return;
	}
	//phone
	if (inputIndex == 0) {

		let phoneResult = checkPhoneFormat(input, inputIndex);
		errorInput(input, phoneResult);
		if (phoneResult == true) {
			checkPhone(input, inputIndex);
		} else {
			checkPhoneResult = false;  //인증성공 후 다시지워서 형식이 맞지않을떄 false로 바꿔준다.
			//바꾸지 않으면 형식이 맞지않는데 true인상태로 넘어간다.
		}

		//password
	} else if (inputIndex == 1) {

		passwordFormatResult = checkPasswordFormat(inputs[inputIndex - 1].value, input.value, inputIndex);
		errorInput(input, passwordFormatResult);
		//birthday
	} else if (inputIndex == 2) {
		checkBirthdayResult = checkBirthday(input, inputIndex);
		errorInput(input, checkBirthdayResult);
	}

}


//check PhoneFormat
function checkPhoneFormat(input, inputIndex) {
	var regPhone = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
	if (!regPhone.test(input.value)) {
		createMsg('電話番号を正しく入力してください。', inputIndex);
		return false;
	} else {
		if (input.value.length > 13) {
			createMsg('電話番号を正しく入力してください。', inputIndex);
			return false;
		}
		clearMsg(inputIndex);
		return true;
	}
}

//check Phone
function checkPhone(input, inputIndex) {

	$.ajax({
		type: "post",
		url: "/kangs-ramen/registry/phone-check",
		data: {
			signUpPhone: input.value
		},
		success: function(data) {

			if (data == 2) {
				createMsg('この電話番号はすでに存在します', inputIndex);
				checkPhoneResult = false;
				errorInput(input, checkPhoneResult);
			} else if (data == 1) {
				createMsg('この電話番号は使えます', inputIndex);
				checkPhoneResult = true;

			} else if (data == 0) {
				createMsg('電話番号が無効です。', inputIndex);
				checkPhoneResult = false;
			}
		},
		error: function() {

		}
	})
}


//check PasswordFormat
function checkPasswordFormat(inputEmail, inputPassword, inputIndex) {

	if (!/^[a-zA-Z0-9]{8,16}$/.test(inputPassword)) {
		createMsg('パスワードは8文字以上16文字以内で数字とアルファベットを使用してください。', inputIndex);
		return false;
	}

	var checkNumber = inputPassword.search(/[0-9]/g);
	var checkEnglish = inputPassword.search(/[a-z]/ig);

	if (checkNumber < 0 || checkEnglish < 0) {
		createMsg('数字とアルファベットを使用してください。', inputIndex);
		return false;
	}

	if (/(\w)\1\1\1/.test(inputPassword)) {
		createMsg('同じ文字が３文字以上続けません。', inputIndex);
		return false;
	}
	if (inputEmail != '') {
		if (inputPassword.search(inputEmail) > -1) {
			createMsg('パスワードにメールアドレスが含まれています', inputIndex);
			return false;
		}
	}
	if (inputPassword.length >= 8 && inputPassword.length < 10) {
		createMsg('このパスワードは使えます。セキュリティレベル弱い', inputIndex);
	} else if (inputPassword.length >= 10 && inputPassword.length < 14) {
		createMsg('このパスワードは使えます。セキュリティレベルまあまあ', inputIndex);

	} else if (inputPassword.length >= 14 && inputPassword.length < 17) {
		createMsg('このパスワードは使えます。セキュリティレベル強固', inputIndex);
	}
	return true;
}

//check birthday
function checkBirthday(input, inputIndex) {
	let datatimeRegexp = /[0-9]{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])/;

	if (!datatimeRegexp.test(input.value)) {
		createMsg('生年月日は YYYY-MM-DD 形式である必要があります。', inputIndex);
		checkBirthdayResult = false;
		return false;
	}
	clearMsg(inputIndex);
	checkBirthdayResult = true;


	return true;
}

//update user
function updateUserInfo() {
	$.ajax({
		type: "patch",
		url: updateUser.id,
		data: JSON.stringify(updateUser),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			if (data == 1) {
				if (updateUser.updateUserFlag == 1) {
					alert('電話番号を変更しました。');
				} else if (updateUser.updateUserFlag == 2) {
					alert('パスワードを変更しました。');
				} else if (updateUser.updateUserFlag == 3) {
					alert('誕生日を変更しました。');
				}
				updateUser.updateUserPhone = '';
				updateUser.updateUserPassword = '';
				updateUser.updateUserBirthday = '';
			}
		},
		error: function() {
			alert('');
		}
	});
}

//get number reservation
function getNumberReservation() {
	$.ajax({
		type: "get",
		url:  id.value + "/num-reservation",
		dataType: "text",
		success: function(data) {
			if (data == 0) {
				if (confirm('本当に退会してもよろしいですか?')) {
					withdraw();
				}
			} else {
				if (confirm(`予約した${data}件もキャンセルされます。そのまま続けてもよろしいですか?`)) {
					withdraw();
				}
			}
		},
		error: function() {

		}
	})
}

//withdraw
function withdraw() {
	$.ajax({
		type: "delete",
		url: "users/" + id.value,
		dataType: "text",
		success: function(data) {
			if (data == 1) {
				alert('会員退会が完了しました。これまで kang’sラーメンをご利用いただきありがとうございました!');
				location.href = 'index';
			} else if (data == 0) {
				alert('会員退会に失敗しました。');
			}
		},
		errror: function() {

		}

	});
}

//active input
function activeInput(targetInput, targetUpdateBtn, updateBtnIndex) {

	//classList에 fa-save가 포함되어있지 않다면 input활성화 
	if (!targetUpdateBtn.classList.contains('fa-save')) {
		targetUpdateBtn.classList.add('fa-save');
		targetInput.disabled = false;
		targetInput.focus();
		targetInput.placeholder = `${targetInput.dataset.type}を入力してください。`;
		return;
	}
	//classList에 fa-save가 포함되어있다면 input비활성화
	if (targetUpdateBtn.classList.contains('fa-save')) {
		//phone
		if (targetInput.dataset.type == '電話番号' && checkPhoneResult == true) {
			//target이 phone이라면 ajax에 보내기 위해  updateUser객체에바뀐 전화번호 저장 후 ajax호출 
			updateUser.updateUserFlag = 1;
			updateUser.updateUserPhone = targetInput.value;
			clearMsg(updateBtnIndex);
			//password
		} else if (targetInput.dataset.type == 'パスワード' && passwordFormatResult == true) {

			updateUser.updateUserFlag = 2;
			updateUser.updateUserPassword = targetInput.value;
			clearMsg(updateBtnIndex);
			//birthday
		} else if (targetInput.dataset.type == '誕生日' && checkBirthdayResult == true) {
			updateUser.updateUserFlag = 3;
			updateUser.updateUserBirthday = targetInput.value;
			clearMsg(updateBtnIndex);
			//입력할수있는 상태에서 형식이안맞거나, 중복확인에실패 했을 때에는 아이콘도 바뀌지 않고 update()도 실행되지 않는다.
		} else {
			return;
		}
		targetUpdateBtn.classList.remove('fa-save');
		targetInput.disabled = true;
		targetInput.placeholder = '';
		updateUserInfo();
	}
}

//error input
function errorInput(input, checkResult) {
	if (checkResult == false) {
		input.classList.add('input_error');
	} else if (checkResult == true) {
		input.classList.remove('input_error');
	}

}

//create Message
function createMsg(msgContent, inputIndex) {
	while (updatable_input_boxs[inputIndex].lastChild.tagName != 'P') {
		const p = document.createElement('p');
		p.textContent = msgContent;
		p.classList.add('msg');
		updatable_input_boxs[inputIndex].append(p);
	}
}


//clear Message
function clearMsg(inputIndex) {
	while (updatable_input_boxs[inputIndex].lastChild.tagName == 'P') {
		updatable_input_boxs[inputIndex].lastChild.remove();
	}
}