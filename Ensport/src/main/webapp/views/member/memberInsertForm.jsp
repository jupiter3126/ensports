<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

	<%@ include file="../common/menubar.jsp" %>
	
    <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>회원가입</h1>
                    <nav class="d-flex align-items-center">
                        <a href="${contextPath }">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="${contextPath }/memberInsert.do">회원가입</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->



    <!--================Checkout Area =================-->
    <section class="checkout_area section_gap">
        <div class="container">

            <div class="billing_details">
                <div class="row">
                    <div class="col-lg-8  mx-auto">
                        <h2>Member Entrance</h2>
                        <form class="row contact_form" action="${contextPath }/memberInsert.do" method="post" novalidate="novalidate" style="margin-top: 40px;">
                            
                            
                            <!-- ID -->
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="userId" name="userId" placeholder="ID (6~10자리 영문 및 숫자 조합)">
                                <span class="placeholder" data-placeholder=""></span>
                            </div>
                            <!-- 중복확인 버튼 -->
                            <div class="button-group-area">
                                <a href="#" class="genric-btn primary mt-0" id="idDuplCheck" onclick="idDuplCheck();">중복확인</a>
                            </div>
                            

							<div class="col-md-12 form-group p_star">
                                <input type="text" class="form-control" id="userName" name="userName" placeholder="이름">
                                <span class="placeholder"></span>
                            </div>
                            
							<!-- 비밀번호 -->
                            <div class="col-md-12 form-group p_star">
                                <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="비밀번호 (6~15자리 영문 및 숫자 조합)">
                                <span class="placeholder"></span>
                            </div>
                            <div class="col-md-12 form-group p_star">
                                <input type="password" class="form-control" id="userPasswordChk" name="userPasswordChk" placeholder="비밀번호 확인">
                                <span class="placeholder" ></span>
                            </div>
                            
                            <!-- 전화번호 -->
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="전화번호">
                                <span class="placeholder"></span>
                            </div>
                            <!-- 중복확인 버튼 -->
                            <div class="button-group-area">
                                <a href="#" class="genric-btn primary mt-0" id="phoneDuplCheck" onclick="phoneDuplCheck();">중복확인</a>
                            </div>
                            

                            <!-- 주소 -->
                            <div class="col-md-6 form-group p_star">
                                <input type="text" class="form-control" id="address" name="address" placeholder="주소" readonly>
                                <span class="placeholder"></span>
                            </div>

                            <!-- 주소 검색 버튼 -->
                            <div class="button-group-area" id="address_kakao">
                                <a href="#" class="genric-btn primary mt-0">주소검색</a>
                            </div>
                            <div class="col-md-12 form-group">
                                <input type="text" class="form-control" id="addressDetail" name="addressDetail" placeholder="상세주소">
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
                           <div class="col-md-12 form-group p_star">
                              <input type="text" class="form-control" id="email" name="email" placeholder="이메일 (example@example.kr)">
                              <span class="placeholder"></span>
                          </div>
                           
                           
                          <!-- 성별 -->
							<div class="col-md-12 form-group p_star">
							    <select class="country_select" name="gender" id="gender">
							        <option value="">-- 성별 선택 --</option>
							        <option value="M">남자</option>
							        <option value="F">여자</option>
							    </select>
							</div>


		<%--					<div class="col-md-12 form-group p_star" style="display: flex;">
								<input type="text" class="form-control1" id="email" name="email" style="border: 1px solid #EEEEEE"> &nbsp;@&nbsp;
								<input type="text" class="form-control1" id="email" name="email" style="border: 1px solid #EEEEEE">
								<select name="email" size="1" class="form-control2" style="border: 1px solid #EEEEEE;" onchange="return checkEmail();">
									<option value="">직접 입력</option>
									<option value="naver.com">naver.com</option>
									<option value="daum.net">daum.net</option>
									<option value="nate.com">nate.com</option>
								</select>
							</div> --%>
							
							
                            
                            
                            <div class="row contact_form mx-auto">
                               <div class="col-md-12 text-center mt-50">
                                   <h3 class="mx-auto" style="margin: 30px 0;"><b>선택사항</b></h3>
                               </div>
                           </div>
                            
                            <!-- 별명 -->
							<div class="col-md-12 form-group mt-50 ml-50">
                                <input type="text" class="form-control" id="userNickname" name="userNickname" placeholder="별명">
                                <span class="placeholder" ></span>
                            </div>

							<!-- 선호하는 종목 -->
                            <div class="col-xl-12 form-group d-flex mt-50">
                                <div class="col-md-4 single-element-widget">
                                    <h3 class="mb-30">선호하는 종목</h3>
                                    <div class="switch-wrap d-flex justify-content-between">
                                        <p>축구</p>
                                        <div class="primary-checkbox">
                                            <input type="checkbox" id="default-checkbox" name="prefer" value="축구">
                                            <label for="default-checkbox"></label>
                                        </div>
                                    </div>
                                    <div class="switch-wrap d-flex justify-content-between">
                                        <p>야구</p>
                                        <div class="primary-checkbox">
                                            <input type="checkbox" id="primary-checkbox" name="prefer" value="야구">
                                            <label for="primary-checkbox"></label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-12 form-group p_star">
                                <div class="row contact_form">
                                    <div class="col-md-12 text-center mt-50">
                                        <button type="submit" value="" class="primary-btn" onclick="return memberEnroll();">회원가입</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Checkout Area =================-->
	
	
	
	<script type="text/javascript">
	
	
		var idcheck = false;
		var phoncheck = false;
		
	
		function idDuplCheck(){
			
			const userId = $("#userId");
			console.log(userId.val());
			
			if (userId.val() == null || userId.val() == '') {
				alert("아이디를 입력하세요.");
				userId.val("");
				userId.focus(); //해당 요소에 포커스 된다.
				return false;
			}else{
				
				var regExp = /^[a-zA-Z0-9]{4,10}$/;
				
				if (!regExp.test(userId.val())) { //아이디 검사를 통과하지 못했다면
					alert("아이디는 4~10자리 영문 및 숫자 조합이어야 합니다.");
					userId.val("");
					$("#userId").focus(); //해당 요소에 포커스 된다.
					return false;
					
				}else{
					
						$.ajax({
						url : "idDuplCheck.me",
						data : {
							checkId : userId.val()
						},
						success : function(result) {
	
							if (result == 'NNNNN') { //아이디 중복
								alert("해당 아이디는 이미 존재하거나 탈퇴한 회원의 아이디입니다.");
							} else { //아이디 사용가능
								//기존의 disabled 되어있던 회원가입 버튼을 사용가능하게 바꾸고 id값을 변경할 수 없도록 readonly 처리해주기
								if (confirm("사용가능한 아이디입니다. 사용하시겠습니까?")) {
// 									$("#idDuplCheck").removeAttr("disabled"); //버튼 비활성화(disabled 속성) 삭제
									$("#userId").attr("readonly", true); //아이디 입력란 읽기 전용으로 변경하기
									idcheck = true;
								} else {
									$("#userId").removeAttr("readonly");
									$("#userId").val("");
									$("#userId").focus();
									idcheck = false;
								}
							}
	
						},
						error : function() {
							alert("잘못된 접근입니다.");
						}
					})
					
				}
				
			}
			
		}
		
		
		function phoneDuplCheck(){
    		
    		const phone = $("#phone");
    		console.log(phone.val());
    		
    		if (phone.val() == null || phone.val() == '') {
				alert("전화번호를 입력하세요.");
				$("#phone").focus();
				return false;
			}else{
				
				var regExp = /^\d{11}$/;
				
				if (!regExp.test(phone.val())) { 
					alert("'-'를 제외한 숫자 11자리로 작성해 주세요");
					$("#phone").focus();
					return false;
					
				}else{
					
 					$.ajax({
						url : "phoneDuplCheck.me",
						data : {
							checkPhone : phone.val()
						},
						success : function(result) {

							if (result == 'NNNNN') { //번호 중복
								alert("가입된 이력이 있는 번호입니다.");
								$("#phone").val("");
							} else { //아이디 사용가능
								//기존의 disabled 되어있던 회원가입 버튼을 사용가능하게 바꾸고 id값을 변경할 수 없도록 readonly 처리해주기
								if (confirm("가입되지 않은 번호입니다. 사용하시겠습니까?")) {
// 									$("#idDuplCheck").removeAttr("disabled"); //버튼 비활성화(disabled 속성) 삭제
									$("#phone").attr("readonly", true); //아이디 입력란 읽기 전용으로 변경하기
									phonecheck = true;
								} else {
									$("#phone").removeAttr("readonly");
									$("#phone").val("");
									$("#phone").focus();
									phonecheck = false;
								}
							}

						},
						error : function() {
							alert("잘못된 접근입니다.");
						}
					})
					
				}
				
			}
    		
    	}
		
		
			function memberEnroll(){

				var userId = $("#userId").val();
				var userName = $("#userName").val();
				var userPassword = $("#userPassword").val();
				var userPasswordChk = $("#userPasswordChk").val();
				var phone = $("#phone").val();

				var address = $("#address").val();
				var addressDetail = $("#addressDetail").val();

				var email = $("#email").val();
				var gender = $("#gender").val();

				
				
				if (userId == null || userId == '') {
					alert("ID를 입력하세요.");
					$("#userId").focus();
					return false;
				}

				if (userName == null || userName == '') {
					alert("이름을 입력하세요.");
					$("#userName").focus();
					return false;
				}

				if (userPassword == null || userPassword == '') {
					alert("비밀번호를 입력하세요");
					return false;
				} else {
					
					var regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,15}$/;

					if (!regExp.test(userPassword)) {
						alert("비밀번호는 4~15자리 영문 및 숫자 조합이어야 합니다.");
						$("#userPassword").focus();
						return false;
					}
					
					if (userPassword != userPasswordChk) {
						alert("비밀번호가 일치하지 않습니다.");
						$("#userPasswordChk").focus();
						return false;
					}
				}

				if (phone == null || phone == '') {
					alert("전화번호를 입력하세요.");
					$("#phone").focus();
					return false;
				}

				if (address == null || address == '') {
					alert("주소를 입력하세요.");
					$("#address").focus();
					return false;
				}
				
				if (email == null || email == '') {
					alert("이메일을 입력하세요");
					$("#email").focus();
					return false;
					
				}else{
					
					var regExp = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
					
					if (!regExp.test(email)) { 
						alert("올바르지 않은 이메일 형식입니다.");
						$("#email").focus();
						return false;
					}
				}

				if (gender == null || gender == '') {
					alert("성별을 선택하세요");
					$("#gender").focus();
					return false;
				}
				
				
				if(!idcheck){
					alert("아이디 중복 체크를 하세요.");
					$("#userId").focus();
					return false;
				}
				
				if(!phonecheck){
					alert("전화번호 중복 체크를 하세요.");
					$("#phone").focus();
					return false;
				}
				
		}
	
	</script>

    
    
    <%@ include file="../common/footer.jsp" %>
 
</body>
</html>