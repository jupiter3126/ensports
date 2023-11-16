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
                            <h3>MY QNA</h3>
                        
                            <!-- ===================== QNA ======================= -->
                            
		                         <c:forEach items="${qList}" var="qList" varStatus="index">
			                        <div class="comments-area">

		                            	<!-- 내 질문 -->
				                        <div class="comment-list">
				                            <div class="single-comment justify-content-between d-flex">
				                                <div class="user justify-content-between d-flex">
				                                    <div class="desc">
				                                        <h5>${qList.qaTitle }</h5>
				                                        <p class="date">${qList.qaWriteDate }</p>
				                                        <p class="comment">${qList.qaContent }</p>
				                                    </div>
				                                </div>
				                                <div class="reply-btn">
			                                    	<c:if test="${empty qList.qaAnswer }">
			                                    		
			                                    		<div class="reply-btn">
						                                    <a href="#" class="btn-reply text-uppercase" style="pointer-events: none;">미답변</a>
						                                </div>
			                                    		
			                                    	</c:if>
			                                    	<c:if test="${not empty qList.qaAnswer }">
			                                    		<div class="reply-btn">
						                                    <a href="#" class="btn-reply text-uppercase" id="checkAdminAnswer" data-toggle="collapse" data-target="#qaAdminAnswer${index.count}">답변보기</a>
						                                </div>
			                                    	</c:if>
				                                </div>
				                            </div>
				                        </div>
				                        				                        
				                        <!-- 관리자 답변 -->
				                        <div class="comment-list left-padding" >
				                            <div class="single-comment justify-content-between d-flex">
				                                <div class="user justify-content-between d-flex" style="display:none">
				                                	
				                                	<c:if test="${not empty qList.qaAnswer }">	
					                                    <div id="qaAdminAnswer${index.count }" class="collapse desc">
					                                        <h5><b>▶ 관리자</b></h5>
					                                  		<p class="comment">${qList.qaAnswer }</p>
					                                        <p class="date">${qList.qaAnswerDate }</p>
					                                    </div>
				                                    </c:if>
				                                	<c:if test="${empty qList.qaAnswer }">	
					                                   <p class="comment"  style="color: red">＃ 답변 내역이 존재하지 않습니다.</p>
				                                    </c:if>
				                                    
				                                </div>
				                            </div>
				                        </div>
			                  	  </div>
								</c:forEach>
		                    
	                        <!-- ===================== QNA ======================= -->   
                            
                            
                            
                                                
							<!--====== paging ======-->
							<c:if test="${not empty qList }">
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
				                                <a href="${contextPath }/myPageQa.me?currentPage=${pi.currentPage-1}" class="page-link" aria-label="Previous">
				                                    <span aria-hidden="true">
				                                        <span class="lnr lnr-chevron-left"></span>
				                                    </span>
				                                </a>
				                            </li>
										</c:otherwise>
				                    </c:choose>
				                    
				                    
				                    <!-- 해당 페이지에 active 속성 부여해야함 (어떻게 해야할지 궁리좀 해보자) -->
		                    		<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage }">
			                            <li class="page-item"><a href="${contextPath }/myPageQa.me?currentPage=${i}" class="page-link">${i}</a></li>
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
				                                <a href="${contextPath }/myPageQa.me?currentPage=${pi.currentPage+1}" class="page-link" aria-label="Previous">
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
		                    <c:if test="${empty qList }">
		                    	<div class="text-center p-t-45"><b>※ 문의 내역이 없습니다.</b></div>
		                    </c:if>
							<!--====== page ======-->
	                    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
	
    
    
    
	
	<!--================ footer =================-->
    <%@ include file="../common/footer.jsp" %>
    
    
 
</body>
</html>