//FileManager.js
//const fileList = document.getElementById('fileList');
//const fileAdd = document.getElementById('fileAdd');
let count = 0;
let max = 1;
let param='pic';
let idx =0;

function setCount(c){
   count = c; 
}

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}


console.log("test")

$("#fileList").on("click",".dels",function(e){
    // let id = $(this).attr('data-dels-id');
    // $("#"+id).remove();
    $(this).parent().remove();
    count --;
})

// fileList.addEventListener('click',function(e){
//     if(e.target.classList.contains('dels')){
//         //상대선택자
//         console.log(e.target.parentNode)
//         e.target.parentNode.remove();

//         // let id = e.target.getAttribute('data-dels-id')
//         // document.getElementById(id).remove(); //부모 삭제될때 자식까지 삭제 된다
//         // console.log("delete:"+id);
//         count--; //지우면 count도 줄여준다 (최대 첨부파일 수)
//     }

// })

//화살표함수 function(){} : ()=>{}
//Jquery로 javascript 작업 대신 짧게 해줬다
$("#fileAdd").click(()=>{
    if(count>=max){
         alert('첨부 파일은 최대'+max+'개까지 입니다.')
         //return 만나면 종료
         return;
     }

     count++;

    let child  = '<div class="input-group mb-3", id="f'+idx+'">';
        child =child+ '<input type="file" class="form-control" name="'+param+'">'
        child =child+ '<button type="button" class="btn btn-outline-danger dels" data-dels-id="f'+idx+'">X</button>'
        child = child + '</div>'
    $("#fileList").append(child);

    idx++;
});

$(".deleteCheck").click(function(){
    let result = confirm('파일이 영구 삭제 됩니다.')
    let ch = $(this)
    if(result){
        let fileNum = $(this).val();
        $.ajax({
            type:'POST',
            url: './boardFileDelete',
            data:{
                fileNum: fileNum
            },
            success:function(response){
                if(response.trim() > 0){
                    alert("삭제되었습니다");
                    //this: ajax객체 자기 자신
                    console.log($(ch))
                    ch.parent().parent().remove();
                    count --;
                }else{
                    alert("삭제 실패<br> 관리자에게 문의하세요")
                }
            },
            error:function(){

            }
        })

        //ajax DB에서 삭제
        
        //fetch : GET
        // fetch("URL?p=1", {
        //     method: 'GET'
        // }).then((response)=>response.text())
        // .then((res)=>{
        //     //
        // })

        //Jquery Ajax : GET
        // $.get("URL?p=1",function(response){
        //     //
        // })

        //--------------------
        
        //fetch : POST
        // fetch("URL",{
        //     method='POST',
        //     headers:{
        //         'Conents-Type':'X,,,'
        //     },
        //     body: "p=1"
        // }).then((response)=>response.text())
        // .then((res)=>{
            
        // })

        //Jquery Ajax : POST
        //$.post("URL",{p:1}, function(res){})


    }else {
        $(this).prop('checked',false)
    }

})


// fileAdd.addEventListener('click',function(){

//     if(count>=max){
//         alert('첨부 파일은 최대'+max+'개까지 입니다.')
//         return;
//     }

//     count++;

//     //element 생성
//     let div = document.createElement('div'); //부모 div
//    // let label = document.createElement('label'); //lable
//     let input = document.createElement('input'); //input
//     let button = document.createElement('button'); //button
    
//     //element 조합
//     //div.appendChild(label);
//     div.appendChild(input);
//     div.appendChild(button);
    
//     //attribute 생성 및 적용
//     //div
//     let attr = document.createAttribute('class');
//     attr.value="input-group mb-3";
//     div.setAttributeNode(attr);

//     //div(부모)의 dels target 으로 받아온 후, id까지 설정(인덱스로 받아옴)
//     attr = document.createAttribute('id');
//     attr.value="f"+idx;
//     div.setAttributeNode(attr);

 
//     //attribute 생성 및 적용
//     //label
//     //attr = document.createAttribute('class');
//     //attr.value="form-label";
//     //label.setAttributeNode(attr);
//     //attr = document.createAttribute('for');
//     //attr.value="files";
//     //label.setAttributeNode(attr);
//     //label의 컨텐츠 추가 및 적용
//     // let text = document.createTextNode("이미지");
//     //element 조합
//     //label.appendChild(text);
    
    
//     //attribute 생성 및 적용
//     //input
//     attr = document.createAttribute('type');    
//     attr.value="file";
//     input.setAttributeNode(attr);
//     attr = document.createAttribute('class');   
//     attr.value="form-control"
//     input.setAttributeNode(attr);
//     attr = document.createAttribute('id');
//     attr.value="files"
//     input.setAttributeNode(attr);
//     attr = document.createAttribute('name');
//     attr.value=param;
//     input.setAttributeNode(attr);

//     //button
//     attr = document.createAttribute('type');
//     attr.value='button';
//     button.setAttributeNode(attr);
//     attr = document.createAttribute('class');   
//     attr.value="btn btn-outline-danger dels"
//     button.setAttributeNode(attr);
//     attr = document.createTextNode("X")
//     button.appendChild(attr);

//     //div(부모)의 dels target 으로 받아온 후, 자식의 id도 설정(인덱스로 받아옴)
//     attr = document.createAttribute('data-dels-id');
//     attr.value = 'f'+idx;
//     button.setAttributeNode(attr);
//     idx++;

//     fileList.prepend(div);

// })
