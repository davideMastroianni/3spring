$(document).ready(function() {
    $("#shw-pst").click(function() {
        $.ajax({
            url: "http://localhost:8080/posts/1"
        }).then(function(data) {
           console.log(data);
           $('#pst-nf > tbody:last-child').append('<tr><td>'+data.id+'</td><td>'+data.title+'</td><td>'+data.body+'</td></tr>');
        });
    });

    $("#shw-cmt").click(function() {
        $.ajax({
            url: "http://localhost:8080/posts/1/comments"
        }).then(function(data) {
            console.log(data)
            data.forEach(d => {
                $('#cmt-nf > tbody:last-child').append('<tr><td>'+d.id+'</td><td>'+d.name+'</td><td>'+d.email+'</td><td>'+d.body+'</td></tr>');
            })

        });
    });
});