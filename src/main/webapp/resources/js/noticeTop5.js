   
    let xhttp = new XMLHttpRequest();

    xhttp.open('GET', '/notice/listTop');

    //내부 백그라운드에서 요청을 보내는 
    xhttp.send();

    //4WAY HandsShake

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);
            document.getElementById("noticeList").innerHTML=this.responseText.trim();
        }

    });
