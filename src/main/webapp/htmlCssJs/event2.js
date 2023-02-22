const b1 = document.getElementById("b1"); //button
const p1 = document.getElementById("p1"); //div

const b2 = document.getElementById("b2"); //button
const p2 = document.getElementById("p2"); //div

const naver = document.getElementById("naver");// a 태그


naver.addEventListener('click', function(event){
    console.log("Naver Click");
   // event.preventDefault();
   return false;
});

//캡쳐링과 중단
b1.addEventListener('click',function(e){
    console.log('Button Click');
    console.log(e)
}, true);

p1.addEventListener('click', function(event){
    console.log('Div Click');
    console.log(event);
    event.stopPropagation();
}, true);

//버블링과 중단
b2.addEventListener('click',function(e){
    console.log('Button2 Click');
    console.log(e)
   // e.stopPropagation();
   console.log("Button This : ", this);
}, false);

p2.addEventListener('click', function(event){
    console.log('Div2 Click');
    console.log(event);
    console.log("CurrentTarget: ", event.currentTarget);
    console.log("Target : ", event.target);
    console.log("This :",this);
}, false);

