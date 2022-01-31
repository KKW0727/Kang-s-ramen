'use strict'

const inputs = document.querySelectorAll('input');
const submit_btn = document.querySelector('.submit_btn');

let EmailResult = false;
let passwordResult = false;

var signInData = {
	signInEmail: '',
	signInPassword: '',
}

//keyup input
inputs.forEach((input, inputIndex) => {
	input.addEventListener('keyup', () => checkEmpty(input, inputIndex));
});

//click submit button
submit_btn.addEventListener('click', () => {
	if (EmailResult == true && passwordResult == true) {
		signInSubmit();
	}
});

//check empty
function checkEmpty(input, inputIndex) {
	activeInput(input, 0);
	clearMsg(input);
	if (input.value.length == 0) {
		createMsg(`${input.dataset.input}を入力してください。`, input);
		return;
	}
	//email
	if (inputIndex == 0) {
		EmailResult = checkEmailFormat(input);
		activeInput(input, EmailResult);
	//password
	} else if (inputIndex == 1) {
		if (input.value.length != 0) {
			passwordResult = true;
			signInData.signInPassword = input.value;
			activeInput(input, true);
			clearMsg(input);
		}
	}
}


//check EmailFormat
function checkEmailFormat(input) {

	let regEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if (!regEmail.test(input.value)) {
		createMsg('メールアドレスを正しく入力してください。', input);
		return false;
	}
	clearMsg(input);
	signInData.signInEmail = input.value;
	return true;
}


//sign in submit
function signInSubmit() {
	$.ajax({
		type: "post",
		url: "login",
		data: JSON.stringify(signInData),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			if (data == 0)  {
				createMsg('メールアドレスが正しくありません', inputs[data]);
			} else if (data == 1) {
				createMsg('パスワードが正しくありません', inputs[data]);
			} else if (data == 2) {
				alert('ログインに成功しました。ホーム画面へ移動します。')
				location.replace('index');
			}
		}

	})
}


//active Input
function activeInput(input, checkResult) {
	if (checkResult == false) {
		input.classList.add('input_error');
	} else if (checkResult == true) {
		input.classList.remove('input_error');
	}
}

//clear Message
function clearMsg(input) {
	while (input.nextElementSibling.tagName == 'SPAN') {
		input.nextElementSibling.remove();
	}
}

//create Message
function createMsg(msgContent, input) {
	while (input.nextElementSibling.tagName != 'SPAN') {
		const span = document.createElement('span');
		span.textContent = msgContent;
		span.classList.add('msg');
		input.after(span);
	}
}