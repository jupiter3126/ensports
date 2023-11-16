<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ensport.place.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>서울 축구 경기매칭</title>

</head>

<body id="category">

	<%@ include file="../common/menubar.jsp" %> 
	
	 
	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>축구 시설예약</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">HOME<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">시설예약<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">서울</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<div class="container">
		<div class="row">
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-categories">
					<div class="head">지역</div>
					<ul class="main-categories">
						<li class="main-nav-list"><a href="${contextPath }/seoul.so?localName=서울&currentPage=1"><span class="lnr lnr-arrow-right"></span><b>서울</b><span class="number"></span></a></li>

						<li class="main-nav-list"><a href="${contextPath }/gyeonggi.so?localName=경기&currentPage=1"><span class="lnr lnr-arrow-right"></span>경기<span class="number"></span></a></li>

						<li class="main-nav-list"><a  href="${contextPath }/incheon.so?localName=인천"><span class="lnr lnr-arrow-right"></span>인천<span class="number"></span></a></li>
						
						<li class="main-nav-list"><a data-toggle="collapse" href="#jeonbuk" aria-expanded="false" aria-controls="fruitsVegetable"><span
								class="lnr lnr-arrow-right"></span>전북<span class="number"></span></a>
															
						</li>
						
						<li class="main-nav-list"><a data-toggle="collapse" href="#daejeon" aria-expanded="false" aria-controls="fruitsVegetable"><span
								class="lnr lnr-arrow-right"></span>대전<span class="number"></span></a>
							
						</li>						

						<li class="main-nav-list"><a data-toggle="collapse" href="#sejong" aria-expanded="false" aria-controls="fruitsVegetable"><span
								class="lnr lnr-arrow-right"></span>세종<span class="number"></span></a>
							
						</li>

						<li class="main-nav-list"><a data-toggle="collapse" href="#busan" aria-expanded="false" aria-controls="fruitsVegetable"><span
								class="lnr lnr-arrow-right"></span>부산<span class="number"></span></a>
							
						</li>

						<li class="main-nav-list"><a data-toggle="collapse" href="#gangwon" aria-expanded="false" aria-controls="fruitsVegetable"><span
								class="lnr lnr-arrow-right"></span>강원<span class="number"></span></a>
							
						</li>

						<li class="main-nav-list"><a data-toggle="collapse" href="#jeju" aria-expanded="false" aria-controls="fruitsVegetable"><span
								class="lnr lnr-arrow-right"></span>제주<span class="number"></span></a>
							
						</li>
						
					</ul>
				</div>
				<div class="sidebar-filter mt-50" hidden>
					<div class="top-filter-head">Product Filters</div>
					<div class="common-filter">
						<div class="head" >Brands</div>
						<form action="#">
							<ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">Apple<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="asus" name="brand"><label for="asus">Asus<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="gionee" name="brand"><label for="gionee">Gionee<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="micromax" name="brand"><label for="micromax">Micromax<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="samsung" name="brand"><label for="samsung">Samsung<span>(19)</span></label></li>
							</ul>
						</form>
					</div>
					
					<div class="common-filter">
						<div class="head">Price</div>
						<div class="price-range-area">
							<div id="price-range"></div>
							<div class="value-wrapper d-flex">
								<div class="price">Price:</div>
								<span>$</span>
								<div id="lower-value"></div>
								<div class="to">to</div>
								<span>$</span>
								<div id="upper-value"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting">
							<label for="date">
							 	 <input type="date" id="date" max="2023-11-18"  min="2023-11-16" name="soccerChoiceDate"
							 	 	 />
							</label>
						
					</div>
					
	
									
					<div class="sorting mr-auto">
					
					
					<!-- 개수 섹션 -->
					</div>
					
					
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row" >
						<!-- single product -->
						<c:forEach var="sp" items="${list}">
							<div class="col-lg-4 col-md-6">
								<div class="single-product">
									<input type="hidden" value=${sp.placeNo } name="sno" />
									<img class="img-fluid"
										src="${contextPath }${sp.filePath}${sp.changeName}" alt=""
										style=" width: 300px;height: 174px;">
									<div class="product-details">
										<input type="text" value="${sp.placeName}">
										<h3>${sp.placeName}</h3>
										
										<div class="prd-bottom">																						
												<div class="prd-bottom" id="viewMore">
													<a href="#" class="social-info"> <span class="lnr lnr-move"></span>
														<p class="hover-text">view more</p>
													</a>
												</div>									
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
				</section>
				
				<script>
					$(document).ready(function() {
					    $(".single-product, #viewMore p").on("click", function(event) {
					        var selectedDate  = $("#date").val(); // 선택된 날짜 값을 가져옵니다
					        if (!selectedDate  || selectedDate  === "날짜선택") {
					            alert("날짜를 먼저 선택하세요");
					            event.preventDefault();
					        } else {
					            var sno = $(this).find("input[name=sno]").val();
					            location.href = "detail.bo?sno=" + sno + "&date=" + selectedDate ;
					            // 원하는 작업을 수행하는 대신 페이지 이동을 수행합니다.
					            // location.href = '${contextPath}/sc.seoul';
					        }
					    });
					});
				</script>
				
				
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting mr-auto">
					</div>

					<div class="pagination">
						<c:choose>
							<c:when test="${pi.currentPage eq 1}">
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Previous"> <span aria-hidden="true"> <span
											class="lnr lnr-chevron-left"></span>
									</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${contextPath }/seoul.so?localName=서울&currentPage=${pi.currentPage-1}"
									class="page-link" aria-label="Previous"> <span
										aria-hidden="true"> <span class="lnr lnr-chevron-left"></span>
									</span>
								</a></li>
							</c:otherwise>
						</c:choose>

						<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage }">
							<li class="page-item"><a
								href="${contextPath }/seoul.so?localName=서울&currentPage=${i}"
								class="page-link">${i}</a></li>
						</c:forEach>

						<c:choose>
							<c:when test="${pi.currentPage eq pi.maxPage}">
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Next"> <span aria-hidden="true"> <span
											class="lnr lnr-chevron-right"></span>
									</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a href="${contextPath }/seoul.so?localName=서울&currentPage=${pi.currentPage+1}" class="page-link" aria-label="Previous">
									<span aria-hidden="true"> <span class="lnr lnr-chevron-right"></span></span>
								</a></li>
							</c:otherwise>
						</c:choose>
					</div>
					
					
				</div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>

	


	<!-- Modal Quick Product View -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="container relative">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="product-quick-view">
					<div class="row align-items-center">
						<div class="col-lg-6">
							<div class="quick-view-carousel">
								<div class="item" style="background: url(img/organic-food/q1.jpg);">

								</div>
								<div class="item" style="background: url(img/organic-food/q1.jpg);">

								</div>
								<div class="item" style="background: url(img/organic-food/q1.jpg);">

								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="quick-view-content">
								<div class="top">
									<h3 class="head">Mill Oil 1000W Heater, White</h3>
									<div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
									<div class="category">Category: <span>Household</span></div>
									<div class="available">Availibility: <span>In Stock</span></div>
								</div>
								<div class="middle">
									<p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are
										looking for something that can make your interior look awesome, and at the same time give you the pleasant
										warm feeling during the winter.</p>
									<a href="#" class="view-full">View full Details <span class="lnr lnr-arrow-right"></span></a>
								</div>
								<div class="bottom">
									<div class="color-picker d-flex align-items-center">Color:
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
									</div>
									<div class="quantity-container d-flex align-items-center mt-15">
										Quantity:
										<input type="text" class="quantity-amount ml-15" value="1" />
										<div class="arrow-btn d-inline-flex flex-column">
											<button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
											<button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
										</div>

									</div>
									<div class="d-flex mt-20">
										<a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
										<a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
										<a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<img src="img/공간.png" alt="">

	<%@ include file="../common/footer.jsp" %> 
	<script src="<%= request.getContextPath() %>/resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="<%= request.getContextPath() %>/resources/js/vendor/bootstrap.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/jquery.nice-select.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/jquery.sticky.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/nouislider.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="<%= request.getContextPath() %>/resources/js/gmaps.min.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/main.js"></script>

</body>

</html>
</body>

</html>