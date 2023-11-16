<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>리뷰 페이지</title>
	<!--
			CSS
			============================================= -->
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/linearicons.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/themify-icons.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/nice-select.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/nouislider.min.css">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/main.css">
</head>

<body>

	<%@ include file="../common/menubar.jsp" %> 

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>리뷰 작성</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	

	<!--================Product Description Area =================-->
	<section class="product_description_area vertical-center">
		<div class="container center">
			
			
				
				<div class="tab-pane fade show active" id="review" role="tabpanel" aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="review_box">
								<h4>리뷰 작성하기</h4>
								<p>Your Rating:</p>
								<ul class="list">
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
									<li><a href="#"><i class="fa fa-star"></i></a></li>
								</ul>
								<p>Outstanding</p>
								<form class="row contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="name" name="name" placeholder="Your Full name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Full name'">
										</div>
									</div>
									
									
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="message" id="message" rows="1" placeholder="Review" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Review'"></textarea></textarea>
										</div>
									</div>
									<div class="col-md-8 text-right">
										<button type="submit" value="submit" class="primary-btn">등록하기</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		
	</section>
	
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