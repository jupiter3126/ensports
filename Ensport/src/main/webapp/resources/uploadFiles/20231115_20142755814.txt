<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>메인페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!--
		CSS
		============================================= -->
<link rel="stylesheet" href="resources/css/linearicons.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/themify-icons.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/owl.carousel.css">
<link rel="stylesheet" href="resources/css/nice-select.css">
<link rel="stylesheet" href="resources/css/nouislider.min.css">
<link rel="stylesheet" href="resources/css/ion.rangeSlider.css" />
<link rel="stylesheet" href="resources/css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<link rel="stylesheet" href="resources/css/main.css">
<script src="resources/js/vendor/jquery-2.2.4.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script src="resources/js/vendor/bootstrap.min.js"></script>
<script src="resources/js/jquery.ajaxchimp.min.js"></script>
<script src="resources/js/jquery.nice-select.min.js"></script>
<script src="resources/js/jquery.sticky.js"></script>
<script src="resources/js/nouislider.min.js"></script>
<script src="resources/js/countdown.js"></script>
<script src="resources/js/jquery.magnific-popup.min.js"></script>
<script src="resources/js/owl.carousel.min.js"></script>
<!--gmaps Js-->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
<script src="resources/js/gmaps.min.js"></script>
<script src="resources/js/main.js"></script>


<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap5" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Brygada+1918:ital,wght@0,400;0,600;0,700;1,400&family=Inter:wght@400;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="resources/fonts/icomoon/style.css">
<link rel="stylesheet" href="resources/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="resources/css/tiny-slider.css">
<link rel="stylesheet" href="resources/css/aos.css">
<link rel="stylesheet" href="resources/css/flatpickr.min.css">
<link rel="stylesheet" href="resources/css/glightbox.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>

