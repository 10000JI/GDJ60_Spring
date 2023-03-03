
//객체 생성
let xhttp = new XMLHttpRequest();

//메소드의 형식과 url 정보 담음
xhttp.open("GET","/notice/listTop");

//보낼건데, 파라미터로 넘길게 없으므로 매개변수x
xhttp.send();

//이벤트 발생
//상태가 변할 때마다 {}실행
xhttp.addEventListener('readystatechange', function(){
    if(this.readyState==4 && this.status==200){
        console.log(this.responseText);
        document.getElementById("noticeList").innerHTML = this.responseText.trim();
    }

});
