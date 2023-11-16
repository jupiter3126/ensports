<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ensport.member.model.vo.Member"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<c:set var="boardCount" value="${boardCount}" scope="request"/>
<c:set var="replyCount" value="${replyCount}" scope="request"/>
<c:set var="qaCount" value="${qaCount}" scope="request"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

	<!-- jQuery -->
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
	<title>Ensport</title>
	<!-- CSS
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
	<link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/main.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	
	<link rel="icon" href="${contextPath }/resources/img/elements/baseball_icon1.png" type="image/x-icon">
	
</head>

<body>
    <header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="${contextPath }"><img src="${contextPath }/resources/img/logo(temp).png" /></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto"> 
							<li class="nav-item"><a class="nav-link" href="${contextPath}">Home</a></li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">경기매칭</a>
								<ul class="dropdown-menu">

									<li class="nav-item"><a class="nav-link" href="${contextPath}/list.so?currentPage=1">축구</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath}/list.ba?currentPage=1">야구</a></li>
									
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">시설예약</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="${contextPath}/place.so?currentPage=1">축구</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath}/place.ba?currentPage=1">야구</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="boardList.bo?currentPage=1" class="nav-link dropdown-toggle" >커뮤니티</a>
								
							</li>
							
							<c:choose>
								<c:when test="${loginUser == null }">
									<li class="nav-item submenu">
										<a href="${contextPath }/login.do" class="nav-link">로그인</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="nav-item submenu dropdown">
										<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
											<img class="" src="${contextPath }/resources/img/elements/soccer_icon1.png" alt=""> ${loginUser.userNickname } 님 환영합니다!
										</a>
										<ul class="dropdown-menu">
											<c:if test="${loginUser.userNo == 1 }">
												<li class="nav-item"><a class="nav-link" href="${contextPath }/dashboard.hp">관리자 페이지</a></li>
											</c:if>
												<li class="nav-item"><a class="nav-link" href="${contextPath }/myPage.me">마이페이지</a></li>
												<li class="nav-item"><a class="nav-link" href="${contextPath }/logout.me" onclick="return confirm('로그아웃 하시겠습니까?')">로그아웃</a></li>
										</ul>
									</li>
								</c:otherwise>
							</c:choose>
							

						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item"><a href="#" class="cart"><span class="ti-briefcase"></span></a></li>
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	
	<script>
		const msg = "${alertMsg}";
		if (msg != null && msg != '') {
		    alert(msg);
		    setTimeout(() => {
		    	  console.log('This message will appear after 3 seconds.');
		    	}, 3000);
		   <c:remove var="alertMsg" scope="session" />
		}

		const errorMsg = "${errorMsg}";
		if (errorMsg != null && errorMsg != '') {
		    alert(errorMsg);
		// 	<c:remove var="errorMsg" scope="request" />
		}
	</script>

</body>
</html>