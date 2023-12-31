<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/views/common/menubar.jsp" %>    
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="${contextPath }/resources/js/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${contextPath }/resources/js/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
		<%@ include file="/views/admin/common/sideBar.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid" style="margin-top: 150px;">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">경기장 목록</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>경기장 번호</th>
                                            <th>경기장 이름</th>
                                            <th>지역</th>
                                            <th>조회수</th>
                                            <th>경기장 등록일</th>
                                            <th>카테고리</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>경기장 번호</th>
                                            <th>경기장 이름</th>
                                            <th>지역</th>
                                            <th>조회수</th>
                                            <th>경기장 등록일</th>
                                            <th>카테고리</th>
                                        </tr>
                                    </tfoot>
                                    <c:choose>
                                        <c:when test="${empty requestScope.list}">
                                            <tr>
                                                <td>경기장이 없습니다.</td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tbody>
                                            <c:forEach items="${requestScope.list}" var="p">
                                                <tr>
                                                    <td>${p.placeNo }</td>
                                                    <td><a href="${contextPath}/placeDetail.pl?pno=${p.placeNo}">${p.placeName }</a></td>
                                                    <td>${p.localName }</td>
                                                    <td>${p.place_count }</td>
                                                    <td>${p.place_date }</td>
                                                    <td>${p.categoryNo }</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${contextPath }/resources/js/vendor/jquery/jquery.min.js"></script>
    <script src="${contextPath }/resources/js/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${contextPath }/resources/js/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${contextPath }/resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${contextPath }/resources/js/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${contextPath }/resources/js/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${contextPath }/resources/js/demo/datatables-demo.js"></script>

</body>

</html>