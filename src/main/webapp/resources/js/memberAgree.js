const checkAll = document.getElementById("checkAll")
const checks = document.getElementsByClassName("checks")
const agree = document.getElementById("agree")


checkAll.addEventListener("click",function(){
    for(let i=0;i<checks.length;i++){
        checks[i].checked=checkAll.checked;
    }
});

for(let i=0;i<checks.length;i++){
    checks[i].addEventListener("click", function(){
        //for문을 중간에 종료하기 위해 boolean 타입 사용
        let result = true;
        for(let j=0;j<checks.length;j++){
            if(!checks[j].checked){
                //result = checks[j].checked
                //result = false;
                result = !result;
                break;
            }
        }
        checkAll.checked=result;
    })
};

agree.addEventListener("click", function(){
    if(checkAll.checked){
       //alert('모두 동의함'); 
        location.href="./memberJoin"
    } else {
        alert('모든 약관에 동의해야 합니다.')
    }
})

