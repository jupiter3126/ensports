<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="col-lg-4">
		<div class="blog_right_sidebar">
			<aside class="single_sidebar_widget search_widget align-self-center">
				<img class="" src="resources/img/elements/soccer_icon1.png" alt="">
				<span class="mx-auto" data-toggle="tooltip" data-placement="bottom" title="
					Level 1. 아기 스포츠단
					Level 2. 동호회 에이스
					Level 3. 국내리그 유망주
					Level 4. 
				
				">
					<b id="myEnsportsLevel"></b>
				</span>
				<div class="br"></div>
			</aside>
			<aside class="single_sidebar_widget author_widget">
				<img class="author_img rounded-circle" src="${contextPath}/resources/img/blog/sonny.jpg" alt="" >
				<h4><i class="bi bi-person-fill"></i> ${m.userNickname }</h4>
				<div class="social_icon">
					<p>${m.email}</p>
				</div>
				<div class="br"></div>
			</aside>
			<aside class="single_sidebar_widget post_category_widget">
				<h4 class="widget_title">내가 쓴 글</h4>
				<ul class="list cat-list">
					<li>
						<a href="${contextPath }/myPageBoard.me?currentPage=1"	class="d-flex justify-content-between">
							<p>게시글</p>
							<p id="boardCount"></p>
						</a>
					</li>
					<li>
						<a href="${contextPath }/myPageReply.me?currentPage=1" class="d-flex justify-content-between">
							<p>댓글</p>
							<p id="replyCount"></p>
						</a>
					</li>
					<li>
						<a href="${contextPath }/myPageReview.me?currentPage=1" class="d-flex justify-content-between">
						<p>리뷰</p>
						<p id="reviewCount"></p>
					</a>
					</li>
					<li>
						<a href="${contextPath }/myPageQa.me?currentPage=1" class="d-flex justify-content-between">
							<p>문의사항</p>
							<p id="qaCount"></p>
						</a>
					</li>
				</ul>
				<div class="br"></div>
			</aside>

			<!-- 내 경기 정보 -->
			<aside class="single_sidebar_widget post_category_widget">
				<h4 class="widget_title">나의 예약</h4>
				<ul class="list cat-list">
					<li>
						<a href="${contextPath }/myPageReservation.me?currentPage=1" class="d-flex justify-content-between">
							<p>예약 내역</p>
							<p id="reservationCount"></p>
						</a>
					</li>
<!-- 				<li> -->
<!-- 					이건 후순위 구현하는 것으로 -->
<!-- 					<a href="#" class="d-flex justify-content-between">W -->
<!-- 						<p>나의 지난 경기</p> -->
<!-- 						<p>0</p> -->
<!-- 					</a> -->
<!-- 				</li> -->
				</ul>
				<div class="br"></div>
			</aside>

			<!-- 내 경기 정보 -->
<!-- 			<aside class="single_sidebar_widget post_category_widget"> -->
<!-- 				<h4 class="widget_title">나의 캐시</h4> -->
<!-- 				<ul class="list cat-list"> -->
<!-- 					<li><a href="#" class="d-flex justify-content-between"> -->
<!-- 							<p>캐시 충전하기 (후순위)</p> -->
<!-- 							<p>0 ￦</p> -->
<!-- 					</a></li> -->
<!-- 				</ul> -->
<!-- 			</aside> -->
		</div>
	</div>
	
	
	<script type="text/javascript">
	
		$(function(){
			
			
			$('[data-toggle="tooltip"]').tooltip();
			
			
			let userId = "${m.userId}";
			let userNo = ${m.userNo};
			
			$.ajax({
				url: "myPageProfile.me",
				data: { userNo : userNo,
						userId : userId
				},
				success: function(result){
					
// 					console.log("=============");
// 					console.log(result);
// 					console.log("=============");
					
					//JSON data로 변환
					var data = JSON.parse(result);
					
					$("#boardCount").text(data.boardCount);
					$("#replyCount").text(data.replyCount);
					$("#qaCount").text(data.qaCount);
					$("#reviewCount").text(data.reviewCount);
					$("#reservationCount").text(data.reservationCount);
					
					
					var rvCount = data.reviewCount;
					
					//등급 산정하기
					if(rvCount < 4){
						$("#myEnsportsLevel").text("Lv 1. 아기 스포츠단");
					}else if(rvCount < 8){
						$("#myEnsportsLevel").text("Lv 2. 우리동네 에이스");
					}else if(rvCount < 13){
						$("#myEnsportsLevel").text("Lv 3. 동호회 ");
					}else if(rvCount < 19){
						$("#myEnsportsLevel").text("Lv 4. 국내리그 유망주");
					}else{
						$("#myEnsportsLevel").text("Lv 5. Ensports 선정 우주제일운동스타");
					}
					
				},
				error: function(){
					console.log("불러오기 실패");	
				}
				
			});
			
		});
	
	</script>
	

</body>
</html>