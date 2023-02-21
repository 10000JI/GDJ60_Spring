//div 태그가 잡혀 온다
const d1 = document.getElementById("d1");

//전역변수
let n = 'iu';
var old = "iu";

// fuction 선언
function f1(){
    console.log("function Test");
    console.log(n);
    var old="winter";
}

//매개변수 선언 시 let, const는 생략 해야 한다
function f2(n1, n2){
    //지역변수
    let name='iu';
    return n1+n2;
}

//fuction 호출
f1();
let result = f2(1,2);
console.log(result);
console.log(name);
//console.log(n1);
console.log("Old: "+old);

//변수는 함수도 담을 수 있다
let fun = function(){
    console.log('익명함수');
    return 1;
}

fun();

//함수 매개변수 안에 함수 호출도 가능
//변수명으로 넣어줘야 함 ( ()를 빼서 넣어줌 )
//문자와 변수 등 연결 시 "+" 말고 ","도 가능
function f3 (f){
    console.log("f3 :", f, 1);
}



//다른 곳에서도 같은 함수를 사용하고 싶을 때
//d1.addEventListener("click",callback1);
//d1.addEventListener("click",callback2);

//여기에서만 사용하는 함수
d1.addEventListener("click",function(){
    callback1();
    callback2();
});

function callback1(){
    console.log("CollBack1");
}

let callback2 = function(){
    console.log("CoolBack2")
}
