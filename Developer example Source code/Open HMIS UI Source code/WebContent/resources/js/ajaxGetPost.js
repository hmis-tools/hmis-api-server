/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function get_data(url,encodedata, success){
	$.ajax({
		type:"GET",
		url:url,
		data :encodedata,
		dataType:"json",
		restful:true,
		contentType: 'application/json',
		cache:false,
		timeout:20000,
		async:true,
		beforeSend :function(data) { },
		success:function(data){
                    alert(data);
			success.call(this, data);
		},
		error:function(data){
			alert("Error Connecting to the server");
                }
        });
}

function post_data(url,encodedata, success){
	$.ajax({
            type:"POST",
            url:url,
            data :encodedata,
            dataType:"json",
            restful:true,
            contentType: 'application/json',
            cache:false,
            timeout:20000,
            async:true,
            beforeSend :function(data) { },
            success:function(data){
                alert(data);
		success.call(this, data);
            },
            error:function(data){
                alert("Error Connecting to the server");
            }
        });
}

