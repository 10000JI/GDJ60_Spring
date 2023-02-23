const pl = document.getElementsByClassName('page-link');
const searchForm = document.getElementById('searchForm');
const page = document.getElementById('page');

//for
//for of --for(꺼낸타입명 변수명: Collection)

for(let p of pl){
    p.addEventListener('click',function(e){
        let v = p.getAttribute('data-board-page');
        page.value=v;
        searchForm.submit();
    })
}

let data='';
function setData(d){
    data=d;
}
//js에서 EL을 사용할 수 없으므로 함수를 사용해
//JSP에 있는 데이터를 가져올 수 있다.