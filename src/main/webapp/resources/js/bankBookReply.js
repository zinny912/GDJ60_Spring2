const replyAdd = document.getElementById('replyAdd');
const replyContents = document.getElementById('replyContents');
const commentListResult = document.getElementById('commentListResult');
// const pageLink = document.querySelectorAll(".page-Link");
const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal');


//댓글등록 NEW버전 요즘 방식
replyAdd.addEventListener('click', function(){
    console.log("num:",replyAdd.getAttribute("data-book-bookNumber"));

    //JS에서 사용할 가상의 Form태그 생성
    const form1 = new FormData(); //<form></form>
    form1.append("contents",replyContents.value); 
    // <form><input type="text" name="contents" value="aaa"></input></form>
    form1.append("bookNumber",replyAdd.getAttribute("data-book-bookNumber"))
        //<form><input type="text" name="bookNumber" value="bbb"></input></form>

        fetch('../bankBookComment/add',{
            method:'POST',
            //headers:{},
            body:form1,//body: 요청시 전달할 값      
        }).then((response)=> response.text())
        .then((res)=>{
            if(res.trim()==1){
                alert("댓글 등록");
                console.log(res.trim());
                replyContents.value='';
                getList(1);
            }else{
                alert("댓글 등록 실패");
                console.log(res.trim());
            }
        }).catch(()=>{
            console.log("에러발생");
        });
});

    //예전방식------------------------------------------------------------------------------------
    // let xhttp = new XMLHttpRequest();
    // xhttp.open("POST", "../bankBookComment/add");
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("contents="+replyContent.value+"&bookNumber="+replyAdd.getAttribute("data-book-bookNumber"));

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4&&this.status==200){
    //         if(this.responseText.trim()==1){
    //             console.log(this.responseText.trim());
    //             alert("댓글 등록");
    //             replyContent.value='';
    //             getList(1);
    //         }else{
    //             alert("댓글 등록 실패");
    //         }
    //     }
    // })---------------------------------------------------------------------------------------------
// })

getList(1);

function getList(page){

    fetch("/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page, {
        method:'GET',
        //GET과 HEAD메서드는 body속성을 가질 수 없음
        }).then((response)=>response.text())
        .then((res)=>{
            
                commentListResult.innerHTML=res.trim();
            }   
        )
};

    // let count =0;
    // let xhttp = new XMLHttpRequest();
   
    // xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page);
    
    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4&&this.status==200){
    //         commentListResult.innerHTML=this.responseText.trim();
    //         count++;
    //     }
    // })
    // xhttp.send();
    // //0이 출력 : 비동기 방식이기 때문에 
    // console.log("count:",count);
    // }

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
commentListResult.addEventListener("click",function(e){
    let del = e.target;
    if(del.classList.contains("del")){
        fetch("../bankBookComment/delete", {
            method:'POST',
            headers:{
                "Content-type": "application/x-www-form-urlencoded"
            }, 
            body:"num="+del.getAttribute("data-comment-num")  
        //응답객체에서 Data 추출 
        }).then((response)=>{return response.text()})  //then(function(response){return response.text()})
            //추출한 Data 사용 
            .then((res)=>{
                if(res.trim()>0){
                    alert("댓글삭제완료");
                    getList(1);
                }else{
                    alert("삭제실패");
                }
            })
                .catch(()=>{   
                    alert("에러 발생");
                    });
}});
                    

//update-modal
commentListResult.addEventListener("click",function(e){
    let updateButton = e.target;
        if(updateButton.classList.contains("update")){
           
            let num = updateButton.getAttribute("data-comment-num");
            let contents = document.getElementById("contents"+num);//td
            let contentsTextArea = document.getElementById("contents");//Modal textarea
           //value
            contentsTextArea.vlaue=contents.innerText;
            contentsConfirm.setAttribute("data-comment-num", num);
        }
        e.preventDefault();

});

contentsConfirm.addEventListener("click",function(){
    console.log("update Post");
    let updateContents = document.getElementById("contents").value;
    let num = contentsConfirm.getAttribute("data-comment-num");

    fetch("../bankBookComment/update", {
        method: 'POST',
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:"num="+num+"&contents="+updateContents,
    }).then((response)=>response.text())
        .then((res)=>{
            if(res.trim()>0){
                alert("댓글수정완료");  
                closeModal.click();
            }else{
                alert("댓글수정실패");
            }
        }).catch(()=>{
            alert("에러발생");
            })
});

    // let xhttp=new XMLHttpRequest();
    //     xhttp.open("POST", "../bankBookComment/update");
    //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("num="+num+"&contents="+updateContents);
    //     xhttp.addEventListener('readystatechange', function(){
    //             if(this.readyState==4&&this.status==200){
    //                 if(this.responseText.trim()==1){
    //                 let result=this.responseText.trim();
    //                 console.log(this.responseText)
    //                     alert("댓글 수정 완료");
    //                     replyContent.value="";
    //                     getList(1);
    //                 }else{
    //                     alert("댓글 수정 실패");
    //                 }
    //             }
    
    //     });
    // });    

    //console.log("delete");
        //    let xhttp=new XMLHttpRequest();

        //    xhttp.open("POST","../bankBookComment/delete");
        //    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        //    xhttp.send("num="+del.getAttribute("data-comment-num"));

        //    xhttp.addEventListener('readystatechange', function(){
        //     if(this.readyState==4&&this.status==200){
        //         let result = this.responseText.trim();
        //         if(result>0){
        //             alert("댓글삭제완료");
        //             getList(1);
        //         }else{
        //             alert("삭제실패");
        //         }
        //     }
        // })
        // }

    // e.preventDefault();    
// });




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




//update-teacher
// commentListResult.addEventListener("click",function(e){
//     let updateButton = e.target;
//         if(updateButton.classList.contains("update")){
//             //console.log(update.parentNode.previousSibling.previousSibling.previousSibling);
//             let num = updateButton.getAttribute("data-comment-num");
//             let contents = document.getElementById("contents"+num).querySelector("#contents"+num);
//             // console.log(contents);
//             // contents.innerHTML='<textarea name="" id="" cols="30" row="3">'+contents.innerHTML+'</textarea>';
//             //document.querySelector("#contents"+num).firstChild.removeAttribute("readonly");
//             contents.firstChild.removeAttribute("readonly");
            
//             let btn = document.createElement("button");
//             let attr = document.createAttribute("class");
//             attr.value="btn btn-warning";

//             btn.setAttributeNode(attr);
//             contents.appendChild(btn);

//             attr=document.createTextNode("확인");
//             btn.appendChild(attr);

//             btn.addEventListener("click", function(){
//                 console.log(contents.firstChild.value);
//                 console.log(num);

//                 let xhttp=new XMLHttpRequest();
//                 xhttp.open("POST", "../bankBookComment/update");
//                 xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//                 xhttp.send("num="+num+"&contents="+contents.firstChild.value);
//                 xhttp.addEventListener('readystatechange', function(){
//                         if(this.readyState==4&&this.status==200){
//                             if(this.responseText.trim()==1){
//                                 console.log(this.responseText)
//                                 alert("댓글 수정 완료");
//                                 replyContent.value="";
//                                 getList(1);
//                             }else{
//                                 alert("댓글 수정 실패");
//                             }
//                         }
            
//                     })
        
//             });

//         }
//         e.preventDefault();

//     });   