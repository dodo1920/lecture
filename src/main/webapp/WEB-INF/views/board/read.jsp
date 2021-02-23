<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="../resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="../resources/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../resources/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="../resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="../resources/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="../resources/plugins/summernote/summernote-bs4.min.css">
  <script src="../resources/plugins/jquery/jquery.min.js"></script>
  <script>
  	$(function() {
  		alert("!");
  	});
  </script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<%@include file="../templetHeader.jsp" %>
	<%@include file="../templetSidebar.jsp" %>
	
  	<!-- Content Wrapper. Contains page content -->
 		<div class="content-wrapper">
    		<div class="container">
		      <h1>게시판 글 조회 페이지</h1><hr />
					<div class="form-group">
		               <label class="control-label col-sm-2" for="no">글번호 :</label>
		               <div class="col-sm-10">
		                	${board.no }
		               </div>
		            </div>
		            <div class="form-group">
		               <label class="control-label col-sm-2" for="writer">작성자 :</label>
		               <div class="col-sm-10">
		                	${board.writer }
		               </div>
		            </div>
		            <div class="form-group">
		               <label class="control-label col-sm-2" for="writer">작성일 :</label>
		               <div class="col-sm-10">
		                	${board.regdate }
		               </div>
		            </div>
		            <div class="form-group">
		               <label class="control-label col-sm-2" for="writer">조회수 :</label>
		               <div class="col-sm-10">
		                	${board.viewcnt }
		               </div>
		            </div>
		            <div class="form-group">
		               <label class="control-label col-sm-2" for="title">제 목 :</label>
		               <div class="col-sm-10">
		                  ${board.title }
		               </div>
		            </div>
		            <div class="form-group">
		               <label class="control-label col-sm-2" for="content">내 용 :</label>
		               <div class="col-sm-10">
		                  ${board.content }
		               </div>
		            </div>
		            	
		            <div class="box-footer">
					    <button type="button" class="btn btn-success" id="rewriteBoard" onclick="location.href='/board/modi?no=${board.no}';">수정하기</button>
					    <button type="button" class="btn btn-info" id="deleteBoard" onclick="location.href='/board/remove?no=${board.no}';">삭제하기</button>
					    <button type="button" class="btn btn-primary" onclick="location.href='/board/listAll';">리스트페이지로</button>
		            </div>
		      </div>
		</div>
	<!-- /.content-wrapper -->
  
	<%@include file="../templetFooter.jsp" %>
</body>
</html>
  