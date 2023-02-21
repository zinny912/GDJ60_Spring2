const d1 = document.getElementById("d1");


//전역변수
let n ='iu';
var old = 'iu';

//function 선언 명명함수
function f1 (){
    console.log("function Test");
    console.log(n);
    var old = 'winter';
}

//매개변수가 있는 function
//매개변수 선언시 let, const 는 생략해야함
function f2 (/*let*/ n1, /*let*/ n2){
    //지역변수
    let name='iu';
    return n1+n2;
}


//function 호출
f1();
let result=f2(1,2);
console.log(result);
console.log(name);
//console.log(n1);
console.log("old : "+old);

//callback 함수용으로 사용 : 익명함수
//익명함수/ 변수는 함수도 담을 수 있다
let fun = function (){
    console.log('익명함수');
    return 1;
}

fun(); 

//매개변수로 함수도 받을 수 있다 / 함수를 매개변수로 넣을 때는 변수명으로
function f3 (f){
    console.log("f3 : ",f,1);
}

function callback1 (){
    console.log("CollBack1");
}

function callback2 (){
    console.log("CollBack2");
}

//다른 곳에서도 같은 함수를 사용하려할 때
//d1.addEventListener("click", callback1);
//d1.addEventListener("click", callback2);

//여기에서만 사용하는 함수
d1.addEventListener("click",function(){
    callback1();
    callback2();
});

let callback2= function(){
    callback2;
}