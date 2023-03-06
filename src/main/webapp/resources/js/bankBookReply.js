const replyAdd = document.getElementById('replyAdd');
const replyContent = document.getElementById('replyContent');
const commentListResult = document.getElementById('commentListResult');
// const pageLink = document.querySelectorAll(".page-Link");
const del = document.getElementsByClassName("del");
const update = document.getElementsByClassName("update");

replyAdd.addEventListener('click', function(){

    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "../bankBookComment/add");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("contents="+replyContent.value+"&bookNumber="+replyAdd.getAttribute("data-book-bookNumber"));

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            if(this.responseText.trim()==1){
                console.log(this.responseText.trim());
                alert("댓글 등록");
                replyContent.value='';
                getList(1);
            }else{
                alert("댓글 등록 실패");
            }
        }
    })
})

getList(1);

function getList(page){
    let count =0;

    let xhttp = new XMLHttpRequest();
    
    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page);

    
    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
            count++;
        }
    })
    
    xhttp.send();
    //0이 출력 : 비동기 방식이기 때문에 
    console.log("count:",count);


}

//nodeList일때 forEach 사용가능 하지만 여기서 의미없음...
// pageLink.forEach(function(){
//     console.log("p:",p);
// })

commentListResult.addEventListener("click",function(e) {
        let pageLink = e.target;
            if(pageLink.classList.contains("page-Link")){
                 let page = pageLink.getAttribute("data-board-page");
                getList(page);
            }
    
        e.preventDefault();    
});



//delete
commentListResult.addEventListener("click",function(e) {
    let del = e.target;
        if(del.classList.contains("del")){
           //console.log("delete");
           let xhttp=new XMLHttpRequest();

           xhttp.open("POST","../bankBookComment/delete");
           xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
           xhttp.send("num="+del.getAttribute("data-comment-num"));

           xhttp.addEventListener('readystatechange', function(){
            if(this.readyState==4&&this.status==200){
                let result = this.responseText.trim();
                if(result>0){
                    alert("댓글삭제완료");
                    getList(1);
                }else{
                    alert("삭제실패");
                }
            }
        })
        }

    e.preventDefault();    
});

//update-modal




//update-teacher
commentListResult.addEventListener("click",function(e){
    let updateButton = e.target;
        if(updateButton.classList.contains("update")){
            //console.log(update.parentNode.previousSibling.previousSibling.previousSibling);
            let num = updateButton.getAttribute("data-comment-num");
            let contents = document.getElementById("contents"+num).querySelector("#contents"+num);
            // console.log(contents);
            // contents.innerHTML='<textarea name="" id="" cols="30" row="3">'+contents.innerHTML+'</textarea>';
            //document.querySelector("#contents"+num).firstChild.removeAttribute("readonly");
            contents.firstChild.removeAttribute("readonly");
            
            let btn = document.createElement("button");
            let attr = document.createAttribute("class");
            attr.value="btn btn-warning";

            btn.setAttributeNode(attr);
            contents.appendChild(btn);

            attr=document.createTextNode("확인");
            btn.appendChild(attr);

            btn.addEventListener("click", function(){
                console.log(contents.firstChild.value);
                console.log(num);

                let xhttp=new XMLHttpRequest();
                xhttp.open("POST", "../bankBookComment/update");
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("num="+num+"&contents="+contents.firstChild.value);
                xhttp.addEventListener('readystatechange', function(){
                        if(this.readyState==4&&this.status==200){
                            if(this.responseText.trim()==1){
                                console.log(this.responseText)
                                alert("댓글 수정 완료");
                                replyContent.value="";
                                getList(1);
                            }else{
                                alert("댓글 수정 실패");
                            }
                        }
            
                    })
        
            });

        }
        e.preventDefault();

    });          

            





//update
// commentListResult.addEventListener("click",function(e){
//     let update = e.target;
//         if(update.classList.contains("update")){
//             let xhttp=new XMLHttpRequest();

//             xhttp.open("POST", "../bankBookComment/update");
//             xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//             xhttp.send("contents="+replyContent.value+"&num="+update.getAttribute("data-comment-nums"));

//             xhttp.addEventListener('readystatechange', function(){
//                 if(this.readyState==4&&this.status==200){
//                     if(this.responseText.trim()==1){
//                         console.log(this.responseText)
//                         alert("댓글 수정 완료");
//                         replyContent.value="";
//                         getList(1);
//                     }else{
//                         alert("댓글 수정 실패");
//                     }
//                 }
//             })
//         }

// })