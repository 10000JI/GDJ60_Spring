let d1 = document.getElementById("d1");
let input1 = document.getElementById("input1");
let input2 = document.getElementById("input2");
let input3 = document.getElementById("input3");
let btn = document.getElementById("btn");

d1.addEventListener("click", function(){
    console.log("Click");
})

d1.addEventListener("mouseenter", function(){
    console.log("MouseEnter Event");
});

input1.addEventListener("keyup",function(){
    console.log("Keyup Event")
})

input2.addEventListener("focus", function(){
    console.log("focus Event")
})

input2.addEventListener("blur", function(){
    console.log("blur Event")
})

input2.addEventListener("change", function(){
    console.log("change Event")
})

input3.addEventListener("change", function(){
    console.log(input3.value);
});

btn.onclick=function(){
    console.log("test")
    input2.focus();
}
