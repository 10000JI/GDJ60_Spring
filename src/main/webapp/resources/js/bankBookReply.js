//const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
//const commentListResult = document.getElementById("commentListResult");
//const pageLink = document.querySelectorAll(".page-link");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal = document.getElementById('closeModal')

//댓글 등록
$("#replyAdd").click(function(){
    //JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData(); // <form></form>
    form.append("contents", $("#replyContents").val()); //<form><input type="text" name="contents" value="dfds"></form>
    form.append("bookNum", $('#replyAdd').attr('data-book-bookNum'))//<form><input type="text" name="bookNum" value="12"></form>

    //이벤트는 작동되는데 전송이 안되는 경우는 fetch 검사
    fetch('../bankBookComment/add', {
        method:'POST',
       // headers:{'Content-type':"application/x-www-form-urlencoded"},
        body: form,
    }).then((response)=> response.text())
    .then((res)=>{
        if(res.trim()==1){ 
            alert('댓글이 등록 되었습니다')
            $("#replyContents").val("");
            getList(1);            
        }else {
            alert('댓글 등록에 실패 했습니다')
        }
    })
     .catch(()=>{
         console.log('error 발생');
     });


})

//bookNum으로 댓글목록
getList(1);
function getList(page){

    fetch("/bankBookComment/list?bookNum="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page, {
        method:'GET'
        //GET 과 HEAD 메서드는 body속성을 가질 수 없음
    })
    .then((response)=>response.text())
    .then((res)=>{
        $("#commentListResult").html(res.trim());
    })

}

//page요청할 수 있도록 만든 이벤트
$("#commentListResult").on("click",'.page-link',function(e){
    let page = $(this).attr('data-board-page');
    getList(page);
    e.preventDefault();
})

// delete
$("#commentListResult").on('click','.del',function(e){

    fetch("../bankBookComment/delete", {
        method:'POST',
         headers:{
             "Content-type":"application/x-www-form-urlencoded"
         },
         body:"num="+$(this).attr("data-comment-num")
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
           .catch(()=>{
              alert('에러 발생');
           });

    e.preventDefault();
    }
)

// update버튼 클릭 후 데이터를 넣고 담아 모달창 불러오기
$("#commentListResult").on('click',".update",function(e){
        //console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = $(this).attr("data-comment-num");
        $("#contents").val($("#contents"+num).text());

        $("#contentsConfirm").attr("data-comment-num",num);
    e.preventDefault();
})

// modal에서 확인버튼과 cancel버튼 눌렀을 때 동작
$("#contentsConfirm").click(function(){
    console.log('Update Post');

    fetch('../bankBookComment/update', {
        method:'POST',
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body: "num="+$(this).attr("data-comment-num")+"&contents="+$("#contents").val()
    }).then( (response) => response.text())
      .then( (res) => {
        if(res.trim()>0){
            alert('수정 성공');
            $("#closeModal").click();
            getList(1);            
        }else {
            alert('수정 실패');
        }
      })
       .catch(()=>{
         alert('관리자에게 문의 하세요');
       })


})


// Test 후 삭제할 영역
    //1. 선택
    //const b1 = document.getElementById("b1");
    //const b1 = document.querySelector("#b1");
    //b1.addEventListener('click', function(){})
    //document.getElementById("t1").value
    //Jquery
    
    // $('#b1').click(()=>{
    //     let v =$('#t1').val();
    //     console.log(v);
    // });

    // $('#t1').blur(()=>{
    //     console.log("blur");
    // })

    $("#t1").on({
        click:function(){
            console.log("t1 click");
        },
        blur:()=>{
            console.log("t1 blur");
        }
    });

    $('#b1').on("click", function(){})

    $('#commentResult').on('click',".update",function(){})

    // const ch = document.getElementsByClassName('ch');
    // for(let c of ch){
    //     c.addEventListener('click', function(){
    //     })
    // }

    /* 어떤함수의 this를 쓰냐에 따라 사용법이 달라짐 */
    /* 화살표 함수 사용 시에는 this로 엘리먼트를 가져오지 못한다*/
    /* 반면에 콜백함수 function 사용 시에는 this로 엘리먼트 가져올 수 있다 */
    // $(".ch").click(function(e){
    //     console.log("E:",e);
    //     console.log(this);
    //     console.log($(this).val());
    // })

    /* 따라서 화살표 함수로 클릭했을 때 해당 엘리먼트를 가져오고 싶다면 target을 사용 */
    $(".ch").click((e)=>{
        console.log("E:",e);
        console.log(e.target);
        console.log($(e.target).val());
    })
//////////////////////