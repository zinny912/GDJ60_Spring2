const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("replyList");

replyAdd.addEventListener("click",function(){

    let xhttp= new XMLHttpRequest();

    xhttp.open("POST","../bankBookComment/add");

    xhttp.setRequestHeader("Content-type","application/x-www-form-rulencoded");

    xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNumber'));

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            if(this.responseText.trim()==1){
                alert("댓글이 등록 되었습니다.")
                replyContents.vlaue="";
                getList();
            }else{
                alert("댓글등록이 실패")

            }
        }
    })
});

getList();

function getList(){
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET","../bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber'));

    xhttp.send();

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
           commentListResult.innerHTML=this.responseText.trim();
              
        }
    })

}