//css 선택자 유형
const btn1 = document.querySelector("#btn1") //document.getElementById('btn1');

//querySelector == querySelectorAll[0];

const buttons =document.querySelectorAll('.buttons');//=document.getElementsByClassName('buttons');

const d1 = document.querySelector('#d1 > .buttons li'); //자식선택자 찾음

let ar = [1,2,3];

console.log('old')
for(let i=0;i<ar.length;i++){
    console.log(ar[i]);
}

console.log('For of');
for(let a of ar){
    console.log(a);
}

console.log('For in');
for(let j in ar){
    console.log(j);
    console.log(ar[j]);
}

console.log('For each')
ar.forEach(function(v, i, list){
    console.log('v: ',v,'i: ',i, 'ar:', list);
})


btn1.addEventListener('click',function(){
    console.log('btn1');
})

// for(let b of buttons){
//     b.addEventListener('click',function(){
//         console.log("buttons"); 
//     })
// }

alert(buttons);
alert(ar);
console.log(buttons);
console.log(ar);

buttons.forEach(function(v,i){
    v.addEventListener('click',function(){
        console.log('click');
    });
})


//더하기만 연결연산자 , 산술연산자 역할 조냊
//곱하기 나누기 빼기는 문자열과 함께 써도 산술연산자로 채택
console.log(parseInt('1')+1);
console.log('1'*1+1);
console.log('1'/1+1);
console.log('1'-1+1);