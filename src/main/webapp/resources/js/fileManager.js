//FileManger.js


const fileAdd = document.getElementById("fileAdd");
const fileList = document.getElementById("fileList");

let count=0;
let max=5;
let param='pic';
let idx = 0;

function setCount(c){
    count =c;
}

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}

//delete
$(".deleteCheck").click(function(){
    let result = confirm('파일이 영구 삭제 됩니다.');
    let ch = $(this)
    if(result){
        let fileNum = $(this).val();
        $.ajax({
            type:'POST',
            url:'./boardFileDelete',
            data:{
                fileNum:fileNum
            },
            success:function(response){
                if(response.trim() > 0){
                    alert("삭제되었습니다");
                    //this: ajax객체 자기 자신
                    console.log($(ch))
                    ch.parent().parent().remove();
                    count --;
                }else{
                    alert("삭제 실패<br> 관리자에게 문의하세요");
                }
            },
            error:function(){
            }
        });
    }else {
        $(this).prop('checked',false);
    }
});
            
            
           
//ajax DB에서 삭제

//1. fetch get
// fetch("URL?p=1", {
//     method:'GET'
// }).then((Response)=> Response.text())
// .then((res)=>{
    //   //  
    // })

    //1. jquery GET
    // $.get("URL?p=1",function(Response){
//     //
// })

//2. fetch POST
// fetch("URL",{
    //     method : 'POST',
//     headers : {
    //         'Contents-Type' : 'X......'
    //     }
    //     body : "p=1"
    // }).then((Response)=> Response.text())
// .then((res)=>{
    //   //  
    // })
    
//1. jquery POST            
//$.post("URL", {p:1}, function(res){
    //    //
    //})
    
    

//     }
// }else{
//     if(count==5){
//         console.log("idx : ",idx);
//         idx--;
//         $("#f"+(idx)).remove();
//         return;
//     }
//     count++;
// });



$("#fileList").on("click",".dels", function(e){
    // let id = $(this).attr("data-dels-id");
    // $("#"+id).remove();
    $(this).parent().remove();
    count--;
});



//function(){} : ()=>{}
$("#fileAdd").click(()=>{
    if(count>=max){
        alert('첨부파일은 최대'+max+'까지만 가능');
        return;
    }
    count++;

    let child = '<div class="input-group mb-3" id="f'+idx+'">';
        child = child+ '<input type="file" class="form-control" name="'+param+'">';
        child = child+ '<button type="button" class="btn btn-outline-danger dels" data-dels-id="f'+idx+'">X</button>'
        child = child+ '</div>'

    $("#fileList").append(child);

    idx++;
});


// fileList.addEventListener("click", function(e){
//    if (e.target.classList.contains('dels')){
//       e.target.parentNode.remove();
//         // let id = e.target.getAttribute('data-dels-id');
//         // document.getElementById(id).remove();
//     count--;
//    }
// });



// fileAdd.addEventListener("click", function(){

//     if(count>=max){
//         alert('첨부파일은 최대 '+max+ ' 까지만 가능');
//         return;
//     }

//     count++;

//     //Element, Text 들을 생성
//     let d = document.createElement('div');// 부모 DIV
//    // let l = document.createElement('label');//label
//    // let t = document.createTextNode('file');
//     let i = document.createElement('input');//input
//     let b = document.createElement('button');//button 
//     //let x = document.createTextNode('X');

    
    
//     //Element들을 조합
//    // d.appendChild(l);
//     d.appendChild(i);
//     d.appendChild(b);
//    // l.appendChild(t);
//    // b.appendChild(x);
    
    
//     //attribute 생성 적용
//     //div
//     let attr = document.createAttribute("class");
//     attr.value='input-group mb-3';
//     d.setAttributeNode(attr);
   
    
//     //file추가할때마다 idx 1씩 증가
//     attr = document.createAttribute("id");
//     attr.value = 'f'+idx;
//     d.setAttributeNode(attr);
    
    
//     //label
//    // attr = document.createAttribute("class");
//    //  attr.value='form-control';
//    // l.setAttributeNode(attr);
    
//    //  attr = document.createAttribute("for");
//    // attr.value='files';
//    // l.setAttributeNode(attr);
    
//     //input
//     attr = document.createAttribute("type");
//     attr.value="file";
//     i.setAttributeNode(attr);
    
//     attr = document.createAttribute("class");
//     attr.value='form-control';
//     i.setAttributeNode(attr);
    
//     attr = document.createAttribute("id");
//     attr.value='files';
//     i.setAttributeNode(attr);
    
//     attr = document.createAttribute("name");
//     attr.value=param;
//     i.setAttributeNode(attr);
    
       
    
//     attr=document.createAttribute("type");
//     attr.value = 'button';
//     b.setAttributeNode(attr);
    
//     attr= document.createAttribute("class");
//     attr.value = 'btn btn-outline-danger dels';
//     b.setAttributeNode(attr);
//     attr=document.createTextNode("X");
//     b.appendChild(attr);

    
//     attr = document.createAttribute("data-dels-id");
//     attr.value = 'f'+idx;
//     b.setAttributeNode(attr);

//     idx++;

    
    
//     fileList.prepend(d);
    
    
// });
