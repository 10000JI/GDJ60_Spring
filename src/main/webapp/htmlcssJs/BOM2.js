const btn = document.getElementById("btn");
//row 갯수
let r1 = document.getElementById("r1");
//column의 갯수
let c1 = document.getElementById("c1");

let table = document.getElementById("table");

const s1 = document.getElementById("s1");

const c2 = document.getElementById("c2");

//배열로 생각
const options = document.getElementsByClassName("options");
//아이디는 중복이 되지 않지만, 클래스명은 중복 가능하므로 Elemnts라고 함수에 명시

const radios = document.getElementsByClassName("radios");

const ch = document.getElementsByClassName("ch");


for(let i=0;i<ch.length;i++){
    ch[i].addEventListener("click",function(){
        console.log(this.checked); 
        for(let j=0;j<ch.length;j++){
            ch[j].checked=this.checked;
        } 
    })
}


ch.addEventListener("click",function(){
    console.log("CLICK");  
})

c2.addEventListener("click",function(){
    for(let i=0;i<radios.length;i++){
        if(radios[i].checked){
            console.log(radios[i].value)
            break;
        }
    }

})

s1.addEventListener("click",function(){
    for(let i=0;i<options.length;i++){
        if(options[i].selected){
            console.log(options[i].value)
            break;
        }
    }
});

btn.addEventListener("click", function(){
    console.log(r1.value);
    console.log(c1.value);

    let result='';

    for(let i=0;i<r1.value;i++){
        result = result+'<tr>';
        for(let j=0;j<c1.value;j++){
            result = result+'<td></td>';
        }
        result = result+'</tr>';
    }

    table.innerHTML = result;
});