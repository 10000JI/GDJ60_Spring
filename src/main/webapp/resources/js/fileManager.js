//FileManager.js
const fileList = document.getElementById('fileList');
const fileAdd = document.getElementById('fileAdd');
let count = 0;
let max = 1;
let param='pic';

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}

console.log("test")

fileAdd.addEventListener('click',function(){

    if(count>=max){
        alert('첨부 파일은 최대'+max+'개까지 입니다.')
        return;
    }

    count++;

    //element 생성
    let div = document.createElement('div'); //부모 div
    let label = document.createElement('label'); //lable
    let input = document.createElement('input'); //input
   
    //element 조합
    div.appendChild(label);
    div.appendChild(input);
    
    //attribute 생성 및 적용
    //div
    let attr = document.createAttribute('class');
    attr.value="mb-3";
    div.setAttributeNode(attr);
    
    //attribute 생성 및 적용
    //label
    attr = document.createAttribute('class');
    attr.value="form-label";
    label.setAttributeNode(attr);
    attr = document.createAttribute('for');
    attr.value="files";
    label.setAttributeNode(attr);
    //label의 컨텐츠 추가 및 적용
    let text = document.createTextNode("이미지");
    //element 조합
    label.appendChild(text);
    
    
    //attribute 생성 및 적용
    //input
    attr = document.createAttribute('type');    
    attr.value="file";
    input.setAttributeNode(attr);
    attr = document.createAttribute('class');   
    attr.value="form-control"
    input.setAttributeNode(attr);
    attr = document.createAttribute('id');
    attr.value="files"
    input.setAttributeNode(attr);
    attr = document.createAttribute('name');
    attr.value=param;
    input.setAttributeNode(attr);

    fileList.prepend(div);

})

