<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/menubar.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link
	href="${contextPath }/resources/js/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${contextPath }/resources/css/sb-admin-2.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">
		<%@ include file="/views/admin/common/sideBar.jsp"%>

		<!-- Begin Page Content -->
		<div class="container-fluid" style="padding-top: 100px;">

			<!-- Page Heading -->
			<div
				class="d-sm-flex align-items-center justify-content-between mb-4">
				<h1 class="h3 mb-0 text-gray-800">대시보드</h1>
			</div>

			<!-- Content Row -->
			<div class="row">

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-primary shadow h-100 py-2">
						<div class="card-body">
							<div class="row no-gutters align-items-center">
								<div class="col mr-2">
									<div
										class="text-xs font-weight-bold text-primary text-uppercase mb-1"
										style="font-size: 18px;">현재 회원 수</div>
									<div class="h5 mb-0 font-weight-bold text-gray-800"
										id="memberNum"></div>
								</div>
								<div class="col-auto">
									<i class="bi bi-person fa-3x"></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-success shadow h-100 py-2">
						<div class="card-body" style="display: flex; align-items: center;">
							<div class="row no-gutters align-items-center"
								style="width: 100%; height: 100%;">
								<div class="col mr-2">
									<div
										class="text-xs font-weight-bold text-success text-uppercase mb-1"
										style="font-size: 18px;">경기장 수</div>
									<div class="h5 mb-0 font-weight-bold text-gray-800"
										id="placeNum"></div>
								</div>
								<div class="col-auto">
									<i class="fa fa-soccer-ball-o" style="font-size: 36px"></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-info shadow h-100 py-2">
						<div class="card-body" style="display: flex; align-items: center;">
							<div class="row no-gutters align-items-center"
								style="width: 100%; height: 100%;">
								<div class="col mr-2">
									<div
										class="text-xs font-weight-bold text-info text-uppercase mb-1"
										style="font-size: 18px;">활발한 회원수</div>
									<div class="row no-gutters align-items-center">
										<div class="col-auto">
											<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"
												id="activeMember"></div>
										</div>
									</div>
								</div>
								<div class="col-auto">
									<i class='fas fa-fire-alt' style='font-size: 36px'></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Pending Requests Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-warning shadow h-100 py-2">
						<div class="card-body" style="display: flex; align-items: center;">
							<div class="row no-gutters align-items-center"
								style="width: 100%; height: 100%;">
								<div class="col mr-2">
									<div
										class="text-xs font-weight-bold text-warning text-uppercase mb-1"
										style="font-size: 18px;">새로운 문의사항 수</div>
									<div class="h5 mb-0 font-weight-bold text-gray-800"
										id="replyNum"></div>
								</div>
								<div class="col-auto">
									<i class="far fa-comments fa-lg"
										style="font-size: 36px; color: #8893a5;"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Content Row -->

			<div class="row">

				<!-- Area Chart -->
				<div class="col-xl-8 col-lg-7">
					<div class="card shadow mb-4">
						<!-- Card Header - Dropdown -->
						<div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<h6 class="m-0 font-weight-bold text-primary">이번달 매출</h6>
							<div class="dropdown no-arrow"></div>
						</div>
						<!-- Card Body -->
						<div class="card-body">
							<div class="chart-area">
								<canvas id="myAreaChart"></canvas>
							</div>
						</div>
					</div>
				</div>

				<!-- Pie Chart -->
				<div class="col-xl-4 col-lg-5">
					<div class="card shadow mb-4">
						<!-- Card Header - Dropdown -->
						<div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<h6 class="m-0 font-weight-bold text-primary">남녀 회원 비율</h6>
							<div class="dropdown no-arrow"></div>
						</div>
						<!-- Card Body -->
						<div class="card-body">
							<div class="chart-pie pt-4 pb-2">
								<canvas id="myPieChart"></canvas>
							</div>
							<div class="mt-4 text-center small">
								<span class="mr-2"> <i class="fas fa-circle text-primary"></i>
									남성
								</span> <span class="mr-2"> <i
									class="fas fa-circle text-success"></i> 여성
								</span>

							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(function() {

			$.ajax({
				url : "countMember.da",
				type : "get",
				success : function(count) {
					console.log("인원수:" + count);
					$("#memberNum").text(count);
				}
			});
		});
		$(function() {
			$.ajax({
				url : "countPlace.da",
				type : "get",
				success : function(count) {
					console.log("경기장 수:" + count);
					$("#placeNum").text(count);
				}
			});
		});
		$(function() {
			$.ajax({
				url : "countReply.da",
				type : "get",
				success : function(count) {
					console.log("문의사항 수:" + count);
					$("#replyNum").text(count);
				}
			});
		});
		$(function() {
			$.ajax({
				url : "countActiveMember.da",
				type : "get",
				success : function(count) {
					console.log("활발한 회원수:" + count);
					$("#activeMember").text(count);
				}
			});
		});
	</script>
	<!-- Bootstrap core JavaScript-->
	<script src="${contextPath }/resources/js/vendor/jquery/jquery.min.js"></script>
	<script
		src="${contextPath }/resources/js/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${contextPath }/resources/js/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${contextPath }/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="${contextPath }/resources/js/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script>
	
	Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#858796';




	$(function(){
		console.log("들어왔니? 허허");
		$.ajax({
			url: "monthlyRevenue.ch",
			type: "get",
			success: function(list2){
				console.log("list2 확인:",list2);
				var Jan = list2[0];
				var Feb = list2[1];
				var Mar = list2[2];
				var Apr = list2[3];
				var May = list2[4];
				var Jun = list2[5];
				var Jul = list2[6];
				var Aug = list2[7];
				var Sep = list2[8];
				var Oct = list2[9];
				var Nov = list2[10];
				var Dec = list2[11];
				
				console.log("달:",Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec);


				function number_format(number, decimals, dec_point, thousands_sep) {
				  // *     example: number_format(1234.56, 2, ',', ' ');
				  // *     return: '1 234,56'
				  number = (number + '').replace(',', '').replace(' ', '');
				  var n = !isFinite(+number) ? 0 : +number,
				    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
				    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
				    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
				    s = '',
				    toFixedFix = function(n, prec) {
				      var k = Math.pow(10, prec);
				      return '' + Math.round(n * k) / k;
				    };
				  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
				  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
				  if (s[0].length > 3) {
				    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
				  }
				  if ((s[1] || '').length < prec) {
				    s[1] = s[1] || '';
				    s[1] += new Array(prec - s[1].length + 1).join('0');
				  }
				  return s.join(dec);
				}
				
				// Area Chart Example
				var ctx = document.getElementById("myAreaChart");
				var myLineChart = new Chart(ctx, {
				  type: 'line',
				  data: {
				    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				    datasets: [{
				      label: "Earnings",
				      lineTension: 0.3,
				      backgroundColor: "rgba(78, 115, 223, 0.05)",
				      borderColor: "rgba(78, 115, 223, 1)",
				      pointRadius: 3,
				      pointBackgroundColor: "rgba(78, 115, 223, 1)",
				      pointBorderColor: "rgba(78, 115, 223, 1)",
				      pointHoverRadius: 3,
				      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
				      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
				      pointHitRadius: 10,
				      pointBorderWidth: 2,
				      data: [Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec],
				    }],
				  },
				  options: {
				    maintainAspectRatio: false,
				    layout: {
				      padding: {
				        left: 10,
				        right: 25,
				        top: 25,
				        bottom: 0
				      }
				    },
				    scales: {
				      xAxes: [{
				        time: {
				          unit: 'date'
				        },
				        gridLines: {
				          display: false,
				          drawBorder: false
				        },
				        ticks: {
				          maxTicksLimit: 7
				        }
				      }],
				      yAxes: [{
				        ticks: {
				          maxTicksLimit: 5,
				          padding: 10,
				          // Include a dollar sign in the ticks
				          callback: function(value, index, values) {
				            return '$' + number_format(value);
				          }
				        },
				        gridLines: {
				          color: "rgb(234, 236, 244)",
				          zeroLineColor: "rgb(234, 236, 244)",
				          drawBorder: false,
				          borderDash: [2],
				          zeroLineBorderDash: [2]
				        }
				      }],
				    },
				    legend: {
				      display: false
				    },
				    tooltips: {
				      backgroundColor: "rgb(255,255,255)",
				      bodyFontColor: "#858796",
				      titleMarginBottom: 10,
				      titleFontColor: '#6e707e',
				      titleFontSize: 14,
				      borderColor: '#dddfeb',
				      borderWidth: 1,
				      xPadding: 15,
				      yPadding: 15,
				      displayColors: false,
				      intersect: false,
				      mode: 'index',
				      caretPadding: 10,
				      callbacks: {
				        label: function(tooltipItem, chart) {
				          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
				          return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
				        }
				      }
				    }
				  }
				});
			}
		});
	});

	</script>
	<script>
		

			
		$(function(){
			$.ajax({
				url : "/ensport/countGender.ch",
				type : "get",
				success : function(count) {
					var result;
					var genderM;

					var genderF;
					
					console.log(count);
					
					for(var i in count){
						if(count[i].genderName == 'M'){
							genderM = count[i].genderCount;
						}else{
							console.log("체크");
							genderF = count[i].genderCount;
						}
					}
					
					
					
					var ctx = document.getElementById("myPieChart");
					var myPieChart = new Chart(ctx, {
						type : 'doughnut',
						data : {
							labels : [ "남", "여" ],
							datasets : [ {
								data : [ genderM, genderF ],
								backgroundColor : [ '#4e73df', '#1cc88a' ],
								hoverBackgroundColor : [ '#2e59d9', '#17a673' ],
								hoverBorderColor : "rgba(234, 236, 244, 1)",
							} ],
						},
						options : {
							maintainAspectRatio : false,
							tooltips : {
								backgroundColor : "rgb(255,255,255)",
								bodyFontColor : "#858796",
								borderColor : '#dddfeb',
								borderWidth : 1,
								xPadding : 15,
								yPadding : 15,
								displayColors : false,
								caretPadding : 10,
							},
							legend : {
								display : false
							},
							cutoutPercentage : 50,
						},
					});
				}
			});
		})
		

	</script>

</body>

</html>