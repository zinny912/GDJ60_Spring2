const add=document.getElementById("add");
const list=document.getElementById("list");

add.addEventListener('click', function(){
    //'<li>d</li>'
    //<li><button>click</button></li>
    let li=document.createElement('li');
    let button = document.createElement("button");
    let text = document.createTextNode('click');
    let attr = document.createAttribute("class");
    attr.value= 'btn'; //'btn bg';
    attr.value=attr.value+ " bg";

   // attr.value ="bg";

    button.setAttributeNode(attr);
    
   li.appendChild(button);
   button.appendChild(text);
   
  // list.append(li);
   // list.prepend(li);
    list.before(li);

})
