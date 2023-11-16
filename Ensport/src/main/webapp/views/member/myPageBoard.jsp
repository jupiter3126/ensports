<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<style>
.pdt-7{ padding-top : 7px; }
</style>


<body>

	<%@ include file="../common/menubar.jsp" %>
	
    <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>마이 페이지</h1>
                    <nav class="d-flex align-items-center">
                        <a href="${contextPath }">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="${contextPath }/myPage.do">마이 페이지</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->
	
	

	<section class="blog_area single-post-area section_gap">
        <div class="container">
            <div class="row">
                
                <!-- 마이 페이지 메뉴 -->
                <%@ include file="myPage_profile.jsp" %>
				
				
				<!-- ### 내 정보 수정하기 ### -->
                <div class="col-lg-8 posts-list">
                    <div class="row">
                        <div class="col-md-12">
                            <h3>MY BOARD</h3>

								<!-- ===================== 게시판 ======================= -->
		                         <c:forEach items="${bList}" var="b" varStatus="status">
			                        <div class="comments-area">
		                            
		                            	<!-- 내 질문 -->
				                        <div class="comment-list">
				                            <div class="single-comment justify-content-between d-flex">
				                                <div class=" justify-content-between d-flex">
				                                    <div class="desc">
				                                        <h5><a href="${contextPath }/boardDetail.bo?bno=${b.boardNo }">${b.boardTitle }</a></h5>
				                                        <p class="date">작성일: ${b.createDate }</p>
				                                        <p class="date">조회수: ${b.boardCount }</p>
<%-- 				                                        <p class="comment">${b.qaContent }</p> --%>
				                                    </div>
				                                </div>
				                                <div class="reply-btn">
				                                    <a href="${contextPath }/boardUpdate.bo?bno=${b.boardNo }" class="btn-reply text-uppercase">수정</a>
				                                    <a href="${contextPath }/boardDelete.bo?bno=${b.boardNo }" class="btn-reply text-uppercase" onclick="return confirm('게시글을 삭제하시겠습니까?')">삭제</a>
				                                </div>
				                            </div>
				                        </div>
			                  	  	</div>
								</c:forEach>
		                    
	                        <!-- ===================== 게시판 ======================= --> 
 							
 							<!--====== paging ======-->
 							<c:if test="${not empty bList }">
			                    <nav class="blog-pagination justify-content-center d-flex">
				                   <ul class="pagination">
			                    	<c:choose>
				                        <c:when test="${pi.currentPage eq 1}">
											 <li class="page-item">
				                                <a href="#" class="page-link" aria-label="Previous">
				                                    <span aria-hidden="true">
				                                        <span class="lnr lnr-chevron-left"></span>
				                                    </span>
				                                </a>
				                            </li>
										</c:when>
										<c:otherwise>
										 	<li class="page-item">
				                                <a href="${contextPath }/myPageBoard.me?currentPage=${pi.currentPage-1}" class="page-link" aria-label="Previous">
				                                    <span aria-hidden="true">
				                                        <span class="lnr lnr-chevron-left"></span>
				                                    </span>
				                                </a>
				                            </li>
										</c:otherwise>
				                    </c:choose>
				                    
				                    <!-- 해당 페이지에 active 속성 부여해야함 (어떻게 해야할지 궁리좀 해보자) -->
		                    		<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage }">
			                            <li class="page-item"  id="currentPageNm"><a href="${contextPath }/myPageBoard.me?currentPage=${i}" class="page-link">${i}</a></li>
									</c:forEach>
									
									
				                    <c:choose>
				                        <c:when test="${pi.currentPage eq pi.maxPage}">
											 <li class="page-item">
				                                <a href="#" class="page-link" aria-label="Next">
				                                    <span aria-hidden="true">
				                                        <span class="lnr lnr-chevron-right"></span>
				                                    </span>
				                                </a>
				                            </li>
										</c:when>
										<c:otherwise>
										 	<li class="page-item">
				                                <a href="${contextPath }/myPageBoard.me?currentPage=${pi.currentPage+1}" class="page-link" aria-label="Previous">
				                                    <span aria-hidden="true">
				                                        <span class="lnr lnr-chevron-right"></span>
				                                    </span>
				                                </a>
				                            </li>
										</c:otherwise>
				                    </c:choose>
			                       </ul>
			                    </nav>
		                    </c:if>
		                    <c:if test="${empty bList }">
		                    	<div class="text-center p-t-45"><b>※ 게시글 내역이 없습니다.</b></div>
		                    </c:if>
							<!--====== page ======-->
                            
                            
                            <script type="text/javascript">
                            
                            	
                            	$(function(){
                            		
                            		//쿼리스트링으로 전달된 현재 페이지
                            		var currentPageNum = ${pi.currentPage};
                            		
                            		//페이징 태그 내부 숫자
                            		var currentPageNm = $("#currentPageNm a").html();
                            		
                            		console.log("====================")
                            		console.log(currentPageNum)
                            		console.log(currentPageNm)
                            		console.log("====================")


                            		//두 개가 같을 경우에
                            		if(currentPageNum == currentPageNm){
                            			//active class 추가하기
                            			console.log("같습니다")
                            			console.log($('#currentPageNm').find('.page-link:contains(${pi.currentPage})'));
                            			console.log("^^");
                            			console.log($('.page-link:contains(${pi.currentPage})').text());
                            			
                            			$('#currentPageNm').find('.page-link:contains(${pi.currentPage})').addClass("active");
                            			
                            		}else{
                            			console.log("다릅니당")
                            		}
                            		
                            	})
                            
                            </script>
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
	
    
    
    
    
    <script type="text/javascript">
    
    
	</script>
	
	
	
	
	<!--================ footer =================-->
    <%@ include file="../common/footer.jsp" %>
    
    
 
</body>
</html>