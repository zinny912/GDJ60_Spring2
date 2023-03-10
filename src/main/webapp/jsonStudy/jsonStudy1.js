
$("#btn").click(()=>{

    let productId= $("#productId").val();


    $.get("https://dummyjson.com/products/"+productId, (response)=>{
      console.log(response);
      console.log(response.title);
    });
})

$.get("https://dummyjson.com/products/", (response)=>{
    console.log(response.products.length);
    
    // response.products.forEach(function(item, index){
    //     console.log(index, item);
    // })
    //let result="";
    for(let item of response.products){
         console.log(item);
        let result = '<div class="card" style="width: 18rem;">';
        result = result + '<img src="'+item.thumbnail+'" class="card-img-top" alt="...">';
        result = result + '<div class="card-body">';
        result = result + '<h5 class="card-title">'+item.title+'</h5>';
        result = result + '<p class="card-text">'+item.description+'</p>';
        result = result + '<a href="#" class="btn btn-primary detail" date-productId="'+item.id+'">'+item.price+'</a>'
        result = result + '</div></div>';
        $('#productList').append(result);
    }

   // $("#productList").html(result);


});

//Jquery로 
// let result = '<div class="card" style="width: 18rem;">';
// result = result + '<img src="..." class="card-img-top" alt="...">';
// result = result + '<div class="card-body">';
// result = result + '<h5 class="card-title">Card title</h5>';
// result = result + '<p class="card-text">Some quick example text to build on the card title and make up the bulk of the cards content.</p>';
// result = result + '<a href="#" class="btn btn-primary">Go somewhere</a>'
// result = result + '</div></div>';

$("#productList").on("click",".detail", function(e){
    console.log("ID:", $(this).attr("data-proudctId"))
    $.get("https://dummyjson.com/products/", $(this).attr(), function(){
        console.log(response);
        console.log(response.title);
      });
    e.preventDefault();
})