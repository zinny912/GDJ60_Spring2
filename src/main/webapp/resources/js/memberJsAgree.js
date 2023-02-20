const checkAll = document.getElementById("checkAll"); 
const checks = document.getElementsByClassName("checks"); //배열


checkAll.addEventListener("click", function(){
    for(let i=0; i<checks.length; i++){
        checks[i].checked=checkAll.checked;
    }    
});

for(let i=0; i<checks.length; i++){
    checks[i].addEventListener("click", function(){
        let result = true;
        for(let j=0; j<checks.length; j++){
            if(!checks[j].checked){//==false)
                //result = checks[j].checked;
                //result=false;
                result=!result;
                break;
            }
        }  
        
        checkAll.checked=result;
    }); 
}
const agree = document.getElementById("agree"); 
const al = '약관에 동의해야 가입가능요';
const all = '전부동의하셨습니다';

agree.addEventListener("click", function(){
    if(checkAll.checked){
        alert(all);
        location.href="localhost/member/memberAdd";

    } else{
        alert(al);
    }
})



    