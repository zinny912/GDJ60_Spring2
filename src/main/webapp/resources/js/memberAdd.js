//selector
const id = document.getElementById("id");
const idResult = document.getElementById("idResult");

const pwd1 = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");

const pwd2 = document.getElementById("pwCheck");
const pwCheck = document.getElementById("pwCheckResult");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

const email = document.getElementById("email");
const emailCheck = document.getElementById("emailCheck");

const name1 = document.getElementById("name1");
const nameCheck = document.getElementById("nameCheck");

const address = document.getElementById("address");
const addressCheck = document.getElementById("addressCheck");

const phone = document.getElementById("phone");
const phoneCheck = document.getElementById("phoneCheck");

// let idCheck=false;
// let pwLengthCheck=false;
// let pwNullCheck=false;
// let pwEqualCheck=false;
// let nameCheck=false;
// let emailCheck=false;
// let addressCheck=false;
// let phoneCheck=false;

let checks = [false, false, false, false];


//중요도가 높은것을 먼저 수행 중요도가 떨어지는 것을 else로 
//ID검증 (다 입력하고 나갈때)
id.addEventListener("blur", function(){
    if(id.value){
        idResult.innerHTML="사용가능한ID";
        //idcheck=true;
        checks[0]=true;
        idResult.classList.add('blueResult');
        idResult.classList.remove('redResult');
    }else{
        idResult.innerHTML="ID는 필수 사항 입니다";
        checks[0]=false;
        idResult.classList.add('redResult');
        idResult.classList.remove('blueResult');
    }
});



//pw검증
pw.addEventListener("keyup", function(){
    if(pw.value.length>5 && pw.value.length<13){
        pwResult.innerHTML="정상적인 비번입니다"
        //pwLengthCheck=true;
        checks[1]=true;
        pwResult.classList.add('blueResult');
        pwResult.classList.remove('redResult');
    }else{
        pwResult.innerHTML="비번은 6글자이상 12글자이하여야 합니다."
        checks[1]=false;
        pwResult.classList.add('redResult');
        pwResult.classList.remove('blueResult');

    }
});


pw.addEventListener("blur", function(){
    if(pw.value!=''){
        //pwNullCheck=true;
        checks[2]=true;
    }else{
        pwResult.innerHTML="비밀번호는 필수 사항 입니다"
        checks[2]=false;
        pwResult.classList.add('redResult');
        pwResult.classList.remove('blueResult');
    }    
});

pw.addEventListener("change", function(){
    checks[3]=false;
    pwCheck.value='';
    pwCheckResult.innerHTML='pw가 틀립니다.';
    pwCheckResult.classList.add('redResult');
    pwCheckResult.classList.remove('blueResult');

});

//PW Equal 검증
pwCheck.addEventListener("blur", function(){
    if(pwCheck.value == pw.value){
        pwCheckResult.innerHTML="동일한 PW"
        //pwEqualCheck=true;
        checks[3]=true;
        pwCheckResult.classList.add('blueResult');
        pwCheckResult.classList.remove('redResult');
    }else{
        pwCheckResult.innerHTML="틀렸습니다"
        checks[3]=false;
        pwCheckResult.classList.add('redResult');
        pwCheckResult.classList.remove('blueResult');
       
    }

});



// 이름 검증
name1.addEventListener("blur", function(){
    if(name1.value){
        nameCheck.innerHTML="";
        //idcheck=true;
        checks[4]=true;
    }else{
        nameCheck.innerHTML="이름은 필수 사항 입니다";
        checks[4]=false;
        nameCheck.classList.replace('blueResult','redResult');
    }
});

//email 검증
email.addEventListener("blur", function(){
    if(email.value.length!=0){
        emailCheck.innerHTML="";
        //idcheck=true;
        checks[5]=true;
    }else{
        emailCheck.innerHTML="EMAIL ID는 필수 사항 입니다";
        checks[5]=false;
        emailCheck.classList.replace('blueResult','redResult');
    }
});

//전화번호 검증
phone.addEventListener("blur", function(){
    if(phone.value.length!=0){
        phoneCheck.innerHTML="";
        //idcheck=true;
        checks[6]=true;
    }else{
        phoneCheck.innerHTML="휴대폰번호는 필수 사항 입니다";
        checks[6]=false;
        phoneCheck.classList.replace('blueResult','redResult');
    }
});

//주소 검증
address.addEventListener("blur", function(){
    if(address.value.length!=0){
        addressCheck.innerHTML="";
        //idcheck=true;
        checks[7]=true;
    }else{
        addressCheck.innerHTML="주소는 필수 사항 입니다";
        checks[7]=false;
        addressCheck.classList.replace('blueResult','redResult');
    }
});

// form 전송
btn.addEventListener("click", function(){
    
    if(!checks.includes(false)) {
        alert('회원가입 성공')
        frm.submit();
    }else{
        alert("필수사항을 입력하세요")
    }

});

//if(idCheck && pwCheck && pwLengthCheck && pwNullCheck && pwEqualCheck)