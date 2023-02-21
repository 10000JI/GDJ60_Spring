//SELECTOR
const id = document.getElementById("id");
const idResult = document.getElementById("idResult");

const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");

const pwCheck = document.getElementById("pwCheck");
const pwCheckResult = document.getElementById("pwCheckResult");

let name = document.getElementById("name");
let email = document.getElementById("email");
let phone = document.getElementById("phone");

let text2 = document.getElementById("text2");
let text3 = document.getElementById("text3");
let text4 = document.getElementById("text4");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

// let idCheck=false;
// let pwLengthCheck=false;
// let pwNullCheck=false;
// let pwEqualCheck=false;
let checks = [false, false, false, false]


// ID 검증
id.addEventListener("blur", function(){
    if(id.value.length != 0){
        idResult.innerHTML="정상적인 ID";
        //idCheck=true;
        checks[0]=true; 
        idResult.classList.add("blueResult");
        idResult.classList.remove("redResult");
    }else {
        idResult.innerHTML='ID는 필수 사항 입니다';
        checks[0]=false;
        idResult.classList.add("redResult");
        idResult.classList.remove("blueResult");
    }
});

//PW 검증
pw.addEventListener("keyup", function(){
    if(pw.value.length>5 && pw.value.length<13){
        pwResult.innerHTML='정상 비번'
        //pwLengthCheck=true;
        checks[1]=true;
    }else {
        pwResult.innerHTML='비번은 6글자 이상 12자 이하여야 합니다'
        checks[1]=false;
    }
})

pw.addEventListener("blur", function(){
    if(pw.value!=''){
        //pwNullCheck=true;
        checks[2]=true;
    }else {
        pwResult.innerHTML='PW는 필수 입니다'
        checks[2]=false;
    }
})

pw.addEventListener("change", function(){
    checks[3]=false;
    pwCheck.value='';
    pwCheckResult.innerHTML='PW가 틀립니다';
})

//pw Equal 검증
pwCheck.addEventListener("blur", function(){
    if(pwCheck.value == pw.value){
        pwCheckResult.innerHTML="동일한 PW"
        //pwEqualCheck=true;
        checks[3]=true;
    }else {
        pwCheckResult.innerHTML="PW가 틀립니다"
        checks[3]=false;
    }
});

//form 전송

btn.addEventListener("click", function(){
    //if(idCheck && pwLengthCheck && pwNullCheck && pwEqualCheck){
    if(!checks.includes(false)){
        alert('회원가입 성공');
        frm.submit();
    }else {
        alert("필수 사항을 입력하세요")
    }
})





name.addEventListener("blur",function(){
    if(name.value==""){
        text2.innerText="필수정보입니다.";

    } else{
        text2.innerText="";
    }

    console.log(name.value)
});

phone.addEventListener("blur",function(){
    if(phone.value==""){
        text3.innerText="필수정보입니다.";
    } else{
        text3.innerText="";
    }

    console.log(phone.value)
});

email.addEventListener("blur",function(){
    if(email.value==""){
        text4.innerText="필수정보입니다.";
    } else{
        text4.innerText="";
    }

    console.log(email.value)
});
