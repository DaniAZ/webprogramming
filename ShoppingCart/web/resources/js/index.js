function loadingFunction(){
    $('.Product0 a').on('click',function () {
        let we= $('.Product0 h5').text();
        let po=$('.Product0 p').text();
        addProduct(we,po);
    })
    $('.Product1 a').on('click',function () {
         let we= $('.Product1 h5').text();
         let po=$('.Product1 p').text();
        addProduct(we,po);
    })
    $('.Product2 a').on('click',function () {
        let we= $('.Product2 h5').text();
        let po=$('.Product2 p').text();
        addProduct(we,po);
    })
    $('.Product3 a').on('click',function () {
        let we= $('.Product3 h5').text();
        let po=$('.Product3 p').text();
        addProduct(we,po);
    })
    $('.Product4 a').on('click',function () {
        let we= $('.Product4 h5').text();
        let po=$('.Product4 p').text();
        addProduct(we,po);
    })
    $('.Product5 a').on('click',function () {
        let we= $('.Product5 h5').text();
        let po=$('.Product5 p').text();
        addProduct(we,po);
    })
   $('#back').click(function () {
          window.history.go(-1);
   })
    $('#checkboxID').change(function () {
        $('#shipping input').prop('disabled',true);
    })
}
function addProduct(we,po){
       var Price =we;
        var Name=po;
        console.log(Price+Name)
        $.post('/AddToCart', {
            productPrice : Price,
            productName : Name,
        }, function(data) {
            console.log("success"+data);
        });

}
window.onload=loadingFunction;
// $('#checkoutBtn').click(function(event){
//     event.preventDefault();
//
//     $.ajax({
//         url: '/checkout',
//         type: 'GET',
//          success: function(response){
//             console.log("Sucessufully!");
//         },
//         error: function(){
//             alert('Error while request..');
//         }
//     });
//
// });