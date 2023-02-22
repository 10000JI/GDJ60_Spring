const add = document.getElementById('add');
const list = document.getElementById('list');


//add.addEventListener('click',function(){
 //   //<li>d</li>
 //   //<li><button>click</button></li>
 //   let li =document.createElement('li');
 //   let text = document.createTextNode('d');
//  li.appendChild(text);
//
//    list.append(li);
//    list.append(li1);
//});

add.addEventListener('click',function(){
    let li = document.createElement('li');
    let button = document.createElement('button');
    let text = document.createTextNode('click');
    let attr = document.createAttribute('class');
    attr.value='btn'; //'btn bg'
    attr.value = attr.value+' bg';

    button.setAttributeNode(attr);

    button.appendChild(text);
    li.appendChild(button);

    //list.append(li);
    //list.prepend(li);
    //list.before(li);
    list.after(li);
});