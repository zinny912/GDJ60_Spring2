
//댓글등록 NEW버전 요즘 방식
$("#replyAdd").click(function(){
   
    //JS에서 사용할 가상의 Form태그 생성
    const form1 = new FormData(); //<form></form>
    form1.append("contents",$("#replyContents").val()); 
    // <form><input type="text" name="contents" value="aaa"></input></form>
    form1.append("bookNumber",$("#replyAdd").attr("data-book-bookNumber"))
        //<form><input type="text" name="bookNumber" value="bbb"></input></form>

        fetch('../bankBookComment/add',{
            method:'POST',
            //headers:{},
            body:form1,//body: 요청시 전달할 값      
        }).then((response)=> response.text())
        .then((res)=>{
            if(res.trim()==1){
                alert("댓글 등록");
                console.log("등록성공:",res.trim());
                $("#replyContents").val("");
                getList(1);
            }else{
                alert("댓글 등록 실패");
                console.log("등록실패:",res.trim());
            }
        }).catch(()=>{
            console.log("에러발생");
        });
        
});


getList(1);

function getList(page){

    fetch("/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page, {
        method:'GET',
        //GET과 HEAD메서드는 body속성을 가질 수 없음
        }).then((response)=>response.text())
        .then((res)=>{
                    $("#commentListResult").html(res.trim());
            }   
        )
        
};

//page
$("#commentListResult").on("click",".page-link",function(e) {
        let page = $(this).attr("data-board-page");
        getList(page);
        e.preventDefault();    
});



//delete
$("#commentListResult").on("click",".del",function(e){
    fetch("../bankBookComment/delete", {
            method:'POST',
            headers:{
                "Content-type": "application/x-www-form-urlencoded"
            }, 
            body:"num="+$(this).attr("data-comment-num")  
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
                 e.preventDefault();
                                
});
                    

//update-modal
$("#commentListResult").on("click",".update", function(e){
    let num = $(this).attr("data-comment-num");
    $("#contents").val($("contents"+num)).text();//td
    $("#contentsConfirm").attr("data-comment-num", num)
    
    e.preventDefault();

});

$("#contentsConfirm").click(function(){
    fetch("../bankBookComment/update", {
        method: 'POST',
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:"num="+$(this).attr("data-comment-num")+"&contents="+$("#contents").val(),
    }).then((response)=>response.text())
        .then((res)=>{
            if(res.trim()>0){
                alert("댓글수정완료");  
                $("#closeModal").click();
                getList(1);
            }else{
                alert("댓글수정실패");
            }
        }).catch(()=>{
            alert("에러발생");
            })
           
});


