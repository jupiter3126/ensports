<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
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
	<title>My Page</title>

<style>
	.pdt-7{ padding-top : 7px; }
	.pdb-7{ padding-bottom : 7px; }
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
                        <a href="${contextPath }/myPage.me">마이 페이지</a>
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
				
				
				<!-- ====================### 내 정보 수정하기 ###======================== -->
                <div class="col-lg-8 posts-list">
                    <div class="row">
                        <div class="col-md-12">
                            <h3>MY INFORMATION</h3>
                            <form class="row contact_form" id="myInformationForm" action="${contextPath}/memberUpdate.me" method="post" novalidate="novalidate" style="margin-top: 40px;">
								 <input type="hidden" name="userNo" value="${loginUser.userNo}">
                                
                                <!-- ID -->
                                <span class="col-md-4 pdt-7">아이디</span>
                                <div class="col-md-8 form-group p_star">
                                    <input type="text" class="form-control" id="userId" name="userId" placeholder="ID" value="${loginUser.userId}" readonly>
                                    <span class="placeholder"></span>
                                </div>                             
    							
    							<span class="col-md-4 pdt-7">이름</span>
                                <div class="col-md-8 form-group p_star">
                                    <input type="text" class="form-control" id="userName" name="userName" value="${loginUser.userName}" placeholder="이름">
                                    <span class="placeholder"></span>
                                </div>
                                
                                <!-- 전화번호 -->
    							<span class="col-md-4 pdt-7">전화번호</span>
                                <div class="col-md-8 form-group p_star">
                                    <input type="text" class="form-control" id="phone" name="phone" placeholder="전화번호" value="${loginUser.phone}" readonly>
                                    <span class="placeholder"></span>
                                </div>
                                
    
                                <!-- 주소 -->
                                <span class="col-md-4 pdt-7">주소</span>
                                <div class="col-md-6 form-group p_star">
                                    <input type="text" class="form-control" id="address" name="address" placeholder="주소" value="${loginUser.address}" readonly>
                                    <span class="placeholder"></span>
                                </div>
    
                                <!-- 주소 검색 버튼 -->
                                <div class="button-group-area" id="address_kakao">
                                    <a href="#" class="genric-btn primary mt-0">주소검색</a>
                                </div>
                                
                                <!-- 상세주소 -->
                                <span class="col-md-4 pdt-7"></span>
                                <div class="col-md-8 form-group">
                                    <input type="text" class="form-control" id="addressDetail" name="addressDetail" placeholder="상세주소" value="${loginUser.addressDetail}">
                                    <span class="placeholder"></span>
                                </div>
                                                                
                                
                                <script type="text/javascript">
                                    window.onload = function(){
                                        document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
                                            
                                            event.preventDefault(); // 링크의 기본 동작을 중지
                                            //카카오 지도 발생
                                            new daum.Postcode({
                                                oncomplete: function(data) { //선택시 입력값 세팅
                                                    document.getElementById("address").value = data.address; 	// 주소 넣기
                                                    document.querySelector("input[name=addressDetail]").focus(); //상세입력 포커싱
                                                }
                                            }).open();
                                        });
                                    }
                                </script>
    
    
                              <!-- 이메일 -->
                              <span class="col-md-4 pdt-7">이메일</span>
                               <div class="col-md-8 form-group p_star">
                                  <input type="text" class="form-control" id="email" name="email" value="${loginUser.email}" placeholder="이메일 (example@example.kr)">
                                  <span class="placeholder"></span>
                              </div>

                              <!-- 성별 -->
                              <span class="col-md-4 pdt-7">성별</span>
                              <div class="col-md-8 form-group p_star">
                                  <select class="country_select" name="gender" id="gender">
                                     <option value="">-- 성별 선택 --</option>
                                     <option value="M">남자</option>
                                     <option value="F">여자</option>
                                  </select>
                              </div>

                                
                                <!-- 별명 -->
                                <div class="col-md-4 pdt-7"><span>별명</span></div>
                                <div class="col-md-8 form-group">
                                    <input type="text" class="form-control" id="userNickname" name="userNickname" placeholder="별명" value="${loginUser.userNickname}">
                                    <span class="placeholder"></span>
                                </div>
    
                                <!-- 선호하는 종목 -->
                                <div class="col-md-12 form-group d-flex mt-50 pdt-7">
                                    <div class="col-md-3 single-element-widget">
                                        <h5 class="mb-30 "><b>선호하는 종목</b></h5>
                                        <div class="switch-wrap d-flex justify-content-between">
                                            <p>축구</p>
                                            <div class="primary-checkbox">
                                                <input type="checkbox" id="soccer" name="prefer" value="축구">
                                                <label for="soccer"></label>
                                            </div>
                                        </div>
                                        <div class="switch-wrap d-flex justify-content-between">
                                            <p>야구</p>
                                            <div class="primary-checkbox">
                                                <input type="checkbox" id="baseball" name="prefer" value="야구">
                                                <label for="baseball"></label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
    
                                <div class="col-md-12 form-group p_star">
                                    <div class="row contact_form">
                                        <div class="col-md-12 text-center mt-50">
                                            <button type="submit" value="" class="primary-btn" onclick="return memberUpdate();">정보 수정</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            
                            
                            <!-- ### 내 정보 수정하기 ### -->
                            <form class="row contact_form" id="myChangePwdForm" action="${contextPath}/changePwd.me" method="post" novalidate="novalidate" style="display: none; margin-top: 40px;">
								<input type="hidden" name="userNo" value="${loginUser.userNo}">
                                
                                <!-- 현재 비밀번호 -->
                                <span class="col-md-4 pdt-7">현재 비밀번호</span>
                                <div class="col-md-8 form-group">
                                    <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="현재 비밀번호">
                                    <span class="placeholder"></span>
                                </div>                             
    							
    							<!-- 새로운 비밀번호 -->
    							<span class="col-md-4 pdt-7">새로운 비밀번호</span>
                                <div class="col-md-8 form-group">
                                    <input type="password" class="form-control" id="newUserPassword" name="newUserPassword" placeholder="새로운 비밀번호 (4~15자리 영문 및 숫자 조합)">
                                    <span class="placeholder"></span>
                                </div>
                                
                                <!-- 새로운 비밀번호 확인 -->
    							<span class="col-md-4 pdt-7">새로운 비밀번호 확인</span>
                                <div class="col-md-8 form-group">
                                    <input type="password" class="form-control" id="newUserPasswordChk" name="newUserPasswordChk" placeholder="새로운 비밀번호 확인 (4~15자리 영문 및 숫자 조합)">
                                    <span class="placeholder"></span>
                                </div>
    
                                <div class="col-md-12 form-group p_star">
                                    <div class="row contact_form">
                                        <div class="col-md-12 text-center mt-50">
                                            <button type="submit" class="primary-btn" onclick="return changePwdDone();">비밀번호 변경하기</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            
                        </div>
                    </div>
	                <div class="blog_post">
	                   <div class="blog_details text-right">
	                       <a href="#" class="white_bg_btn" id="changePwdbtn" onclick="changePwdForm();">비밀번호 변경</a>
	                       <a href="#" class="white_bg_btn" data-toggle="modal" data-target="#memberDelete">회원 탈퇴하기</a>
	                   </div>
	                </div>
                </div>
                <!-- ====================### 내 정보 수정하기 ###======================== -->
                
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
	
	
	
	
	
	
	<!--=============== #### 회원탈퇴 모달 #### ===============-->4
	<!-- The Modal -->
	<div class="modal fade" id="memberDelete" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title text-center" id="staticBackdropLabel"><b>ENSPORT 회원 탈퇴</b></h4>
	      </div>
	      <div class="modal-body">
			<div class="col-md-12">
				<div class="text-left pdb-7"><h4><b>환불 규정 동의</b></h4></div>
				<blockquote class="generic-blockquote" style="overflow: scroll; overflow-x: hidden; height: 150px;">
					KH정보교육원 회원 약관 제 1 장 총칙 제 1 조 목적 이 약관은 KH정보교육원이 제공하는 서비스인
					http://www.iei.or.kr의 이용조건 및 절차에 관한 사항과 기타 필요한 사항을 규정함을 목적으로 합니다.
					제 2 조 약관의 효력과 변경 1) 약관은 이용자에게 공시함으로써 효력을 발생합니다. 2) KH정보교육원은 교육원
					사정상 변경의 경우와 영업상 중요사유가 있을 때 약관을 변경할 수 있으며, 변경된 약관은 전항과 같은 방법으로 효력을
					발생합니다. 제 3 조 약관 외 준칙 이 약관에 명시되지 않은 사항이 관계법령에 규정되어 있을 경우에는 그 규정에
					따릅니다.KH정보교육원 회원 약관 제 1 장 총칙 제 1 조 목적 이 약관은 KH정보교육원이 제공하는 서비스인
					http://www.iei.or.kr의 이용조건 및 절차에 관한 사항과 기타 필요한 사항을 규정함을 목적으로 합니다.
					제 2 조 약관의 효력과 변경 1) 약관은 이용자에게 공시함으로써 효력을 발생합니다. 2) KH정보교육원은 교육원
					사정상 변경의 경우와 영업상 중요사유가 있을 때 약관을 변경할 수 있으며, 변경된 약관은 전항과 같은 방법으로 효력을
					발생합니다. 제 3 조 약관 외 준칙 이 약관에 명시되지 않은 사항이 관계법령에 규정되어 있을 경우에는 그 규정에
					따릅니다.
				</blockquote>
				<div class="col-lg-8 mx-auto">
					<div class="single-element-widget">
						<div class="switch-wrap d-flex justify-content-around" style="margin:30px auto">
							<h5>환불 규정에 동의합니다.</h5>
							<div class="primary-checkbox">
								<input type="checkbox" id="cashRefundAgree" name="">
								<label for="cashRefundAgree"></label>
							</div>
						</div>
					</div>
				</div>
			</div>
            <div class="col-md-12 form-group">
				<div class="text-left pdb-7"><h4><b>해당 계정 비밀번호 확인</b></h4></div>
                <input type="password" class="form-control" id="deletePwdChk" name="deletePwdChk" placeholder="비밀번호 작성하세요">
                <span class="placeholder"></span>
            </div>
		</div>	
	      <div class="modal-footer">
			<div class="button-group-area mt-40 text-center">
				<a href="#" class="genric-btn primary" onclick="memberDeleteDone();">회원 탈퇴하기</a>	<!--  data-dismiss="modal" : alert작동시 modal 닫힘. (삭제) -->
				<a href="#" class="genric-btn primary close" data-dismiss="modal">닫기</a>
			</div>
	      </div>
	    </div>
	  </div>
	</div>
	<!--=============== #### 회원탈퇴 모달 #### ===============-->





	<script type="text/javascript">
		//성별 선택하기
		document.addEventListener('DOMContentLoaded', function() {
			var gender = "${loginUser.gender}";
			var selectElement = document.getElementById('gender');

			if (gender === 'M') {
				// 'M'를 선택
				for (var i = 0; i < selectElement.options.length; i++) {
					if (selectElement.options[i].value === 'M') {
						selectElement.options[i].selected = true;
						break;
					}
				}
			} else if (gender === 'F') {
				// 'F'를 선택
				for (var i = 0; i < selectElement.options.length; i++) {
					if (selectElement.options[i].value === 'F') {
						selectElement.options[i].selected = true;
						break;
					}
				}
			}
		});

		//선호종목 체크박스
		document.addEventListener('DOMContentLoaded', function() {
			var prefers = "${loginUser.prefer}";
			var inputElements = document
					.querySelectorAll('input[name="prefer"]');

			// 순차적으로 요소를 확인하며 처리
			inputElements.forEach(function(inputElement) {
				var value = inputElement.value;

				// loginUser.prefer에 현재 value가 포함되어 있는지 확인
				if (prefers.includes(value)) {
					// 값이 있다면 현재 요소에 checked 속성을 추가
					inputElement.checked = true;
				}
			});
		});

		//회원정보 수정하기
		function memberUpdate() {

			var userName = $("#userName").val();
			var address = $("#address").val();
			var email = $("#email").val();
			var gender = $("#gender").val();

			if (confirm("회원 정보를 수정하시겠습니까?")) {

				if (userName == '' || userName == null) {
					alert('이름을 입력하세요.');
					return false;
				}
				if (address == '' || address == null) {
					alert('주소를 입력하세요.');
					return false;
				}
				if (email == '' || email == null) {
					alert('이메일을 입력하세요.');
					return false;
				} else {

					var regExp = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

					if (!regExp.test(email)) {
						alert("이메일 형식이 올바르지 않습니다.");
						$("#email").focus(); //해당 요소에 포커스
						return false;
					}

				}

				if (gender == '' || gender == null) {
					alert('성별을 입력하세요.');
					return false;
				}

				return true;
			} else {
				return false;
			}
		}

		//회원 비밀번호 창 띄우기
		function changePwdForm() {
			$("#myInformationForm").hide();
			$("#changePwdbtn").hide();

			$("#myChangePwdForm").css("display", "");
			$("#userPassword").focus();

		}

		
		//회원 비밀번호 변경
		function changePwdDone() {

			var userPwd = $("#userPassword").val();
			var newPwd = $("#newUserPassword").val();
			var newPwdChk = $("#newUserPasswordChk").val();

			console.log(newPwd);
			console.log(newPwdChk);

			//현재 비밀번호 값이 비어있음
			if (userPwd == null || userPwd == '') {
				alert("비밀번호를 입력하세요");
				return false;
			} else {

				var regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,15}$/;

				if (!regExp.test(newPwd)) { //변경 비밀번호가 4~15조합 아닐때
					alert("비밀번호는 4~15자리 영문 및 숫자 조합이어야 합니다.");
					$("#newUserPassword").focus(); //해당 요소에 포커스 된다.
					return false;
				}

				//새 비밀번호랑 비밀번호 확인이 불일치할때
				if (newPwd != newPwdChk) {
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
			}

			if (confirm("비밀번호를 변경하시겠습니까?")) {
				return true;
			} else {
				return false;
			}

		}
		

		//회원 탈퇴
		function memberDeleteDone() {
			const delPwd = $("#deletePwdChk").val();
			const userNo = "${loginUser.userNo}";
			
			//환불규정 비동의시
			if (!($("#cashRefundAgree").is(":checked"))) {
				alert('환불 규정에 동의하세요.');
				return false;
			}

			//비밀번호 기입 안했을 시
			if (delPwd == null || delPwd == '') {
				alert('비밀번호를 작성하세요.');
				$("#deletePwdChk").focus();
				return false;
			}
			
			//회원탈퇴 여부
			if (confirm('회원 탈퇴하시겠습니까?\n탈퇴시 해당 아이디 및 전화번호로 재가입이 불가합니다.')) { //yes
				location.href = '${contextPath}/memberDelete.me?userNo='+ userNo +'&password=' + delPwd;
			}

			return false;
		}
	</script>




	<!--================ footer =================-->
    <%@ include file="../common/footer.jsp" %>
    
    
 
</body>
</html>