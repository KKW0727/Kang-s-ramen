'use strict'

//inputs index
//0 phone, 1 email, 2 password, 3 repassword 4 birthday 5 gender
const formContainer = document.querySelectorAll('.form_container');
const inputs = document.querySelectorAll('input');
const gender_btns = document.querySelectorAll('.gender_btn');
const submitBtns = document.querySelectorAll('.submit_btn');

let checkPhoneResult = false;
let checkEmailResult = false;
let checkPasswordFormatResult = false;
let checkRePasswordResult =false;
let checkBirthdayResult =false;
let checkGenderResult = false;

var signUpData = {
	signUpEmail: '',
	signUpPassword: '',
    signUpPhone: '',
    signUpBirthday: '',
    signUpGender: ''
}

//keyup input
inputs.forEach((input, inputIndex) => {
    input.addEventListener('keyup', () => checkEmpty(input, inputIndex));
});

//click gender button
gender_btns.forEach((genderBtn, genderBtnIndex) => {
    genderBtn.addEventListener('click', () => checkGenderResult = checkGender(genderBtn, genderBtnIndex));
});

//click submit button
submitBtns.forEach((submitBtn, submitBtnIndex) => {
	
    submitBtn.addEventListener('click', () => onSubmit(submitBtnIndex));
    window.addEventListener('keydown', (e) => {
        if (e.keyCode == 13) {
            onSubmit(submitBtnIndex);
        }
    });
});

//check empty
function checkEmpty(input, inputIndex) {
	
	 activeInput(input, false);
    clearMsg(input);
    if (input.value.length == 0) {
        createMsg(`${input.dataset.input}を入力してください。`, input);
        return;
    }
    //phone
    if (inputIndex == 0) {
        let phoneResult = checkPhoneFormat(input);
        activeInput(input, phoneResult);
        if (phoneResult == true) {
	        checkPhone(input);
        }else {
	        checkPhoneResult =false;  //인증성공 후 다시지워서 형식이 맞지않을떄 false로 바꿔준다.
	                                   //바꾸지 않으면 형식이 맞지않는데 true인상태로 넘어간다.
	 }
    //email
    } else if (inputIndex == 1) {		
         let EmailResult = checkEmailFormat(input);
        activeInput(input, EmailResult);
        if (EmailResult == true) {
	        checkEmail(input);
        }else {
	       checkEmailResult =false;	      
}
        //password
    } else if (inputIndex == 2) {
         checkPasswordFormatResult = checkPasswordFormat(inputs[inputIndex - 1].value, input.value, input);
         activeInput(input, checkPasswordFormatResult);   
        //repassword
     } else if (inputIndex == 3) {
	    checkRePasswordResult = checkRePassword(inputs[inputIndex - 1].value, input.value, input);
	    activeInput(input, checkRePasswordResult);
        //birthday
    } else if (inputIndex == 4) {	
        checkBirthdayResult = checkBirthday(input);
        activeInput(input, checkBirthdayResult);
    } 
    
}


