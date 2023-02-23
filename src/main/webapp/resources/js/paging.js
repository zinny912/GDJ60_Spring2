const pl = document.getElementsByClassName("page-link");

const searchForm = document.getElementById("searchForm");

const page = document.getElementById("page");

//for 
//for of -- for(꺼낸타입명 변수명 : Collection)

for(let p of pl){
    p.addEventListener('click',function(e){
        //console.log("에붸붸붸베에에에에에에에엥");
      let v = p.getAttribute('data-board-page');
      //console.log(v);
      page.value=v;
      
      searchForm.submit(); //강제발생

    });
};



// for(let i =0; i<pl.length; i++){
//     pl[i].addEventListener('click', function(){
//     };)
// }


