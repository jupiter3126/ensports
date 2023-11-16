<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/views/common/menubar.jsp" %>
<!DOCTYPE html>
<html lang="en">


<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!--부트스트랩 설정-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <!-- Title Page-->
    <title>경기장 개설</title>

    <!-- Icons font CSS-->
    <link href="${contextPath }/resources/js/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="${contextPath }/resources/js/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="${contextPath }/resources/js/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${contextPath }/resources/js/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${contextPath }/resources/css/main.css" rel="stylesheet" media="all">
</head>

<body id="page-top">
    <div id="wrapper">
		<%@ include file="/views/admin/common/sideBar.jsp" %>
        <div class="wrapper wrapper--w790" style="margin-top: 100px">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">경기장 상세보기</h2>
                </div>
                <div class="card-body">
                    <form action="${contextPath }/placeUpdate.pl" method="post" enctype="multipart/form-data">
                    	
                    	 <input type="hidden" name="placeNo" value="${p.placeNo }">
                        <div class="form-row">
                            <div class="name">경기장 이름</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="placeName" value="${p.placeName }"required>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">지역명</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="localName" >
                                            <option selected="selected"value="서울">서울</option>
                                            <option value="부산">부산</option>
                                            <option value="대구">대구</option>
                                            <option value="인천">인천</option>
                                            <option value="광주">광주</option>
                                            <option value="대전">대전</option>
                                            <option value="울산">울산</option>
                                            <option value="세종">세종</option>
                                            <option value="경기">경기</option>
                                            <option value="제주">제주</option>
                                            <option value="경남">경남</option>
                                            <option value="경북">경북</option>
                                            <option value="전남">전남</option>
                                            <option value="전북">전북</option>
                                            <option value="충남">충남</option>
                                            <option value="충북">충북</option>
                                            <option value="강원">강원</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-row p-t-20">
                            <label class="label label--block">카테고리 </label>
                            <div class="p-t-15" id="categoryCheck">
                                <label class="radio-container m-r-55">축구
                                    <input type="radio" checked="checked"name="categoryNo" value="1" id="soccer">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">야구
                                    <input type="radio" name="categoryNo" value="2" id="baseball">
                                    <span class="checkmark" ></span>
                                </label>
                            </div>
                        </div>
                      	<input type="hidden" id="inputMaxCapacity"name="max_capacity" value="22">
                        
                        <div id="placeSizeCheck">
	                        <div class="form-row p-t-20" id="slideDownSoccerSize">
	                            <label class="label label--block">경기장 규격</label>
	                            <div class="p-t-15" >
	                                <label class="radio-container">45m X 90m
	                                    <input type="radio" checked="checked" name="place_size" value="45m X 90m">
	                                    <span class="checkmark"></span>
	                                </label>
	                                <label class="radio-container">64m X 100m
	                                    <input type="radio" name="place_size" value="64m X 100m">
	                                    <span class="checkmark"></span>
	                                </label>
	                                <label class="radio-container">75m X 110m
	                                    <input type="radio" name="place_size" value="75m X 110m">
	                                    <span class="checkmark"></span>
	                                </label>
	                                <label class="radio-container">90m X 120m
	                                    <input type="radio" name="place_size" value="90m X 120m">
	                                    <span class="checkmark"></span>
	                                </label>
	                            </div>
	                            
	                        </div>
	                        <div class="form-row p-t-20" id="slideDownBaseballSize" style="display: none;">
	                            <label class="label label--block">경기장 규격</label>
	                            <div class="p-t-15">
	                                <label class="radio-container" >좌우: 100  좌우중간:125
	                                    <input type="radio" name="place_size"value="좌우: 100  좌우중간:125">
	                                    <span class="checkmark"></span>
	                                </label>
	                                <label class="radio-container" >좌우: 99  좌우중간:122
	                                    <input type="radio" name="place_size" value="좌우: 99  좌우중간:122">
	                                    <span class="checkmark"></span>
	                                </label>
	                                <label class="radio-container" >좌우: 108  좌우중간:120
	                                    <input type="radio" name="place_size" value="좌우: 108  좌우중간:120">
	                                    <span class="checkmark"></span>
	                                </label>
	                            </div>
	                            
	                        </div>
                       	</div>
                        <div class="form-row p-t-20">
                            <label class="label label--block">주차장 유무</label>
                            <div class="p-t-15" id="parkingCheck">
                                <label class="radio-container m-r-55">Y
                                    <input type="radio" checked="checked" name="parking_yn" value="Y">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">N
                                    <input type="radio" name="parking_yn" value="N">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">특이사항</div>
                            <div class="value">
                                <div class="input-group">
                                    <textarea class="input--style-5" name="place_sub_info"rows="2" cols="50" style="resize:none;" required placeholder="없으면 '없음'이라고 작성">${p.place_sub_info }</textarea>
                                </div>
                            </div>
                        </div>
                        <!--대표이미지, 세부이미지 첨부파일-->
                        <c:forEach items="${list }" var="at" varStatus="status">
	                        <c:if test="${at.fileLevel==1}">
	                        
		                        <div class="mb-3">
		                        	
		                        		<input type="hidden" name="originFileNo1" value="${at.atNo }">
										<input type="hidden" name="originFileName1" value="${at.changeName }">
									
		                            <label for="formFile" class="form-label"><b>기존 대표이미지 : </b></label>${at.originName }
		                            <input class="form-control" type="file" id="formFile1" name="reloadFile1" required >
		                        </div>
	                        </c:if>
	                        <c:if test="${status.index==1 }">
	                        <div class="mb-3">
	                        	<c:if test="${not empty at }">
	                        		<input type="hidden" name="originFileNo2" value="${at.atNo }">
									<input type="hidden" name="originFileName2" value="${at.changeName }">
								</c:if>
	                            <label for="formFile" class="form-label"><b>기존 상세이미지1 :</b></label><c:if test="${at != null }">${at.originName }</c:if>
	                            <input class="form-control" type="file" id="formFile2" name="reloadFile2">
	                        </div>
	                        </c:if>
	                         <c:if test="${status.index==2 }">
	                        <div class="mb-3">
	                        	<c:if test="${not empty at }">
	                        		<input type="hidden" name="originFileNo3" value="${at.atNo }">
									<input type="hidden" name="originFileName3" value="${at.changeName }">
								</c:if>
								
	                            <label for="formFile" class="form-label"><b>기존 상세이미지2 : </b></label><c:if test="${at != null }">${at.originName }</c:if>
	                            <input class="form-control" type="file" id="formFile3" name="reloadFile3">
	                        </div>
	                       	</c:if>
	                        
                        </c:forEach>
	                        <div>
	                            <button class="btn btn-primary" type="submit">수정하기</button>
	                            <a class="btn btn-info" href="${contextPath }/deletePlace.pl?pno=${p.placeNo}">삭제하기</a>
	                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

	<script>
		$(function(){
			
			$("#baseball").click(function(){
				
				//slideDown
				if($("#slideDownBaseballSize").css("display")=="none"){ //야구 사이즈 창 닫혀있을때
					$("#inputMaxCapacity").val("18"); //야구 수용인원
					
					$("#slideDownSoccerSize").slideUp();
					$("#slideDownBaseballSize").slideDown();
				}else{ //야구 사이즈 창 열려있을때
					
					$("#slideDownBaseballSize").slideUp();
				}
			});
			
			$("#soccer").click(function(){
				
				//slideDown
				if($("#slideDownSoccerSize").css("display")=="none"){ //축구 사이즈 창 닫혀있을때
					$("#inputMaxCapacity").val("22");
					$("#slideDownBaseballSize").slideUp();
					$("#slideDownSoccerSize").slideDown();
				}else{ //축구 사이즈 창 열려있을때
					$("#slideDownSoccerSize").slideUp();
				}
			});
			
		});
	
	</script>
	<script>
    	$(function(){
    		//지역명
    		$("select[name=localName]").children().each(function(){
    			
    			if($(this).val()=="${p.localName}"){
    				$(this).prop("selected",true);
    			}
    		});
    		
    		//카테고리
    		$("#categoryCheck input").each(function(){
    			if($(this).val()=="${p.categoryNo}"){
    				$(this).prop("checked",true);
    				if($("#baseball").prop("checked")){
    					$("#inputMaxCapacity").val("18");
    					$("#slideDownSoccerSize").slideUp();
    					$("#slideDownBaseballSize").slideDown();
    				}
    			}
    		});
    		
    		//경기장 규격
    		$("#placeSizeCheck input").each(function(){
    			if($(this).val()=="${p.place_size}"){
    				$(this).prop("checked",true);
    			}
    		});
    		//주차장 유무
    		$("#parkingCheck input").each(function(){
    			if($(this).val()=="${p.parking_yn}"){
    				$(this).prop("checked", true);
    			}
    		});
    	});
    	
    </script>
    <!-- Jquery JS-->
    <script src="${contextPath }/resources/js/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="${contextPath }/resources/js/vendor/select2/select2.min.js"></script>
    <script src="${contextPath }/resources/js/vendor/datepicker/moment.min.js"></script>
    <script src="${contextPath }/resources/js/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="${contextPath }/resources/js/global.js"></script>
    
    <!-- Bootstrap core JavaScript-->
    <script src="${contextPath }/resources/js/vendor/jquery/jquery.min.js"></script>
    <script src="${contextPath }/resources/js/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${contextPath }/resources/js/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${contextPath }/resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${contextPath }/resources/js/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${contextPath }/resources/js/demo/chart-area-demo.js"></script>
    <script src="${contextPath }/resources/js/demo/chart-pie-demo.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->