<body>

	<%@ include file="views/common/menubar.jsp"%>


	<!-- start banner Area -->
	<section class="banner-area">
		<div class="container">
			<div class="row fullscreen align-items-center justify-content-start">
				<div class="col-lg-12">
					<div class="active-banner-slider owl-carousel">
						<!-- single-slide -->
						<div class="row single-slide align-items-center d-flex">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>
										Ensport<br>soccer!
									</h1>
									<p>No pain no gain</p>
									<div class="add-bag d-flex align-items-center">
										<a class="add-btn" href="${contextPath }/place.so"><span
											class="lnr lnr-cross"></span></a> <span
											class="add-text text-uppercase">Go to play</span>
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="resources/img/banner/soccer.png"
										alt="">
								</div>
							</div>
						</div>
						<!-- single-slide -->
						<div class="row single-slide">
							<div class="col-lg-5">
								<div class="banner-content">
									<h1>
										Ensport<br>baseball!
									</h1>
									<p>No pain no gain</p>
									<div class="add-bag d-flex align-items-center">
										<a class="add-btn" href="${contextPath }/place.so"><span
											class="lnr lnr-cross"></span></a> <span
											class="add-text text-uppercase">Go to play</span>
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="resources/img/banner/baseball.png"
										alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<!--
	<!-- start features Area -->
	<section class="features-area section_gap">
		<div class="container">
			<div class="row features-inner">
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="resources/img/features/icon-baseball-field1.png" alt="">
						</div>
						<h6>Baseball field</h6>
						<p>It ain't over till it's over.</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="resources/img/features/icon-soccer-field2.png" alt="">
						</div>
						<h6>Soccer field</h6>
						<p>love what you have.</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="resources/img/features/free-icon-basebal3.png" alt="">
						</div>
						<h6>Baseball matching</h6>
						<p>No pain no gain.</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="resources/img/features/free-icon-soccer-player4.png"
								alt="">
						</div>
						<h6>Soccer matching</h6>
						<p>Slow and steady win the race.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end features Area -->

	<!-- Start category Area -->
	<section class="category-area">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-md-12">
					<div class="row">
						<div class="col-lg-8 col-md-8">
							<div class="single-deal">
								<div class="overlay"></div>
								<img class="img-fluid w-100" src="resources/img/category/1.png"
									alt=""> <a href="resources/img/category/1.png"
									class="img-pop-up" target="_blank">
									<div class="deal-details">
										<h6 class="deal-title">Sneaker for Sports</h6>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-4 col-md-4">
							<div class="single-deal">
								<div class="overlay"></div>
								<img class="img-fluid w-100" src="resources/img/category/2.png"
									alt=""> <a href="resources/img/category/2.png"
									class="img-pop-up" target="_blank">
									<div class="deal-details">
										<h6 class="deal-title">Sneaker for Sports</h6>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-4 col-md-4">
							<div class="single-deal">
								<div class="overlay"></div>
								<img class="img-fluid w-100" src="resources/img/category/3.png"
									alt=""> <a href="resources/img/category/3.png"
									class="img-pop-up" target="_blank">
									<div class="deal-details">
										<h6 class="deal-title">Product for Couple</h6>
									</div>
								</a>
							</div>
						</div>
						<div class="col-lg-8 col-md-8">
							<div class="single-deal">
								<div class="overlay"></div>
								<img class="img-fluid w-100" src="resources/img/category/4.png"
									alt=""> <a href="resources/img/category/4.png"
									class="img-pop-up" target="_blank">
									<div class="deal-details">
										<h6 class="deal-title">Sneaker for Sports</h6>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-deal">
						<div class="overlay"></div>
						<img class="img-fluid w-100" src="resources/img/category/5.png"
							alt=""> <a href="resources/img/category/5.png"
							class="img-pop-up" target="_blank">
							<div class="deal-details">
								<h6 class="deal-title">Sneaker for Sports</h6>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End category Area -->
	
	<img src="resources/img/공간.png" alt="">
		
	<!-- start product Area -->
	<section class="owl-carousel active-product-area section_gap">
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>업데이트순</h1>
							<p>지금 바로 올라온 경기장! 누구보다 빠르게 만나보시죠</p>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
							<div class="col-lg-4 col-md-4" id="updateSort" style="display: contents;">	
								
							<div class="single-product">
									<script>							
							$(function(){
								
								$.ajax({
									url: "updateAjax2.do",
									type : "get",
									success : function(data){
										
										//값 뽑기
										console.log("업데이트");
										console.log(data);
										
		// 				                var resultDiv = $("#resultCount");
						                $.each(data, function(index, item) {
						                	
						                	$(".row>#updateSort").append(
						                			
						                			"<div class='single-product' style='margin: 15px;'>" +
						                			"<div class='col-md-13 figure'>" +
							                        "<img class='img-fluid' src='${contextPath}" + item.filePath + item.changeName + "' alt='' style=' width: 250px;height: 200px;'>" +
							                        "<div class='product-details'>" +
							                        "<h6>" + item.placeName + "</h6>" +
							                        "<div class='prd-bottom'>" +
							                        "<a href='${contextPath}/place.so' class='social-info'>" +
							                        "<span class='lnr lnr-move'></span>" +
							                        "<p class='hover-text'>예약하기</p>" +
							                        "</a>" +
							                        "</div>" +
							                        "</div>" +
							                        "</div>"+
							                        "</div>"
						                	
						                	);
						                    
		
		// 				                    resultDiv.append(html);
						                });
										
		
										
									},error : function(){
										console.log("실패");
									}
								});
								
							})														
							</script>		
						
					
						</div>
					</div>					
				</div>
			</div>
		</div>
		
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container" >
				<div class="row justify-content-center" >
					<div class="col-lg-6 text-center" >
						<div class="section-title" >
							<h1>조회순</h1>
							<p>지금 인기있는 매치 예약하러 가보실까요~?</p>
						</div>
					</div>
				</div>
				<div class="row" >
					
					<!-- single product -->
					<div class="col-lg-4 col-md-4" id="resultCount"	style="display: contents;">

					<div class="single-product">
					
