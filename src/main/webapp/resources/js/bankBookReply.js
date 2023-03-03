const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");

replyAdd.addEventListener("click",function(){
    let xhttp = new XMLHttpRequest();

    //URL, Method 정보
    xhttp.open("POST","../bankBookComment/add");
 
    //header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //요청 발생 POST일 경우 parameter 전송
    xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));
 
    //응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            if(this.responseText.trim()==1){
                alert('댓글이 등록 되었습니다.')
                replyContents.value="";
                getList();
            }else {
                alert('댓글 등록에 실패하였습니다.')
            }
        }
     })
})

getList();

function getList(){
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum'))

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            commentListResult.innerHTML = this.responseText.trim();
        }
    })
}