const b1 = document.getElementById("b1");//버튼
const p1 = document.getElementById("p1");//div태그

const b2 = document.getElementById("b2");//버튼
const p2 = document.getElementById("p2");//div태그

const naver = document.getElementById("naver");//a태그

naver.addEventListener('click', function(event){
    console.log("Naver Click");
    //event.preventDefault();
    return false;
})

//캡처링과 중단
b1.addEventListener('click',function(e){
   console.log('BUTTON Click');
   console.log(e) 
}, true)

p1.addEventListener('click',function(event){
    console.log('Div Click');
    console.log(event);
    event.stopPropagation();
},true)

//버블링과 중단
b2.addEventListener('click',function(e){
   console.log('BUTTON Click');
   console.log(e)
   //e.stopPropagation();
   console.log("Button This:",this);
}, false)

p2.addEventListener('click',function(event){
    console.log('Div Click');
    console.log(event);
    console.log('CurrentTarget: ', event.currentTarget);
    console.log('Target :', event.target);
    console.log('This :',this);
},false)