<!-- 					========================================= -->
<!-- 				    <div id="result"> -->
<!-- 				        Ajax로 받아온 JSON 데이터를 여기에 넣을 예정 -->
<!-- 				    </div> -->
<!-- 					========================================= -->


						<script>
						
						$(function(){
							
							$.ajax({
								url: "ajax1.do",
								type : "get",
								success : function(data){
									
									//값 뽑기
									console.log(data);
									
// 				                var resultDiv = $("#resultCount");
					                $.each(data, function(index, item) {
					                	
					                	$(".row>#resultCount").append(
					                			
					                			"<div class='single-product' style='margin: 15px;'>" +
					                			"<div class='col-md-13 figure'>" +
						                        "<img class='img-fluid' src='${contextPath}" + item.filePath + item.changeName + "' alt='' style=' width: 250px;height: 200px;'>" +
						                        "<div class='product-details'>" +
						                        "<h6>" + item.placeName + "</h6>" +
						                        "<div class='prd-bottom'>" +
						                        "<a href='${contextPath}/list.so' class='social-info'>" +
						                        "<span class='lnr lnr-move'></span>" +
						                        "<p class='hover-text'>예약하기</p>" +
						                        "</a>" +
						                        "</div>" +
						                        "</div>" +
						                        "</div>"+
						                        "</div>"
					                	
					                	);
					                    
	
	// 				                    resultDiv.append(html);
					                });
									
	
									
								},error : function(){
									console.log("실패");
								}
							});
							
						})
						
						
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<!-- end product Area -->

	<div class="section">

		<div class="section bg-light">

			<h2 class="heading mb-5 text-center">이용 후기</h2>

			<div class="text-center mb-5">
				<div id="prevnext-testimonial">
					<span class="prev me-3" data-controls="prev"> <span
						class="icon-chevron-left"></span>

					</span> <span class="next" data-controls="next"> <span
						class="icon-chevron-right"></span>

					</span>
				</div>
			</div>

			<div class="wide-slider-testimonial-wrap">
				<div class="wide-slider-testimonial">
					<div class="item">
						<blockquote class="block-testimonial">
							<div class="author">
								<img src="resources/img/person_1.jpg"
									alt="Free template by TemplateUX">
								<h3>John Doe</h3>
								<p class="position mb-5">CEO, Founder</p>
							</div>
							<p>
							<div class="quote">&ldquo;</div> 
							&ldquo;Far far away, behind the word mountains, far from the
							countries Vokalia and Consonantia, there live the blind texts.
							Separated they live in Bookmarksgrove right at the coast of the
							Semantics, a large language ocean.&rdquo;
							</p>
						</blockquote>
					</div>

					<div class="item">
						<blockquote class="block-testimonial">
							<div class="author">
								<img src="resources/img/person_2.jpg"
									alt="Free template by TemplateUX">
								<h3>James Woodland</h3>
								<p class="position mb-5">Designer at Facebook</p>
							</div>
							<p>
							<div class="quote">&ldquo;</div>
							&ldquo;When she reached the first hills of the Italic Mountains,
							she had a last view back on the skyline of her hometown
							Bookmarksgrove, the headline of Alphabet Village and the subline
							of her own road, the Line Lane. Pityful a rethoric question ran
							over her cheek, then she continued her way.&rdquo;
							</p>

						</blockquote>
					</div>

					<div class="item">
						<blockquote class="block-testimonial">
							<div class="author">
								<img src="resources/img/person_3.jpg"
									alt="Free template by TemplateUX">
								<h3>Rob Smith</h3>
								<p class="position mb-5">Product Designer at Twitter</p>
							</div>
							<p>
							<div class="quote">&ldquo;</div>
							&ldquo;A small river named Duden flows by their place and
							supplies it with the necessary regelialia. It is a paradisematic
							country, in which roasted parts of sentences fly into your
							mouth.&rdquo;
							</p>
						</blockquote>
					</div>

					<div class="item">
						<blockquote class="block-testimonial">
							<div class="author">
								<img src="resources/img/person_1.jpg"
									alt="Free template by TemplateUX">
								<h3>John Doe</h3>
								<p class="position mb-5">CEO, Founder</p>
							</div>
							<p>
							<div class="quote">&ldquo;</div>
							&ldquo;Far far away, behind the word mountains, far from the
							countries Vokalia and Consonantia, there live the blind texts.
							Separated they live in Bookmarksgrove right at the coast of the
							Semantics, a large language ocean.&rdquo;
							</p>
						</blockquote>
					</div>

					<div class="item">
						<blockquote class="block-testimonial">
							<div class="author">
								<img src="resources/img/person_2.jpg"
									alt="Free template by TemplateUX">
								<h3>James Woodland</h3>
								<p class="position mb-5">Designer at Facebook</p>
							</div>
							<p>
							<div class="quote">&ldquo;</div>
							&ldquo;When she reached the first hills of the Italic Mountains,
							she had a last view back on the skyline of her hometown
							Bookmarksgrove, the headline of Alphabet Village and the subline
							of her own road, the Line Lane. Pityful a rethoric question ran
							over her cheek, then she continued her way.&rdquo;
							</p>

						</blockquote>
					</div>

					<div class="item">
						<blockquote class="block-testimonial">
							<div class="author">
								<img src="resources/img/person_3.jpg"
									alt="Free template by TemplateUX">
								<h3>Rob Smith</h3>
								<p class="position mb-5">Product Designer at Twitter</p>
							</div>
							<p>
							<div class="quote">&ldquo;</div>
							&ldquo;A small river named Duden flows by their place and
							supplies it with the necessary regelialia. It is a paradisematic
							country, in which roasted parts of sentences fly into your
							mouth.&rdquo;
							</p>
						</blockquote>
					</div>
				</div>
			</div>

		</div>
		
	
		
		
		<!-- /.untree_co-section -->

		<script src="resources/js/bootstrap.bundle.min.js"></script>
		<script src="resources/js/tiny-slider.js"></script>
		<script src="resources/js/aos.js"></script>
		<script src="resources/js/navbar.js"></script>
		<script src="resources/js/counter.js"></script>
		<script src="resources/js/rellax.js"></script>
		<script src="resources/js/flatpickr.js"></script>
		<script src="resources/js/glightbox.min.js"></script>
		<script src="resources/js/custom.js"></script>

		<%@ include file="views/common/footer.jsp"%>
</body>

</html>
