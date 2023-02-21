const d1 = document.getElementById("d1");
const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");
const input3 = document.getElementById("input3");
const btn = document.getElementById("btn");

d1.addEventListener("click",function(){
    console.log("Click Event");
})

d1.addEventListener("mouseenter",function(){
    console.log("MouseEnter Event");
})

input1.addEventListener("keyup", function(){
    console.log("Keyup Event");
})

input2.addEventListener("focus", function(){
    console.log("focus Event");
})

input2.addEventListener("blur", function(){
    console.log("blur Event");
})

input2.addEventListener("change", function(){
    console.log("change Event");
})

//제일 많이 사용
input3.addEventListener("change", function(){
    console.log(input3.value);
})//, true) 영역 겹칠 경우 대비하여...?

btn.onclick=function(){
    input2.focus();
}