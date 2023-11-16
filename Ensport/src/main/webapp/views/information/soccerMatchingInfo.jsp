<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
s
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<title>축구 경기 매칭 상세 페이지</title>
<!--
			CSS
			============================================= -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/linearicons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/themify-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/owl.carousel.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/nice-select.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/nouislider.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/ion.rangeSlider.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css">
</head>

<body>

	<%@ include file="../common/menubar.jsp"%>

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>축구 경기 매칭</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">경기매칭<span class="lnr lnr-arrow-right"></span></a> <a
							href="single-product.html">축구</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_Product_carousel">
						<c:forEach var="at" items="${slist}">
							<div class="single-prd-item" width="250" height="150">
								<img class="img-fluid"
									src="${contextPath }${at.filePath}${at.changeName}">
							</div>


						</c:forEach>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3>[ ${matchingDate}]${p.placeName }</h3>
						<ul class="list">
							<li><a class="active" href="#"><span>Category</span> :
									${p.categoryName }</a></li>
						</ul>
						<p>${p.subInfo }</p>

						<br>
						<div class="single-element-widget mt-30">
							<div class="default-select" id="default-select">
								<select id="timeselct">
									<option value="0">시간 선택</option>
									<option value="1">13:00~15:00</option>
									<option value="2">16:00~18:00</option>
									<option value="3">19:00~21:00</option>
								</select>
								<div id="selectedTimeData"></div>
							</div>
						</div>
						<br>
						<div class="datasheet p-3 mb-2 text-white"
							style="background-color: #e8f0f2;">
							<a href="" id="participantCount" class="text-black"
								style="color: black;">참여인원: <span id="player"></span> / <span
								id="totalPlayer"></span>
							</a>
						</div>
						<br> <br>
						<div class="card_area d-flex align-items-center" id="btnWrap">
							<button type="button" class="primary-btn" data-toggle="modal"
								data-target="#exampleModal">예약하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">예약 내역</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<br> [예약 경기장] : ${p.placeName} <br> <br> [예약 날짜]
					:${matchingDate} <br> <br> [예약 시간] : <a class="rt"></a> <br>
					<br>
				</div>
				<div class="modal-footer">
					<div class="button-group-area mt-40">
						<button type="button" class="genric-btn primary"
							data-dismiss="modal">닫기</button>
						<button type="button" class="genric-btn info">결제하기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">상세설명</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">정보</a></li>
				<li class="nav-item"><a class="nav-link active" id="review-tab"
					data-toggle="tab" href="#review" role="tab" aria-controls="review"
					aria-selected="false">리뷰</a> 
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<p>${p.subInfo }</p>

				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<td>
										<h5>size</h5>
									</td>
									<td>
										<h5>${p.placeSize }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>parking</h5>
									</td>
									<td>
										<h5>${p.parkingYn }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Date</h5>
									</td>
									<td>
										<h5>${p.placeDate }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>start time</h5>
									</td>
									<td>
										<h5>${p.startTime }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>end time</h5>
									</td>
									<td>
										<h5>${p.endTime }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>maxCapacity</h5>
									</td>
									<td>
										<h5>${p.maxCapacity }</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>category</h5>
									</td>
									<td>
										<h5>${p.categoryName }</h5>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>

				<div class="tab-pane fade show active" id="review" role="tabpanel"
					aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg">
							<div class="row total_rate">
								<div class="col-6">
									<div class="box_total" id="avaerage">
										<h5>Overall</h5>
										<h4></h4>
										<h6>( Reviews)</h6>
									</div>
								</div>
								<div class="col-6">
									<div class="rating_list" id="count">
										<h3>Based on Reviews</h3>
										<ul class="list">
											<li id="five"><a href="#"> 5 Star <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <span></span>
											</a></li>
											<li id="four"><a href="#">4 Star <i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i><i class="fa fa-star"></i> <span>개</span>
											</a></li>
											<li id="three"><a href="#">3 Star <i
													class="fa fa-star"></i><i class="fa fa-star"></i><i
													class="fa fa-star"></i> <span></span>
											</a></li>
											<li id="two"><a href="#">2 Star <i
													class="fa fa-star"></i><i class="fa fa-star"></i> <span></span>
											</a></li>
											<li id="one"><a href="#">1 Star <i
													class="fa fa-star"></i><span></span>
											</a></li>
										</ul>
									</div>
								</div>

							</div>
							<div class="button-group-area">
								<a class="genric-btn" onclick="orderByRecent()">최신순</a> 
								<a class="genric-btn" onclick="orderByStar()">별점순</a>

							</div>
							
							
							
				
							<div id="reviewContainer">
								<div class="review_list">
									<div class="review_item">
										<div class="media">
											<div class="d-flex">
												<img class="author_img rounded-circle" src="" alt="">
											</div>
											<div class="media-body">
												<h4>
													<!-- 이름 -->
												</h4>
												<br>
												<h4>
													<!-- 날짜 -->
												</h4>
												<!--  <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>-->

											</div>
										</div>
										<p>
											<!-- 내용 -->
										</p>
									</div>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../common/footer.jsp"%>

	<script
		src="<%=request.getContextPath()%>/resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/vendor/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.ajaxchimp.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.nice-select.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.sticky.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/nouislider.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="<%=request.getContextPath()%>/resources/js/gmaps.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>







	<script>
	$(document).ready(function() {
		
				
		$(".primary-btn").on("click",function(){
			
		
				var selectedTime = $("#default-select option:selected").val();
				var selectedTimeText = $("#default-select option:selected").text();
						
				if(selectedTime == 0) {
						alert ("시간을 먼저 선택하세요");
						return false;
				} else {
							
					var pno = $(this).find("selectedTime").val();
					$("#exampleModal .modal-body .rt").text(selectedTimeText);
							  				
				}
									
			});
		
	});

	
	</script>

	<!-- 시간을 선택하였지만 마감된곳이 있다면 예약하기 버튼을 누를 수 없다-->

	<script>
	$(document).ready(function(){
		
		 $('#timeselct').change(function() {
		        var selectedTime = $(this).val(); // 선택한 시간 값
		        $.ajax({	
		            url : "ajax.time",
		            type : "get",
		            data : { tno : selectedTime, pno:"${pno}", matchingDate: "${matchingDate}"},
		            success : function(data) {
						console.log(data);
		                $("#totalPlayer").text(data.total);
		                $("#player").text(data.player);
		               
		                
		                if (data.player >= data.total) {
		                    // 인원 마감 시 버튼 비활성화
		                    $(".primary-btn").prop("disabled", true);
		                    alert("인원이 마감되었습니다.");
		                } else { //인원마감되지 않았지만 
		                	if(data.duplicate>0){ //중복이면 버튼 비활성화
		                		$(".primary-btn").prop("disabled", true);
			                    alert("중복예약입니다.");
		                	}else{ // 인원이 마감도 아니고 중복도 아니면 이제 예약
			                    $(".primary-btn").prop("disabled", false);
			                	$(".genric-btn.info").on("click",function(){
			            			var timeNo = $("#timeselct").val(); //시간
			            			var placeNo = $("#placeNo").val();//장소
			            			var reservationDate = $("#reservationDate").val();//날짜
			            			
			            			
			            			if(${loginUser == null} ){ //로그인을 하지 않았으면 로그인 페이지로 이동
			            				alert("로그인이 필요합니다. 로그인 페이지로 이동합니다");
			            				location.href="login.do";
			            				event.preventDefault();
			            				return false;
			            			}
			            			
			            			location.href="matching.en?timeNo="+timeNo+"&placeNo=${p.placeNo}&reservationDate=${matchingDate}";
			            			
			            		});
		                	}
		                  
		                }
		               
		            },
		            error : function() {
		                console.log("실패");
		            }
		        });
		    });
		});
	
	
	</script>



	<script>
	
	function orderByRecent(){
		
		$.ajax({
			 url: "ajax.review",
	         data: {pno: "${pno}"},
	         success: function(result){
	        	 
	        	 $(".review_list").html("");
	        	 
	        	 for (var i = 0; i < result.rlist.length; i++) {
	        		 
	        		    var stars = "";
	        		    
	        		    for (var j = 0; j < result.rlist[i].score; j++) {
	        		        stars += "<i class='fa fa-star'></i> ";
	        		    }
	        		    var reviewItem = $("<div class='review_item'>" +
	        		        "<div class='media'>" +
	        		        "<div class='d-flex'>" +
	        		        "<img src='" + '<%=request.getContextPath()%>' + "/resources/img/product/review.jpg' alt=''>" +
	        		        "</div>" +
	        		        "<div class='media-body'>" +
	        		        "<h4>" + result.rlist[i].reviewWriter + "</h4>" +
	        		        "<br>" +
	        		        "<h4>" + result.rlist[i].createDate + "</h4>" +
	        		        stars +
	        		        "</div>" +
	        		        "</div>" +
	        		        "<p>" + result.rlist[i].reviewContent + "</p>" +
	        		        "</div>");
	        		    
	        		    
	        		    $(".review_list").append(reviewItem);
	        		    
	        		    console.log(result.rlist);
	        		}

	         },
	         error: function(){
	         console.log("최신순 오류");
	         }
		});
		
	}	
	
	function orderByStar(){
		
		$.ajax({
			 url: "ajax.star",
	         data: {pno: "${pno}"},
	         success: function(result){
	        	 
	        	 $(".review_list").html("");
	        	 
	        	 for (var i = 0; i < result.slist.length; i++) {
	        		 
	        		    var stars = "";
	        		    
	        		    for (var j = 0; j < result.slist[i].score; j++) {
	        		        stars += "<i class='fa fa-star'></i> ";
	        		    }
	        		    var reviewItem = $("<div class='review_item'>" +
	        		        "<div class='media'>" +
	        		        "<div class='d-flex'>" +
	        		        "<img src='" + '<%=request.getContextPath()%>' + "/resources/img/product/review.jpg' alt=''>" +
	        		        "</div>" +
	        		        "<div class='media-body'>" +
	        		        "<h4>" + result.slist[i].reviewWriter+ "</h4>" +
	        		        "<br>" +
	        		        "<h4>" + result.slist[i].createDate + "</h4>" +
	        		        stars +
	        		        "</div>" +
	        		        "</div>" +
	        		        "<p>" + result.slist[i].reviewContent + "</p>" +
	        		        "</div>");
	        		    
	        		    
	        		    $(".review_list").append(reviewItem);
	        		    
	        		    console.log(result.slist);
	        		}

	         },
	         error: function(){
	         console.log("별점순 오류");
	         }
		});
		
	}
	
	
	
		
		$(function(){
			selectReviewList();
		});
	
		function selectReviewList(){
			
			
			 $.ajax({
				 url: "review.li",
		         data: {pno: "${pno}"},
		         success: function(result){
		        	 
		        	 var avg = (result.sum / result.count).toFixed(2);

		        	 
		        	 for (var i = 0; i < result.count; i++) {
		        		 
		        		    var stars = "";
		        		    for (var j = 0; j < result.rlist[i].score; j++) {
		        		    	
		        		    	
		        		        stars += "<i class='fa fa-star'></i> ";
		        		    }

		        		    var reviewItem = $("<div class='review_item'>" +
		        		        "<div class='media'>" +
		        		        "<div class='d-flex'>" +
		        		        "<img src='" + '<%=request.getContextPath()%>' + "/resources/img/product/review.jpg' alt=''>" +
		        		        "</div>" +
		        		        "<div class='media-body'>" +
		        		        "<h4>" + result.rlist[i].reviewWriter + "</h4>" +
		        		        "<br>" +
		        		        "<h4>" + result.rlist[i].createDate + "</h4>" +
		        		        stars +
		        		        "</div>" +
		        		        "</div>" +
		        		        "<p>" + result.rlist[i].reviewContent + "</p>" +
		        		        "</div>");
							
		        		    $(".review_list").append(reviewItem);
		        		}
		        	 
		        	 
		        	 $("#five span").text(result.fiveStar+"개");
		        	 $("#four span").text(result.fourStar+"개");
		        	 $("#three span").text(result.threeStar+"개");
		        	 $("#two span").text(result.twoStar+"개");
		        	 $("#one span").text(result.oneStar+"개");
		        	 $(".box_total h6").text("("+result.count+" Reviews)");
		        	 $("#count h3").text("Based on "+result.count+" Reviews");
		        	 $(".box_total h4").text(avg);
// 		              $(".box_total h6").text("("+result.length+" Reviews)");
// 		              $("#count h3").text("Based on "+result.length+" Reviews");
// 		              console.log(result.length);
		             
		            },
		            error: function(){
		                console.log("리뷰 오류");
		            }
		        });
			}
       
	
	</script>

	

	<script>
// 	$(document).ready(function(){
		
		
// 		selectRecentReview();
		
		
		
		
		
			
			
// 			$(".button-group-area #recent").on("click", function() {
				
// 				console.log(쿼리~);
				
// 		 		function selectRecentReview(){
					
// 				}
// 		 	}
			
			
			
			
			
			
			
			
// 		});
	
	
	 	
		
		
	</script>











</body>

</html>







