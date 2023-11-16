<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/views/common/menubar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact V1</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	
</head>
<body>

	<div class="comment-form">
         <form method="post" action="${contextPath }/qaEnroll.qa">
         	<div align="center" style="margin-bottom: 20px;"><h1><b>문의사항 답변</b></h1></div>
             <div class="form-group">
                 <b>닉네임</b> <input type="text" class="form-control" id="nick_name" name="nick_name" placeholder="Subject" value="${qa.user_nickname}" readonly>
             </div>
             <div class="form-group">
                 <b>주제</b>  <input type="text" class="form-control" id="subject" name="subject" placeholder="Subject"  value="${qa.qa_title }" readonly>
             </div>
             <div class="form-group">
                 <b>내용</b>  <textarea class="form-control mb-10" rows="5" name="message" placeholder="Messege"
                    required readonly>${qa.qa_content }</textarea>
             </div>
            
            
         </form>
   		
   		<div id="show">

         	<div style="margin-top: 200px;">
         		<b>운영자 답변</b> <textarea style="resize: none;" id="qaAnswer"rows="5"class="form-control mb-10" required>${qa.user_nickname }님 귀한 문의 주셔서 감사합니다 ^^</textarea>
         	</div>
         	
			<button class="btn btn-success" style="margin-top: 30px;" id="insertReply">답장</button>
		</div>
		
         	<div style="margin-top: 150px;" id="selectReply">
         		
         		
        	</div>
        	
        	 <div style="margin-top: 120px; display: none;" id="commentEdit">
	        	 	<button id="updateComment" class="btn btn-primary" style="margin-right: 10px;">답변 수정하기</button>
	        	 	<button type="button" class="btn btn-info" id="deleteComment" style="margin-right: 10px;">답변 삭제하기</button>
	        	 	<button type="button" class="btn btn-secondary" onclick="history.back();">목록으로</button>
        	 </div>
        	 <div id="updateBtn" style="display: none;">
        	 	<button type="button" class="btn btn-primary" style="margin-right: 10px;" id="finalUpdate">확인</button>
    	 		<button class="btn btn-info" id="cancel">취소</button>
        	 </div>
        	 
     </div>
    
    
<!--     	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script> -->
     <script>
     	window.onload = function(){ //운영자 답변 조회
     		$.ajax({
     			url : "qaCommentDetail.qa",
     			data : {qa_answer_no: ${qa.qa_no}},
     			type : "post",
     			success : function(qac){
     				console.log(qac);
     				if(qac!=null){
     					
	     				$("#show").css("display","none");
	     				$("#commentEdit").css("display","block");
	     				$("#selectReply").append('<b>운영자 답변</b> <textarea style="resize: none;" name="qaComment"rows="5"class="form-control mb-10" readonly>'
	     															+qac.qa_answer+'</textarea> <br> '
	     															+qac.create_date);
     				}
     			},
     			error : function(){
     				console.log("통신실패");
     			}
     		});
     	}
     	
     	$("#insertReply").on("click",function(){//운영자 답변 추가

     		console.log("들어왔니?");
     	
			$.ajax({
				url : "insertQAComment.qa",
				data : {
					qa_no: ${qa.qa_no},
					user_no: ${loginUser.userNo},
					qaAnswer: $("#qaAnswer").val()
				},
				type : "get",
				success : function(result){
					if(result>0) {//성공
						
						//답변 추가 막기
						$("#show").css("display","none");
						//추가된 댓글목록 재조회	
						$.ajax({
			     			url : "qaCommentDetail.qa",
			     			data : {qa_answer_no: ${qa.qa_no}},
			     			type : "post",
			     			success : function(qac){
			     				$("#show").css("display","none");
			     				$("#commentEdit").css("display","block");
			     				$("#selectReply").append('<b>운영자 답변</b> <textarea style="resize: none;" name="qaComment"rows="5"class="form-control mb-10" readonly >'
			     															+qac.qa_answer+'</textarea> <br> '
			     															+qac.create_date);
			     			},
			     			error : function(){
			     				console.log("통신실패");
			     			}
			     		});
					
					
					
					}else{ //실패
						alert("댓글 작성 실패");
					}
				},
				error : function(){
					console.log("통신오류");
				}
			});	
     	});
		//답변 수정하기
     	$("#updateComment").click(function(){
     		$("#commentEdit").css("display","none");
     		$("#updateBtn").css("display","block");
     		$("#selectReply textarea").prop("readonly",false);
     		$("#selectReply textarea").focus();
     	});
     	
     	$("#finalUpdate").click(function(){
     		$.ajax({
				url : "qaCommentUpdate.qa",
				data : {
					qa_answer_no: ${qa.qa_no},
					qa_answer: $("#selectReply textarea").val()
				},
				type : "post",
				success : function(qa_answer_no){
	     					
					$.ajax({
		     			url : "qaCommentDetail.qa",
		     			data : {qa_answer_no: ${qa.qa_no}},
		     			type : "post",
		     			success : function(qac){
		     				alert("답변 수정 성공");
		     				if(qac!=null){
		     					
			     				$("#show").css("display","none");
			     				$("#commentEdit").css("display","block");
			     				$("#selectReplys").html('<b>운영자 답변</b> <textarea style="resize: none;" name="qaComment"rows="5"class="form-control mb-10" readonly>'
			     															+qac.qa_answer+'</textarea> <br> '
			     															+qac.create_date);
		     				}
		     			},
		     			error : function(){
		     				console.log("통신실패");
		     			}
		     		});
     				
     			},
     			error : function(){
     				console.log("수정실패");
     			}
			});	
     		$("#updateBtn").css("display","none");
     		$("#selectReply textarea").prop("readonly",true);
     		$("#commitEdit").css("display","block");
     		$("#commentEdit").css("display","block");
     	});
     	
     	$("#cancel").click(function(){
     		$.ajax({
     			url : "qaCommentDetail.qa",
     			data : {qa_answer_no: ${qa.qa_no}},
     			type : "post",
     			success : function(qac){
     				console.log(qac);
     				if(qac!=null){
     					
	     				$("#show").css("display","none");
	     				$("#commentEdit").css("display","block");
	     				$("#selectReply textarea").val(qac.qa_answer);
     				}
     			},
     			error : function(){
     				console.log("통신실패");
     			}
     		});
     		$("#updateBtn").css("display","none");
     		$("#selectReply textarea").prop("readonly",true);
     		$("#commitEdit").css("display","block");
     		$("#commentEdit").css("display","block");
     	});
     	//답변 삭제하기
     	$("#deleteComment").click(function(){
     		$.ajax({
     			url: "qaCommentDelete.qa",
     			data : {qa_answer_no: ${qa.qa_no}},
     			type : "get",
     			success: function(result){
     				if(result=="1"){
     					alert("답변 삭제하였습니다");
     					$.ajax({
     		     			url : "qaCommentDetail.qa",
     		     			data : {qa_answer_no: ${qa.qa_no}},
     		     			type : "post",
     		     			success : function(qac){
     		     				console.log(qac);
     		     				$("#selectReply").css("display","none");
     		     				$("#commentEdit").css("display","none");
     		     				$("#show").css("display","block");
     		     				
     		     			},
     		     			error : function(){
     		     				console.log("통신실패");
     		     			}
     		     		});
     				}else{
     					alert("답변 삭제실패하였습니다");
     				}
     			},
     			error:function(){
     				console.log("통신실패");
     			}
     		});
     	});
     </script>
     <%@ include file="/views/common/footer.jsp" %>

</body>
</html>
