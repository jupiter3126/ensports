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
.image{
	height: 300px;
	text-align: center;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>

	<section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>회원가입</h1>
                    <nav class="d-flex align-items-center">
                        <a href="${contextPath }">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="${contextPath }/memberInsert.me">회원가입</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>

	<div class="container">

		<form action="${contextPath }/boardEnroll.bo?bType=${bType}" method="post" enctype="multipart/form-data">
		<input type="hidden" name="userNo" value="${loginUser.userNo }">
			<br>
			<br>
			<table class="table table-stripped"
				style="text-align: center; boarder: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="4"style="background-color: #eeeeee; text-align: center;">
						<c:choose>
							<c:when test="${bType=='2'}">게시글 작성</c:when>
							<c:otherwise>공지사항 작성</c:otherwise>
						</c:choose> 
						</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<th colspan="1" style="font-size: 15px;">제목</th>
						<td colspan="3"><input type="text" class="form-control"
							name="title" placeholder="글 제목" maxlength="50" required></td>
					</tr>
					<tr>
						<th colspan="1" style="font-size: 15px;">내용</th>
						<td colspan="3">
							<textarea id="editor" class="form-control"
									name="content" placeholder="글 내용" maxlength="8192"
									style="height: 450px" required></textarea>
						</td>
					</tr>
					<tr>
						<th style="font-size: 15px; padding-left: 0px;">이미지</th>
						<td><img id="contentImg1" width="300" height="300"></td>
						<td><img id="contentImg2" width="300" height="300"></td>
						<td><img id="contentImg3" width="300" height="300"></td>
					</tr>
					<tr>
						<th colspan="1" style="font-size: 15px; padding-left: 0px;">첨부파일</th>
						<td><input type="file" name="uploadFile"></td>
					</tr>
				</tbody>
			</table>
			<div id="file-area">
                <!-- onchange : 변화가 일어났을 때 발생하는 이벤트 
                     선언적 함수를 내부에 작성할때 해당 이벤트가 발생한 시점에 요소객체를 전달하는 방법
                     함수(this)
                -->
				<input type="file" id="file1" name="file1" onchange="loadImg(this,1);">
				<input type="file" id="file2" name="file2" onchange="loadImg(this,2);">
				<input type="file" id="file3" name="file3" onchange="loadImg(this,3);">
				
			</div>
			
			<div>
				<button type="submit" class="primary-btn pull-right" style="border-radius: 0">작성완료</button>
				<a href="${contextPath }/boardList.bo?currentPage=1" class="primary-btn pull-right" style="border-radius: 0">돌아가기</a>
			</div>
			<br><br><br>
		</form>
		
		<script>
            $(function(){
                $("#file-area").hide(); //file input 숨기기
                //대표이미지를 클릭하면 input file 요소 1번이 클릭되게 하는 함수
                $("#contentImg1").click(function(){
                    $("#file1").click();
                });
                $("#contentImg2").click(function(){
                    $("#file2").click();
                });
                $("#contentImg3").click(function(){
                    $("#file3").click();
                });
            });

            //이미지를 읽어줄 함수
            function loadImg(inputFile,num){
                //inputFile : 이벤트가 발생된 요소 객체
                console.log(inputFile.files);
                //inputFiles.files : 파일업로드 정보를 배열의 형태로 반환해주는 속성
                //파일을 선택하면 files속성의 length가 1이 반환됨
                if(inputFile.files.length == 1){ //파일이 등록되면
                    //해당 파일을 읽어줄 FileReader라고 하는 자바스크립트 객체를 이용한다.
                    var reader = new FileReader();
                    //파일을 읽어줄 메소드 : reader.readAsDataURL(파일)
                    //해당 파일을 읽어서 고유한 url을 부여해주는 메소드
                    //반환받은 url을 미리보기 화면에 넣어주면 된다.
                    reader.readAsDataURL(inputFile.files[0]);

                    //해당 reader객체가 읽혀진 시점에 img src속성에 부여된 고유 url을 넣어주기
                    reader.onload = function(e){ //e : event
                        console.log(e);
                        //이벤트 객체에서 reader가 부여한 고유 url 정보
                        //event.target.result 
                        console.log(e.target.result);

                        switch(num){
                            case 1: $("#contentImg1").attr("src",e.target.result); break;
                            case 2: $("#contentImg2").attr("src",e.target.result); break;
                            case 3: $("#contentImg3").attr("src",e.target.result); break;
                        }

                    }

                }else{ //length가 1이 아니면
                    switch(num){
                            case 1: $("#contentImg1").attr("src",null); break;
                            case 2: $("#contentImg2").attr("src",null); break;
                       		case 3: $("#contentImg3").attr("src",null); break;
                    }
                }
            }
            
            

        </script>
		
		
		
	</div>
	
	<br><br><br><br><br>
	<%@ include file="../common/footer.jsp"%>

</body>
</html>