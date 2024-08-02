let index={
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		
	},
	
	save: function(){
		
		let data={
			comId: $("#comId").val(),
			position: $("#position").val(),
			compensation: $("#compensation").val(),
			content: $("#content").val(),
			skill: $("#skill").val()
		}
		console.log(data);
		$.ajax({
			type: "POST",
			url: "/api/notice",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			alert("등록이 완료되었습니다.");
			location.href="/"
			
		}).fail(function(error){
			alert("등록에 실패했습니다.");
		});
		
	}
	
}

index.init();