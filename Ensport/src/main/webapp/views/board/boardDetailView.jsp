<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
#boardTitle {
	width: 300px;
}

.table-stripped {
	font-size: 35px;
}

#imageDisplay {
	width: 100px;
	height: 100px;
}

.ck-editor__editable {
	height: 400px;
}

.ck-content {
	font-size: 12px;
}

.td1 {
	text-align: left;
	font-size: 15px;
}

#tr1>th {
	padding: 30px 0px;
}

th {
	text-align: center;
}

.reply {
	text-align: center;
	font-size: 16px;
	font-weight: bold;
}

/* .container { */
/* 	padding: 30px 30px; */
/* } */

.hidden-td{
	display:none;

}
.btn-td{
	width: 3px;
	height: 10px;
}

.hidden-td{
	display:none;

}
.btn-td{
	width: 3px;
	height: 10px;
}

.hidden-td{
	display:none;

}
.btn-td{
	width: 3px;
	height: 10px;
}

.hidden-td{
	display:none;

}
.btn-td{
	width: 3px;
	height: 10px;
}

.hidden-td{
	display:none;

}
.btn-td{
	width: 3px;
	height: 10px;
}

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>커뮤니티</h1>
					<nav class="d-flex align-items-center">
						<a href="${contextPath }">HOME<span
							class="lnr lnr-arrow-right"></span></a> <a
							href="${contextPath }/boardList.bo?currentPage=1">자유게시판</a>
					</nav>
				</div>
			</div>
		</div>
	</section>

	<div class="container">
		<br> <br>
		<table class="table table-stripped"
			style="text-align: center; boarder: 1px solid #dddddd">
			<thead>
			<c:choose>
				<c:when test="${b.boardType==1 }">
					<tr id="tr1">
						<th colspan="4" class="pt-30 pb-30">공지사항 상세보기</th>
					</tr>
				</c:when>
				<c:otherwise>
					<tr id="tr1">
						<th colspan="4" class="pt-30 pb-30">게시글 상세보기</th>
					</tr>
				</c:otherwise>
			</c:choose>
				<tr>
					<td class="td1">글번호: ${b.boardNo }</td>
					<td class="td1">작성자: ${b.userNo }</td>
					<td class="td1">작성일: ${b.createDate }</td>
					<td class="td1">조회수: ${b.boardCount }</td>
				</tr>
			</thead>

			<tbody>
				<tr>
					<th colspan="1" style="font-size: 15px;">제목</th>
					<td colspan="3"><input type="text" class="form-control"
						name="title" placeholder="글 제목" maxlength="100"
						value="${b.boardTitle }" readonly="readonly"></td>
				</tr>
				<tr class="tr1">
					<th colspan="1" style="font-size: 15px;">내용</th>
					<td colspan="3"><textarea id="editor" class="form-control"
							name="content" placeholder="글 내용" name="bbsContent"
							maxlength="8192" style="height: 350px" readonly="readonly">${b.boardContent }</textarea></td>
				</tr>
				<tr>
						<th style="font-size: 15px; padding-left: 0px;">이미지</th>
						<c:forEach items="${list }" var="image" varStatus="vs">
							<td><img id="contentImg${vs.count }" src="${contextPath }${image.filePath}${image.changeName}" width="300" height="300"></td>
						</c:forEach>
						
				</tr>
				<tr>
					<th colspan="1" style="font-size: 15px; padding-left: 0px;">첨부파일</th>
					<th colspan="3"
						style="font-size: 15px; text-align: left; padding-left: 0px;">
						<c:choose>
							<c:when test="${empty a }">
									첨부파일이 없습니다.
								</c:when>
							<c:otherwise>
								<a download="${a.originName }"
									href="${contextPath }${a.filePath }${a.changeName}">${a.originName }</a>
							</c:otherwise>
						</c:choose>
					</th>
				</tr>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${b.userNo eq loginUser.userNickname }">
				<a class="primary-btn pull-right"
				href="${contextPath }/boardDelete.bo?bno=${b.boardNo}"
				onclick="return confirm('정말 삭제하시겠습니까?')" style="border-radius: 0; margin-right:13px;">삭제하기</a>
				<a class="primary-btn pull-right"
				href="${contextPath }/boardUpdate.bo?bno=${b.boardNo }"
				style="border-radius: 0">수정하기</a>
			</c:when>
			<c:when test="${loginUser.userId eq 'admin'}">
				<a class="primary-btn pull-right"
				href="${contextPath }/boardDelete.bo?bno=${b.boardNo}"
				onclick="return confirm('정말 삭제하시겠습니까?')" style="border-radius: 0; margin-right:13px;">삭제하기</a>
			</c:when>
		</c:choose>
		<a href="${contextPath }/boardList.bo?currentPage=1"
			class="primary-btn pull-right"
			style="border-radius: 0; margin-right:13px;">목록으로</a>
			<table class="table table-stripped"
				style="text-align: center; width:100%;">
				<c:choose>
					<c:when test="${loginUser != null }">
						<c:choose>
							<c:when test="${loginUser.userId}=='admin'">
								<thead>
									<tr>
										<td class="reply" colspan="1">댓글</td>
										<td colspan="5" class="reply"><textarea id="replyContent" class="form-control"
												rows="4" cols="50"
												style="width: 100%; resize: none; border: 1px solid black;"></textarea></td>
									</tr>
									<tr>
										<td colspan="6"><button onclick="insertReply();" class="primary-btn pull-right"
												style="border-radius: 0; font-size: 14px;">댓글작성</button></td>
									</tr>
								</thead>	
							</c:when>
							<c:otherwise>
								<thead>
									<tr>
										<td class="reply" colspan="1">댓글</td>
										<td colspan="3" class="reply" id="increaseCol"><textarea id="replyContent" class="form-control"
												rows="4" cols="50"
												style="width: 100%; resize: none; border: 1px solid black;"></textarea></td>
									</tr>
									<tr>
										<td colspan="4" id="increaseCol2"><button onclick="insertReply();" class="primary-btn pull-right"
												style="border-radius: 0; font-size: 14px;">댓글작성</button></td>
									</tr>
								</thead>	
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<tr>
							<td class="reply" colspan="1">댓글</td>
							<td colspan="3" class="reply">로그인 후 댓글 작성 가능합니다.</td>
						</tr>
					</c:otherwise>
					
				</c:choose>
				<tbody id="replyTable">
					
				</tbody>
			</table>
	</div>
	<script>
		function insertReply(){
			
				$.ajax({
					url : "insertReply.bo",
					data : {
						content:$("#replyContent").val(),
						bno:${b.boardNo}
					},
					type: "post",
					success : function(result){	
							
							if(result>0){//성공
								alert("댓글 작성 완료");
								//추가된 댓글목록 재조회
								$("#replyContent").val("");
								$.ajax({
									url:"replyList.bo",
									data:{bno:${b.boardNo}},
									success: function(result){
										
										var str = "";
										
										for(var i in result){
											console.log("true or false: "+${loginUser.userId=='admin'});
											console.log("result[i]:"+result[i].userId);
											console.log("loginUser: "+'${loginUser.userNickname}');
											
											
											str += "<tr>"
												  +"<td class='reply' colspan='1'>"+result[i].userId+"</td>"
												  +"<td class='reply' colspan='2' style='text-align:left;'>"+result[i].replyContent+"</td>"
												  +"<td class='reply' colspan='1' style='text-align:right;'>"+result[i].createDate+"</td>"
												  if('${loginUser.userId}'=='admin' || result[i].userId=='${loginUser.userNickname}'){
													  
													  $("#increaseCol").attr('colspan',5);
													  $("#increaseCol2").attr('colspan',6);
													  
													  str += "<td class='btn-td'>"
													  			+"<button id='deleteReplyId' type='button' onclick='deleteReply(this);' >"
													  				+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-trash' viewBox='0 0 16 16'>"
														  				+"<path d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z'/>"
															  			+ "<path d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z'/>"
																	+"</svg></button>"
																+"<button type='button' onclick='updateReply(this);'>"
																	+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pen' viewBox='0 0 16 16'>"
																	  +"<path d='m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z'/>"
																	+"</svg>"
																+"</button></td>"
													  		+"<td class='hidden-td'><input type='hidden' value='"+result[i].replyNo+"'></td>";
												  }
												  str += "</tr>";
										}
										
										$("#replyTable").html(str);
									},
									error : function(){
										alert("통신오류");
									}
								});
							
							}else{//실패
								alert("댓글 작성 실패");
							}
					},
					error : function(){
						console.log("통신오류");
					}
				});
		}
		
		window.onload = function replyList(){
			$.ajax({
				url:"replyList.bo",
				data:{bno:${b.boardNo}},
				success: function(result){
					
					var str = "";
					
					for(var i in result){
						console.log("true or false: "+${loginUser.userId=='admin'});
						console.log("result[i]:"+result[i].userId);
						console.log("loginUser: "+'${loginUser.userNickname}');
						
						
						str += "<tr>"
							  +"<td class='reply' colspan='1'>"+result[i].userId+"</td>"
							  +"<td class='reply' colspan='2' style='text-align:left;'>"+result[i].replyContent+"</td>"
							  +"<td class='reply' colspan='1' style='text-align:right;'>"+result[i].createDate+"</td>"
							  if('${loginUser.userId}'=='admin' || result[i].userId=='${loginUser.userNickname}'){
								  
								  $("#increaseCol").attr('colspan',5);
								  $("#increaseCol2").attr('colspan',6);
								  
								  str += "<td class='btn-td'>"
								  			+"<button id='deleteReplyId' type='button' onclick='deleteReply(this);' >"
								  				+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-trash' viewBox='0 0 16 16'>"
									  				+"<path d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z'/>"
										  			+ "<path d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z'/>"
												+"</svg></button>"
											+"<button type='button'  onclick='updateReply(this);'>"
												+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pen' viewBox='0 0 16 16'>"
												  +"<path d='m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z'/>"
												+"</svg>"
											+"</button></td>"
								  		+"<td class='hidden-td'><input type='hidden' value='"+result[i].replyNo+"'></td>";
							  }
							  str += "</tr>";
					}
					
					$("#replyTable").html(str);
				},
				error : function(){
					alert("통신오류");
				}
			});
		}
		
		
		
		function deleteReply(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			var conf = confirm("삭제하시겠습니까?");
			if(conf==true){
			$.ajax({
				url:"deleteReply.bo",
				type: "get",
				data:{
					replyNo: replyNo
				},
				success: function(result){
					alert("댓글 삭제하였습니다");
					$.ajax({
						url:"replyList.bo",
						data:{bno:${b.boardNo}},
						success: function(result){
							
							var str = "";
							
							for(var i in result){
								console.log("true or false: "+${loginUser.userId=='admin'});
								console.log("result[i]:"+result[i].userId);
								console.log("loginUser: "+'${loginUser.userNickname}');
								
								
								str += "<tr>"
									  +"<td class='reply' colspan='1'>"+result[i].userId+"</td>"
									  +"<td class='reply' colspan='2' style='text-align:left;'>"+result[i].replyContent+"</td>"
									  +"<td class='reply' colspan='1' style='text-align:right;'>"+result[i].createDate+"</td>"
									  if('${loginUser.userId}'=='admin' || result[i].userId=='${loginUser.userNickname}'){
										  
										  $("#increaseCol").attr('colspan',5);
										  $("#increaseCol2").attr('colspan',6);
										  
										  str += "<td class='btn-td'>"
										  			+"<button id='deleteReplyId' type='button' onclick='deleteReply(this);' >"
										  				+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-trash' viewBox='0 0 16 16'>"
											  				+"<path d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z'/>"
												  			+ "<path d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z'/>"
														+"</svg></button>"
													+"<button type='button' onclick='updateReply(this);'>"
														+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pen' viewBox='0 0 16 16'>"
														  +"<path d='m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z'/>"
														+"</svg>"
													+"</button></td>"
										  		+"<td class='hidden-td'><input type='hidden' value='"+result[i].replyNo+"'></td>";
									  }
									  str += "</tr>";
							}
							
							$("#replyTable").html(str);
						},
						error : function(){
							alert("통신오류");
						}
					});
				}
			});
			}
		}
		
		function updateReply(element){
			console.log("들어왔니?");
			var content = $(element).parent().prev().prev().text();
			console.log(content);
			$(element).parent().prev().prev().html("<textarea id='updateContent' class='form-control' rows='4' cols='50' style='width: 100%; resize: none; border: 1px solid black;''>"+content+"</textarea>");
			$(element).hide();
			$(element).prev().hide();
			$(element).parent().append("<button id='updateReplyFinalId'class='btn btn-danger btn-sm' type='button' onclick='updateReplyFinal(this);'>저장</button>"
								+"<button id='updateCancelId' type='button' class='btn btn-sm btn-info' onclick='updateCancel();'>취소</button>");
		}
		function updateCancel(){
			$.ajax({
				url:"replyList.bo",
				data:{bno:${b.boardNo}},
				success: function(result){
					
					var str = "";
					
					for(var i in result){
						console.log("true or false: "+${loginUser.userId=='admin'});
						console.log("result[i]:"+result[i].userId);
						console.log("loginUser: "+'${loginUser.userNickname}');
						
						
						str += "<tr>"
							  +"<td class='reply' colspan='1'>"+result[i].userId+"</td>"
							  +"<td class='reply' colspan='2' style='text-align:left;'>"+result[i].replyContent+"</td>"
							  +"<td class='reply' colspan='1' style='text-align:right;'>"+result[i].createDate+"</td>"
							  if('${loginUser.userId}'=='admin' || result[i].userId=='${loginUser.userNickname}'){
								  
								  $("#increaseCol").attr('colspan',5);
								  $("#increaseCol2").attr('colspan',6);
								  
								  str += "<td class='btn-td'>"
								  			+"<button id='deleteReplyId'class='btn btn-danger btn-sm' type='button' onclick='deleteReply(this);' >"
								  				+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-trash' viewBox='0 0 16 16'>"
									  				+"<path d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z'/>"
										  			+ "<path d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z'/>"
												+"</svg></button>"
											+"<button type='button' class='btn btn-sm btn-info' onclick='updateReply(this);'>"
												+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pen' viewBox='0 0 16 16'>"
												  +"<path d='m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z'/>"
												+"</svg>"
											+"</button></td>"
								  		+"<td class='hidden-td'><input type='hidden' value='"+result[i].replyNo+"'></td>";
							  }
							  str += "</tr>";
					}
					
					$("#replyTable").html(str);
				},
				error : function(){
					alert("통신오류");
				}
			});
		}
		function updateReplyFinal(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			console.log("text?"+$("#updateContent").val());
			$.ajax({
				url: "updateReply.bo",
				type: "post",
				data: {
					replyNo: replyNo,
					content: $("#updateContent").val()
				},
				success: function(result){
					
					$("#updateContent").remove();
					$(number).eq(0).show();
					$(number).eq(1).show();
					$("#updateReplyFinalId").hide();
					$("#updateCancel").hide();
					
					if(result=="1"){
						
						alert("댓글 수정 성공했습니다.");
						$.ajax({
							url:"replyList.bo",
							data:{bno:${b.boardNo}},
							success: function(result){
								
								var str = "";
								
								for(var i in result){
									console.log("true or false: "+${loginUser.userId=='admin'});
									console.log("result[i]:"+result[i].userId);
									console.log("loginUser: "+'${loginUser.userNickname}');
									
									
									str += "<tr>"
										  +"<td class='reply' colspan='1'>"+result[i].userId+"</td>"
										  +"<td class='reply' colspan='2' style='text-align:left;'>"+result[i].replyContent+"</td>"
										  +"<td class='reply' colspan='1' style='text-align:right;'>"+result[i].createDate+"</td>"
										  if('${loginUser.userId}'=='admin' || result[i].userId=='${loginUser.userNickname}'){
											  
											  $("#increaseCol").attr('colspan',5);
											  $("#increaseCol2").attr('colspan',6);
											  
											  str += "<td class='btn-td'>"
											  			+"<button id='deleteReplyId' type='button' onclick='deleteReply(this);' >"
											  				+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-trash' viewBox='0 0 16 16'>"
												  				+"<path d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z'/>"
													  			+ "<path d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z'/>"
															+"</svg></button>"
														+"<button type='button' onclick='updateReply(this);'>"
															+"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pen' viewBox='0 0 16 16'>"
															  +"<path d='m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z'/>"
															+"</svg>"
														+"</button></td>"
											  		+"<td class='hidden-td'><input type='hidden' value='"+result[i].replyNo+"'></td>";
										  }
										  str += "</tr>";
								}
								
								$("#replyTable").html(str);
							},
							error : function(){
								alert("통신오류");
							}
						});
					}
					
				},
				error: function(){
					console.log("통신실패");
				}
			});
			
		}
		
		
		
		function deleteReply(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			var conf = confirm("삭제하시겠습니까?");
			if(conf==true){
			$.ajax({
				url:"deleteReply.bo",
				type: "get",
				data:{
					replyNo: replyNo
				},
				success: function(result){
					alert("댓글 삭제하였습니다");
					location.reload();
				}
			});
			}
		}
		
		function updateReply(element){
			console.log("들어왔니?");
			var content = $(element).parent().prev().prev().text();
			console.log(content);
			$(element).parent().prev().prev().html("<textarea id='updateContent' class='form-control' rows='4' cols='50' style='width: 100%; resize: none; border: 1px solid black;''>"+content+"</textarea>");
			$(element).hide();
			$(element).prev().hide();
			$(element).parent().append("<button id='updateReplyFinalId'class='btn btn-danger btn-sm' type='button' onclick='updateReplyFinal(this);'>저장</button>"
								+"<button id='updateCancelId' type='button' class='btn btn-sm btn-info' onclick='updateCancel();'>취소</button>");
		}
		function updateCancel(){
			location.reload();
		}
		function updateReplyFinal(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			console.log("text?"+$("#updateContent").val());
			$.ajax({
				url: "updateReply.bo",
				type: "post",
				data: {
					replyNo: replyNo,
					content: $("#updateContent").val()
				},
				success: function(result){
					
					$("#updateContent").remove();
					$(number).eq(0).show();
					$(number).eq(1).show();
					$("#updateReplyFinalId").hide();
					$("#updateCancel").hide();
					
					if(result=="1"){
						
						alert("댓글 수정 성공했습니다.");
						location.reload();
					}
					
				},
				error: function(){
					console.log("통신실패");
				}
			});
			
		}
		
		
		
		function deleteReply(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			var conf = confirm("삭제하시겠습니까?");
			if(conf==true){
			$.ajax({
				url:"deleteReply.bo",
				type: "get",
				data:{
					replyNo: replyNo
				},
				success: function(result){
					alert("댓글 삭제하였습니다");
					location.reload();
				}
			});
			}
		}
		
		function updateReply(element){
			console.log("들어왔니?");
			var content = $(element).parent().prev().prev().text();
			console.log(content);
			$(element).parent().prev().prev().html("<textarea id='updateContent' class='form-control' rows='4' cols='50' style='width: 100%; resize: none; border: 1px solid black;''>"+content+"</textarea>");
			$(element).hide();
			$(element).prev().hide();
			$(element).parent().append("<button id='updateReplyFinalId'class='btn btn-danger btn-sm' type='button' onclick='updateReplyFinal(this);'>저장</button>"
								+"<button id='updateCancelId' type='button' class='btn btn-sm btn-info' onclick='updateCancel();'>취소</button>");
		}
		function updateCancel(){
			location.reload();
		}
		function updateReplyFinal(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			console.log("text?"+$("#updateContent").val());
			$.ajax({
				url: "updateReply.bo",
				type: "post",
				data: {
					replyNo: replyNo,
					content: $("#updateContent").val()
				},
				success: function(result){
					
					$("#updateContent").remove();
					$(number).eq(0).show();
					$(number).eq(1).show();
					$("#updateReplyFinalId").hide();
					$("#updateCancel").hide();
					
					if(result=="1"){
						
						alert("댓글 수정 성공했습니다.");
						location.reload();
					}
					
				},
				error: function(){
					console.log("통신실패");
				}
			});
			
		}
		
		
		
		function deleteReply(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			var conf = confirm("삭제하시겠습니까?");
			if(conf==true){
			$.ajax({
				url:"deleteReply.bo",
				type: "get",
				data:{
					replyNo: replyNo
				},
				success: function(result){
					alert("댓글 삭제하였습니다");
					location.reload();
				}
			});
			}
		}
		
		function updateReply(element){
			console.log("들어왔니?");
			var content = $(element).parent().prev().prev().text();
			console.log(content);
			$(element).parent().prev().prev().html("<textarea id='updateContent' class='form-control' rows='4' cols='50' style='width: 100%; resize: none; border: 1px solid black;''>"+content+"</textarea>");
			$(element).hide();
			$(element).prev().hide();
			$(element).parent().append("<button id='updateReplyFinalId'class='btn btn-danger btn-sm' type='button' onclick='updateReplyFinal(this);'>저장</button>"
								+"<button id='updateCancelId' type='button' class='btn btn-sm btn-info' onclick='updateCancel();'>취소</button>");
		}
		function updateCancel(){
			location.reload();
		}
		function updateReplyFinal(number){
			var replyNo = $(number).parent().next().find("input[type='hidden']").val();
			console.log("text?"+$("#updateContent").val());
			$.ajax({
				url: "updateReply.bo",
				type: "post",
				data: {
					replyNo: replyNo,
					content: $("#updateContent").val()
				},
				success: function(result){
					
					$("#updateContent").remove();
					$(number).eq(0).show();
					$(number).eq(1).show();
					$("#updateReplyFinalId").hide();
					$("#updateCancel").hide();
					
					if(result=="1"){
						
						alert("댓글 수정 성공했습니다.");
						location.reload();
					}
					
				},
				error: function(){
					console.log("통신실패");
				}
			});
		}
		
	</script>
	
	<br>
	<br>
	<%@ include file="../common/footer.jsp"%>

</body>
</html>