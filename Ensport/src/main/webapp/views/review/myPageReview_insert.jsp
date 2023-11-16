<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<c:set var="rd" value="${reviewDetail}"/>
<!DOCTYPE html>
<html>
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
	<link rel="stylesheet" href="${contextPath}/resources/css/linearicons.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/themify-icons.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/nice-select.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/nouislider.min.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="${contextPath}/resources/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="${contextPath}/resources/css/main.css">
</head>

<body>


	<!--================Product Description Area =================-->
	<section class="product_description_area vertical-center">
		<div class="container center">
			
				
				<div class="tab-pane fade show active" id="review" role="tabpanel" aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg-8 mx-auto">

							<!-- 리뷰 수정하기 -->
							<div class="review_box">
								<h4><b>리뷰 작성하기</b></h4>
								<form class="row contact_form" action="${contextPath }/insertMyReview.me" method="post" id="contactForm" novalidate="novalidate">
									<input type="hidden" name="playerNo" value="${playerNo}">
									<p style="padding-left:15px">My Score: </p>
									<ul class="list">
										<div class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="reviewScore" id="inlineRadio5" value="5" checked>
										  <label class="form-check-label" for="inlineRadio5">5</label>
										</div>
										<div class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="reviewScore" id="inlineRadio4" value="4">
										  <label class="form-check-label" for="inlineRadio4">4</label>
										</div>
										<div class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="reviewScore" id="inlineRadio3" value="3">
										  <label class="form-check-label" for="inlineRadio3">3</label>
										</div>
										<div class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="reviewScore" id="inlineRadio2" value="2">
										  <label class="form-check-label" for="inlineRadio2">2</label>
										</div>
										<div class="form-check form-check-inline">
										  <input class="form-check-input" type="radio" name="reviewScore" id="inlineRadio1" value="1">
										  <label class="form-check-label" for="inlineRadio1">1</label>
										</div>
									</ul>
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="reviewContent" id="myReviewContent"></textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="button" value="submit" class="primary-btn" id="insertMyReviewButton" onclick="return insertMyReviewDone();">등록완료</button>
										<button type="button" class="primary-btn" onclick="window.close();">닫기</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	

	<script src="${contextPath}/resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/vendor/bootstrap.min.js"></script>
	<script src="${contextPath}/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="${contextPath}/resources/js/jquery.nice-select.min.js"></script>
	<script src="${contextPath}/resources/js/jquery.sticky.js"></script>
	<script src="${contextPath}/resources/js/nouislider.min.js"></script>
	<script src="${contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="${contextPath}/resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="${contextPath}/resources/js/gmaps.min.js"></script>
	<script src="${contextPath}/resources/js/main.js"></script>
	
	
	
	
	
	<script type="text/javascript">
	
		$(function(){
			
		})
		
		
		function insertMyReviewDone(){
			
			var playerNo = ${playerNo};
			var score  = $("input[name=reviewScore]:checked").val();
			var reviewContent =$("#myReviewContent").val();
			
			//팝업창 부모 window
			var parentWindow = window.opener.location;
			
			
			if(confirm('리뷰를 등록하시겠습니까?')){
		
				$.ajax({
					url : "/ensport/insertMyReview.me",
					data : { 
						playerNo : playerNo,
						reviewScore : score,
						reviewContent : reviewContent
					},
					method : "post",
					success : function(result){
						
						console.log(result);
						
						alert('리뷰 등록이 완료되었습니다.');
						
						//팝업창 부모 window
						parentWindow.reload();
						
						location.href = 'myPageReviewDetail.me?reviewNo=' + result.reviewNo;
						
					},
					error : function(){
						console.log("오류");
					}
				});
	
			}else{
				return false;
			}
		
	}
		
	</script>
	
	

</body>

</html>