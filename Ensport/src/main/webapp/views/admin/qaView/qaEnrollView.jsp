<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/views/common/menubar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact V1</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
</head>
<style>
div{
	box-sizing: border-box;
}

 .cssGood{
 	display:flex;
 	justify-content: center;
 }
 .cssGood2{
 	width: 100%;
 	height: 100%;
 }

.left-div{
	width: 40%;
}
.right-div{
	width:  60%;
}
 .subject-div{
 	height:20%;
 	display: flex;
 	justify-content: center;
 	align-items: center;
 }
 .message-div{
 	height: 80%;
 	display: flex;
 	justify-content: center;
 	align-items: center;
 }
 .input-div{
 	width: 90%;
 	height: 80%;
 }
 .textarea-div{
 	width: 90%;
 	height: 80%;
 	resize: none;
 }
 
</style>
<body>

	
	<div class="comment-form">
         <h4 style="font-family: 'Noto Sans KR', sans-serif;">${sessionScope.loginUser.userNickname }님 안녕하세요! 무엇이든지 물어보세요</h4>
         <form method="post" action="${contextPath }/qaEnroll.qa">
             <input type="hidden" name="userNo" value="${loginUser.userNo }">
             <div class="cssGood">
             	
		            <div class="left-div" data-tilt>
						<img src="${contextPath }/resources/img/img-01.png" alt="IMG">
					</div>
		           	<div class="right-div">
		           		<div class="subject-div">
		                 <input type="text" class="input-div" id="subject" name="subject" placeholder="제목" onfocus="this.placeholder = ''"
		                     onblur="this.placeholder = '제목'" style="margin-bottom: 10px;">
		             	</div>
		           		<div class="message-div">
		                 	<textarea class="textarea-div" rows="5" name="message" placeholder="내용"
		                    	 onfocus="this.placeholder = ''" onblur="this.placeholder = '내용'" required></textarea>
		                </div>
		             </div>
	             
             </div>
             <button type="submit" class="primary-btn submit_btn" style="margin-top: 30px;">Post Comment</button>
         </form>
     </div>

</body>
</html>
