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
                            <h3>MY REVEIW</h3>

								<div class="container section_gap_top_75">
							            <div class="cart_inner">
							                <div class="table-responsive">
							                    <table class="table">
							                        <thead>
							                            <tr class="text-center">
							                                <th scope="col">#</th>
							                                <th scope="col">경기 상세정보</th>
							                                <th scope="col">리뷰</th>
							                            </tr>
							                        </thead>
							                        <tbody>
														<c:choose>
														    <c:when test="${empty reviewList}">
														        <tr>
														            <td class="text-center" colspan="3">
														                <p><b>※ 리뷰 내역이 없습니다.</b></p>
														            </td>
														        </tr>
														    </c:when>
														    <c:otherwise>
														        <c:forEach items="${reviewList}" var="rv" varStatus="status">
														        	
														            <tr>
									                            	<td class="text-center">
									                                    <h5>NO. ${rv.reservationNo}</h5>
									                                    <h5>
									                                      <c:if test="${rv.reservationType eq 'M'}">소셜매치</c:if>
									                                      <c:if test="${rv.reservationType ne 'M'}">구장예약</c:if>
									                                    </h5>
									                                </td>
									                                <td>
									                                    <div class="media">
									                                        <div class="d-flex">
																		<%-- <img src="${contextPath }/resources/img/cart.jpg" alt=""> --%>
									                                        </div>
									                                        <div class="media-body">
									                                            <p><b># 일시</b> <fmt:formatDate value="${rv.reservationDate}" pattern="yyyy년 MM월 dd일" /> ${rv.timeNo}</p>
									                                            <p><b># 장소</b>  ${rv.placeNo}</p>
									                                     		<c:if test="${rv.reservationType ne 'M'}"><b># 인원</b> - </c:if>
									                                        </div>
									                                    </div>
									                                </td>
									                                <td>
									                                	<c:choose>
									                               			<%-- 리뷰 쓴 적 없음  --%>
									                               			<c:when test="${rv.reviewNo == null || rv.reviewNo == 0}">
									                               				<div class="button-group-area mt-40 text-center">
																					<a href="#" class="genric-btn primary-border small" onclick="insertMyReview(${rv.playerNo});">작성</a>
																				</div>
									                               			</c:when>
									                               			
									                               			<%-- 리뷰를 작성한 이력이 있음--%>
									                               			<c:otherwise>
									                               				<div class="button-group-area mt-40 text-center">
									                               					<div><a href="#" class="genric-btn primary-border small" onclick="viewMyReview(${rv.reviewNo})">보기</a></div>
																					<div><a href="#" class="genric-btn primary-border small" onclick="deleteMyReview(${rv.reviewNo})">삭제</a></div>
																				</div>
																			</c:otherwise>
																		</c:choose>
									                                </td>
									                            </tr>
													        </c:forEach>
													    </c:otherwise>
													</c:choose>
						                           
						                        </tbody>
						                    </table>
						                </div>
						            </div>
						        </div>
						    <!--================End Cart Area =================-->
 							
 							
 							<!--====== paging ======-->
 							<c:if test="${not empty reviwList }">
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
				                                <a href="${contextPath }/myPageReview.me?currentPage=${pi.currentPage-1}" class="page-link" aria-label="Previous">
				                                    <span aria-hidden="true">
				                                        <span class="lnr lnr-chevron-left"></span>
				                                    </span>
				                                </a>
				                            </li>
										</c:otherwise>
				                    </c:choose>
				                    
				                    <!-- 해당 페이지에 active 속성 부여해야함 (어떻게 해야할지 궁리좀 해보자) -->
		                    		<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage }">
			                            <li class="page-item"><a href="${contextPath }/myPageReview.me?currentPage=${i}" class="page-link">${i}</a></li>
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
				                                <a href="${contextPath }/myPageReview.me?currentPage=${pi.currentPage+1}" class="page-link" aria-label="Previous">
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
							<!--====== page ======-->
 						
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
	
    
    
    <script type="text/javascript">
    	let testVal ="asd";
    	//리뷰 보기 팝업창 열기
	    function viewMyReview(reviewNo) {
	       
    		window.open("${contextPath}/myPageReviewDetail.me?reviewNo=" + reviewNo, "Popup", "width=650, height=400");
	        
	    }
    	
	    
	    //리뷰 등록 팝업창 열기
	    function insertMyReview(playerNo) {
	        window.open("${contextPath}/insertMyReview.me?playerNo=" + playerNo, "Popup", "width=650, height=400");
	        
	        console.log(window.opener);
	    }
	    
	    
	    //리뷰 삭제하기
	    function deleteMyReview(reviewNo) {
	    	
			if(confirm("리뷰를 삭제하시겠습니까?")){
				window.close();
				location.href= '${contextPath}/deleteMyReview.me?reviewNo=' + reviewNo;
				window.opener.location.reload();
			}else{
				return false;
			}
	    }
	    
    </script>
     


	<!--================ footer =================-->
    <%@ include file="../common/footer.jsp" %>
    
    
 
</body>
</html>