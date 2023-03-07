const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
//const pageLink = document.querySelectorAll(".page-link");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal = document.getElementById('closeModal')

replyAdd.addEventListener("click",function(){
    console.log("num : ", replyAdd.getAttribute('data-book-bookNum'));

    //JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData(); // <form></form>
    form.append("contents", replyContents.value); //<form><input type="text" name="contents" value="dfds"></form>
    form.append("bookNum", replyAdd.getAttribute('data-book-bookNum'))//<form><input type="text" name="bookNum" value="12"></form>


    fetch('../bankBookComment/add', {
        method:'POST',
       // headers:{'Content-type':"application/x-www-form-urlencoded"},
        body: form,
    }).then((response)=> response.st)
    .then((res)=>{
        if(res.trim()==1){
            alert('댓글이 등록 되었습니다')
            replyContents.value="";
            getList(1);            
        }else {
            alert('댓글 등록에 실패 했습니다')
        }
    }).catch(()=>{
        console.log('error 발생');
    });


    // let xhttp = new XMLHttpRequest();

    // //URL, Method 정보
    // xhttp.open("POST","../bankBookComment/add");
 
    // //header 정보
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // //요청 발생 POST일 경우 parameter 전송
    // xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));
 
    // //응답 처리
    // xhttp.addEventListener("readystatechange", function(){
    //     if(this.readyState==4 && this.status==200){
    //         if(this.responseText.trim()==1){
    //             alert('댓글이 등록 되었습니다.')
    //             replyContents.value="";
    //             getList(1);
    //         }else {
    //             alert('댓글 등록에 실패하였습니다.')
    //         }
    //     }
    //  })
})

//bookNum으로 댓글목록
getList(1);
function getList(page){

    let count = 0;

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page)

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            commentListResult.innerHTML = this.responseText.trim();
            count ++;
        }
    })
    
    //0이 출력 : 비동기 방식이기 때문에
    console.log("count :"+count);
}

//page요청할 수 있도록 만든 이벤트
commentListResult.addEventListener("click",function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute('data-board-page');
        getList(page);
    }

    e.preventDefault();

})

// delete
commentListResult.addEventListener('click',function(e){

    let del = e.target;
    if(del.classList.contains("del")){
        fetch("../bankBookComment/delete", {
            method:'POST',
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body:"num="+del.getAttribute("data-comment-num")
            //응답객체에서 Data 추출
        }).then((response)=>{return response.text()}) //then(function(response){return response.text()})   
            //추출한 Data 사용
          .then((res)=>{
            if(res.trim()>0){
                alert('댓글이 삭제 되었습니다');
                getList(1);
            }else {
                alert('삭제 실패');
            }
          })
        //   .catch(()=>{
        //         alert('에러 발생');
        //   });



    // let deleteButton = e.target;
    // if(deleteButton.classList.contains("del")){
    //     let xhttp = new XMLHttpRequest();
    //     xhttp.open("POST", "../bankBookComment/delete");
    //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("num="+deleteButton.getAttribute("data-comment-num"))
    //     xhttp.addEventListener("readystatechange", function(){
    //         if(this.readyState==4 && this.status==200){
    //            let result = this.responseText.trim();
    //            if(result==1){
    //             alert("댓글이 삭제 되었습니다.");
    //             getList(1);
    //            } else{
    //             alert("삭제 실패");
    //            }
    //         }
    //     })

    }
    e.preventDefault();
})

// update버튼 클릭 후 데이터를 넣고 담아 모달창 불러오기
commentListResult.addEventListener('click',function(e){
    let updateButton = e.target;
    if(updateButton.classList.contains("update")){
        //console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = updateButton.getAttribute("data-comment-num");
        let contents = document.getElementById('contents'+num); //td
        console.log(contents);
        let contentsTextArea= document.getElementById("contents") //Modal textArea
        contentsTextArea.innerText = contents.innerText;
        contentsConfirm.setAttribute("data-comment-num",num);

    }
    e.preventDefault();
})

// modal에서 확인버튼과 cancel버튼 눌렀을 때 동작
contentsConfirm.addEventListener("click", function(){
    console.log('Update Post');

    let updateContents = document.getElementById("contents").value;
    let num = contentsConfirm.getAttribute("data-comment-num");

    fetch('../bankBookComment/update', {
        method:'POST',
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body: "num="+num+"&contents="+updateContents
    }).then( (response) => response.text())
      .then( (res) => {
        if(res.trim()>0){
            alert('수정 성공');
            closeModal.click();
            getList(1);            
        }else {
            alert('수정 실패');
        }
      })
      .catch(()=>{
        alert('관리자에게 문의 하세요');
      })


    // let updateContents = document.getElementById("contents").value;
    // let num = contentsConfirm.getㄴAttribute('data-comment-num');
    // let xhttp = new XMLHttpRequest();
    // xhttp.open("POST", "../bankBookComment/update");
    //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("num="+num+"&contents="+updateContents)
    //     xhttp.addEventListener("readystatechange", function(){
    //         if(this.readyState==4 && this.status==200){
    //            let result = this.responseText.trim();
    //            if(result==1){
    //             alert("수정 성공");
    //             closeModal.click();
    //             getList(1);
    //            } else{
    //             alert("수정 실패");
    //            }
    //         }
    //     })
})