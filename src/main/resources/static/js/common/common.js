/* navbar 공통 */
function pageMove(e) {
	if(e =='home'){
		alert('home 실행');
		$("#navForm").attr("action","/").submit();
	}else if(e == 'introduce'){
		alert('introduce 실행');
		$("#navForm").attr("action","/introduce").submit();
	}else if(e == 'profile'){
		alert('profile 실행');
		$("#navForm").attr("action","/profile").submit();
	}else if(e == 'board'){
		alert('board 실행');
		$("#navForm").attr("action","/board/list").submit();
	}else{
		alert('값 없음');
	}
};