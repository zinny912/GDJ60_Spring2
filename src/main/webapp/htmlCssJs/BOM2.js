//const btn = document.getElementById("btn");
//let r1 = document.getElementById("r1")

// btn.addEventListener("click", function(){
//     console.log(r1.value*1+5);
// });


// btn.addEventListener("click", function(){
//     let r1 = document.getElementById("r1").value;
//     console.log(r1.value+5);
// });


const ch = document.getElementsByClassName("ch");
for(let i=0; i<ch.length; i++){
    ch[i].addEventListener("click", function(){
        console.log(this.checked);
        for(let j=0; j<ch.length; j++){
            ch[j].checked=this.checked;
        }
    })
}






//radio
const s2 = document.getElementById("s2");
const radios = document.getElementsByClassName("radios");

s2.addEventListener("click",function(){
    for(let i=0; i<radios.length; i++){
        if(radios[i].checked){
            console.log(radios[i].value);
            break;
        }
    }

});

//select 설정하기.
const s1 = document.getElementById("s1");
//배열
const options = document.getElementsByClassName("options");

s1.addEventListener("click", function(){
    for(let i=0; i<options.length; i++){
        //console.log(options[i].value);
        if(options[i].selected){
            console.log(options[i].value);
            break;
        }
    }
});




//테이블 만들기
const btn = document.getElementById("btn");
//row개수
let r1 = document.getElementById("r1");
//col개수
let c1 = document.getElementById("c1");
//
let t1 = document.getElementById("t1");

    btn.addEventListener("click", function(){
    
        let result = '';

        for(let i= 0; i<r1.value; i++) { //tr생성
            result=result+"<tr>";
            for(let j= 0; j<c1.value; j++) {
                result = result + "<td>";
                result = result + "</td>";
            }
            result=result+"</tr>";            
        }
        t1.innerHTML=result;
    });







