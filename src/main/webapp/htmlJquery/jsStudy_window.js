const btn1=document.getElementById('btn1');

btn1.addEventListener('click',function(){
   // window.open("./new.html", 'test', 'width=200,height=100,top=100, left=200');
    clearInterval(st);
})

let st = setInterval(function(){
    console.log('Interval')
},1000)

//setTimeout
setTimeout(function(){
    alert('timeout')
},1000);