//css선택자 유형
const btn1 = document.querySelector("#btn1");
//const btn1 = document.getElementById("btn1");

//querySelector 는 querySelectorAll[0]과 같음
//querySelector == querySelectorAll[0];

//const buttons = document.getElementsByClassName('buttons');
const buttons = document.querySelectorAll(".buttons");
//const buttons = document.getElementsByClassName("buttons");


const d1 = document.querySelector("#d1 > .buttons li")

let ar = [1,2,3];

console.log('Old')
for(let i=0; i<ar.length; i++){
    console.log(ar[i]);
}

console.log('For of');
for(let a of ar){
    console.log(a);
}

console.log('For in');
for(let j in ar){
    console.log(j);
    console.log(ar[j]);
}

console.log('Foreach');
ar.forEach(function(v, i, list){
    console.log('v:',v,'i:',i,'ar:',list);
});

//---------------------------------------------------------
btn1.addEventListener("click",function(){
    console.log("버튼클릭");

})
// for(let b of buttons){
//     b.addEventListener("click", function(){
//         console.log("버튼클릭릭")
//     })
// }

//alert(buttons);
//alert(ar);
console.log(buttons);
console.log(ar);

//const buttons = document.getElementByClassName 
//실제배열이 아니라 forEach가 적용이 안됨
//const buttons = document.querySelectAll
//Nodelist로 배열생성이 됨 - 버튼클릭됨
buttons.forEach(function(v,i){
    v.addEventListener('click', function(){
        console.log('click');
    })    
})    


console.log(parseInt('1')+1);
console.log('1'-1+1);

// 내가
// for(let i=0; i<buttons.length; i++){
//     buttons[i].addEventListener("click", function(){
//        console.log("버튼클릭"+i);
    
//     })
// }