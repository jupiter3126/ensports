<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath();
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#h1{
		/*
		text-align:center;
		font-size: 35px;
		color: #343a40;
		*/
		text-align: center;
		font-size: 40px;
		font-weight: bold;
	}
	
	.table{
		background-color: #b7e5b1;
	}
	
	thead>tr{
		font-size: 18px;
		font-weight: bold;
		text-align: center;
	}
	tbody tr td{
		font-size: 14px;
		font-weight: bold;
		text-align: center;
	}
	
	.pagination{
		display:flex;
		justify-content:center;
	}
	
	.pagination li a{
		font-size: 22px;
		font-weight: bold;
		color: #2ebd1b;
	}
	
	#page a{
		font-size: 18px;
	}
	
	#post{
		color: #6c757d;
	}
	
	#post:hover {
        text-decoration: underline;
        cursor: pointer;
    }
    #noticeDesign{
    	background-color: #ADD8F5;
    }
    #noticeCss{
    	background-color: #FFE5CC;
    	border-style: solid;
    	border-radius: 5px;
    	border-width: 1px;
    	border-color: red;
    	width: 70px;
    	color: red;
    }
    
</style>
</head>
<body>
	
	<%@ include file="../common/menubar.jsp" %>
	    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>커뮤니티</h1>
                    <nav class="d-flex align-items-center">
                        <a href="${contextPath }">HOME<span class="lnr lnr-arrow-right"></span></a>
                        <a href="${contextPath }/boardList.bo?currentPage=1">자유게시판</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->
	<br><br><br><br>
	
	<div id="h1">자유게시판</div>
	
	<br><br>
	
	<div class="container">
		<table class="table table-striped table-hover" style="background-color:#b7e5b1" >
			<thead>
				<tr>
					<th style="width: 50px;"></th>
					<th width="100">글번호</th>
					<th width="100">작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th width="100">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan='5'>게시글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list }" var="b">
							<c:choose>
								<c:when test="${b.boardType==1 }">
									<tr id="noticeDesign">
										<td><button id="noticeCss">공지</button></td>
										<td>${b.boardNo }</td>
										<td>${b.userNo }</td>
										<td><a href="${contextPath }/boardDetail.bo?bno=${b.boardNo }" id="post">${b.boardTitle }</a></td>
										<td>${b.createDate }</td>
										<td>${b.boardCount }</td>
									</tr>	
								</c:when>
								<c:otherwise>
									<tr>
										<td></td>
										<td>${b.boardNo }</td>
										<td>${b.userNo }</td>
										<td><a href="${contextPath }/boardDetail.bo?bno=${b.boardNo }" id="post">${b.boardTitle }</a></td>
										<td>${b.createDate }</td>
										<td>${b.boardCount }</td>
									</tr>	
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		
		<hr>
		
		
		<div class="text-center">
			<ul class="pagination">
		  	  <c:choose>
		  	  	<c:when test="${pi.currentPage eq 1 }">
		  	  		<li id="page"><a><button disabled>이전</button></a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li id="page"><a href="boardList.bo?currentPage=${pi.currentPage-1}">이전</a></li>
			  	</c:otherwise>	
			  </c:choose>
			  
			  <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
			  		<li><a href="boardList.bo?currentPage=${i}">${i}</a></li>
			  </c:forEach>
			  
			  <c:choose>
			  	<c:when test="${pi.currentPage eq pi.maxPage}">
			  		<li id="page"><a><button disabled>다음</button></a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li id="page"><a href="boardList.bo?currentPage=${pi.currentPage+1}">다음</a></li>
			  	</c:otherwise>
		      </c:choose>
			</ul>      
        </div>
		
		<c:if test="${loginUser != null }">
				<a class="primary-btn pull-right" href="boardEnroll.bo?bType=2" style="border-radius: 0">글작성</a>
		</c:if>
		
		<c:if test="${loginUser.userId=='admin' }">
			<a class="primary-btn pull-right" href="boardEnroll.bo?bType=1" style="border-radius: 0">공지사항 작성</a>
		</c:if>
	</div>
	
	<script>
	
		function boardDetail(){
			
		}
		
	
	
	</script>
	
	<br><br><br><br><br>	
	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>