//check PhoneFormat
function checkPhoneFormat(input) {
    var regPhone = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
    if (!regPhone.test(input.value)) {
        createMsg('電話番号を正しく入力してください。', input);
        return false;
    } else {
        if (input.value.length > 13) {
            createMsg('電話番号を正しく入力してください。', input);
            return false;
        }
        clearMsg(input);
        return true;
    }
}

    //check Phone
    function checkPhone(input) {
     
        $.ajax({
            type: "post",
            url: "registry/phone-check",
            data: {
                signUpPhone: input.value
            },
            success: function (data) {

                if (data == 2) {
                    createMsg('この電話番号はすでに存在します', input);
                    checkPhoneResult = false;
                    activeInput(input, checkPhoneResult);
                } else if (data == 1) {
                    createMsg('この電話番号は使えます', input);
                    checkPhoneResult = true;                   
                    signUpData.signUpPhone = input.value;                 
                }else if (data == 0) {
	                createMsg('電話番号が無効です。', input);
                    checkPhoneResult = false;
                }
            },
            error: function () {

            }
        })
    }

    //check EmailFormat
    function checkEmailFormat(input) {
        let regEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
        if (!regEmail.test(input.value)) {
            createMsg('メールアドレスを正しく入力してください。', input);
            return false;
        }
        clearMsg(input);
        return true;
    }

    //check Email
    function checkEmail(input) {
          $.ajax({
             type: "post",
             url:"registry/email-check",
             data: {
                    signUpEmail : input.value
                  },
             success: function(data) {
	           
               if(data == 1){
                createMsg('このメールアドレスはすでに存在します', input);
                 checkEmailResult = false;
                 }else if(data == 0){
                createMsg('このメールアドレスは使えます', input);
                signUpData.signUpEmail = input.value;
                  checkEmailResult = true;
                  
               }
             },
             error: function() {
   
             }
        })
    }

    //check PasswordFormat
    function checkPasswordFormat(inputEmail, inputPassword, input) {
        if (!/^[a-zA-Z0-9]{8,16}$/.test(inputPassword)) {
            createMsg('パスワードは8文字以上16文字以内で数字とアルファベットを使用してください。', input);
            return false;
        }
        
        if (/(\w)\1\1\1/.test(inputPassword)) {
            createMsg('同じ文字が３文字以上続けません。', input);
            return false;
        }
           
        if (inputPassword.length >= 8 && inputPassword.length < 10) {
            createMsg('このパスワードは使えます。セキュリティレベル弱い', input);
        } else if (inputPassword.length >= 10 && inputPassword.length < 14) {
            createMsg('このパスワードは使えます。セキュリティレベルまあまあ', input);
        } else if (inputPassword.length >= 14 && inputPassword.length < 17) {
            createMsg('このパスワードは使えます。セキュリティレベル強固', input);
        }
        return true;
    }

    //check Repassword
    function checkRePassword(password, repassword, input) {       
        if (password != repassword) {
            createMsg('パスワードが一致しません', input);         
             return false;
        }
        clearMsg(input);
        signUpData.signUpPassword = input.value;
             return true;
    }

    //check birthday
    function checkBirthday(input) {
        let datatimeRegexp = /[0-9]{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])/;
        if (!datatimeRegexp.test(input.value)) {
            createMsg('生年月日は YYYY-MM-DD 形式である必要があります。', input);
            checkBirthdayResult = false;
            return false;
        }
        clearMsg(input);
         checkBirthdayResult = true;
        signUpData.signUpBirthday = input.value;     
        return true;
    }


    //check Gender
    function checkGender(genderBtn, genderBtnIndex) {    
        if (genderBtnIndex == 0) {
            signUpData.signUpGender = '男性';
            gender_btns[genderBtnIndex + 1].style.backgroundColor = '#808080';
        } else if (genderBtnIndex == 1) {
             signUpData.signUpGender = '女性';
            gender_btns[genderBtnIndex - 1].style.backgroundColor = '#808080';
        }
        genderBtn.style.backgroundColor = 'brown';
        return true;
    }
    
    
    //signUp Submit
    function signUpSubmit() {

	  $.ajax({
		 type: "post",
		 url : "users",
		 data: JSON.stringify(signUpData),
		 contentType: "application/json;charset=UTF-8",
		 dataType: "text",
		 success: function(data) {
			
			 if(data == 0) {
				if(confirm('登録に失敗しました。 ホームに戻りますか')){
					location.replace('index');
				}
			}else if(data == 1) {			
				 alert('会員登録が完了しました。　ご登録ありがとうございます！');
				 location.replace('index');
			}
		},
		error:function() {
			
		}
	})
}

    //call onSubmit when click and keydown button
    function onSubmit(submitBtnIndex) {
	if(submitBtnIndex == 0){
		 if (checkPhoneResult == true) {
            let signUpDiscription = document.querySelector('.signUp_discription');
            formContainer[0].classList.add('invisible');
            signUpDiscription.textContent = '会員登録のためにプロフィールを作成してください';
            formContainer[1].classList.remove('invisible');          
        }
    }else if(submitBtnIndex == 1) {	
	inputs.forEach((input, inputIndex) => {
		 checkEmpty(input, inputIndex);
     });
    if(checkPhoneResult == true && checkEmailResult == true && checkRePasswordResult == true && checkBirthdayResult == true && checkGenderResult == true){
		if(confirm('このまま登録してもよろしいですか')) {
			signUpSubmit();
			}		  
		}
	} 		
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
