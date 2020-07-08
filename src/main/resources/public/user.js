$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/posts?user=1"
    }).then(function(data) {
       console.log(data);
       data.forEach(d => {
           $('#pst-lst').append('<button class="shw-pst" data-id='+d.id+'>'+d.id+'</button>');
       })
       $(".shw-pst").click(function() {
           console.log(this)
           var id = jQuery(this).data("id");
           $.ajax({
               url: "http://localhost:8080/posts/"+id
           }).then(function(data) {
              console.log(data);
              $('#pst-nf tr:last').remove();
              $('#pst-nf > tbody:last-child').append('<tr><td>'+data.userId+'</td><td>'+data.id+'</td><td>'+data.title+'</td><td>'+data.body+'</td></tr>');
              $('#shw-cmt').data("id", data.id)
           });
       });
    });

    $("#shw-cmt").click(function() {
        var id = $('#shw-cmt').data("id")
        $.ajax({
            url: "http://localhost:8080/posts/"+id+"/comments"
        }).then(function(data) {
            console.log(data)
            $('#cmt-nf tbody tr').remove();
            data.forEach(d => {
               $('#cmt-nf > tbody:last-child').append('<tr><td>'+d.postId+'</td><td>'+d.id+'</td><td>'+d.name+'</td><td>'+d.email+'</td><td>'+d.body+'</td></tr>');
            })

        });
    });
});