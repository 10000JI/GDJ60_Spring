//css 선택자 유형
const btn1 = document.querySelector("#btn1") //document.getElementById('btn1');

//querySelector == querySelectorAll[0];

const buttons = document.querySelectorAll(".buttons") //document.getElementsByClassName('buttons');

const d1 = document.querySelector('#d1 > .buttons li'); //자식선택자 찾음

btn1.addEventListener('click',function(){
    console.log('btn1');
})

for(let b of buttons){
    b.addEventListener('click',function(){
        console.log("buttons"); 
    })
}