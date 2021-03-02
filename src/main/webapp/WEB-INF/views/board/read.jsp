<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
   href="../resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
   href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
   href="../resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
   href="../resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="../resources/plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../resources/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
   href="../resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
   href="../resources/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
   href="../resources/plugins/summernote/summernote-bs4.min.css">

<script src="../resources/plugins/jquery/jquery.min.js"></script>
<style type="text/css">
	#modifyBox {
		width : 400px;
		height : 150px;
		background-color: lightgray;
		position : absolute;
		top : 50%;
		left : 50%;
		margin-top: -50px;
		argin-left: -50px;
		display: none;
		z-index: 999;
	}
	
	#deleteBox {
		width : 400px;
		height : 150px;
		background-color: lightgray;
		position : absolute;
		top : 50%;
		left : 50%;
		margin-top: -50px;
		argin-left: -50px;
		display: none;
		z-index: 999;
	}
</style>
<script>
function callReplyList(){
    
    let bno = ${board.no };
    let output = '<div class="list-group">';
    $.getJSON("/replies/all/" + bno, function(data){
       console.log(data);
       $(data).each(function(index, item){
          output += '<a href="#" class="list-group-item active">';
          output += '<span>' + item.no + '<span>';
          output += '<div>' + item.replyText + '</div>';
          output += '<div><span>' + new Date(item.updateDate) + '</span></div>';
          output += '<div><span>' + item.replyer + '</span>';
          output += '<span id="'+ item.no +'" onclick="goModify('+ item.no + ')"><img src="../resources/img/modify.png" width="15px"/></span>';
          output += '<span id="'+ item.no +'" onclick="goDelete('+ item.no + ')"><img src="../resources/img/trash.png" width="15px"/></span>';
          output += '</div></a>';
       });
       output += "</div>";
       $("#replyBox").html(output);
    });
 }   
 
 function showReplyBox() {
   $("#inputReplyBox").show();
}
 
 function goModify(no) {
	 $("#modifyBox").show();
	 $("#replyNo").val(no);
	 console.log($("#replyNo").val());
 }
 
 function modiBoxClose() {
	 $("#modifyBox").hide();
 }
 
 function goDelete(no) {
	 $("#deleteBox").show();
	 $("#deleteNo").val(no);
 }
 
 function deleteBoxClose() {
	 $("#deleteBox").hide();
 }
 
 function modi() {
	  	let no = $("#replyNo").val();
	  	let replyText = $("#replyText").val();
	  	
	  	console.log(no);
		console.log(replyText);
	  	
		 $.ajax({
	         method: "PUT",
	         url: "/replies/" + no,
	         headers : { // 요청 하는 데이터의 헤더에 전송
	      	   "content-Type" : "application/json",
	      	   "X-HTTP-Method-Override" : "POST"
	         },
	         dataType: "text", // 응답 받는 데이터 타입
	         data : JSON.stringify({ // 보내는 데이터
	      	   no : no,
	      	   replyText : replyText
	         }),
	         success : function(result) {
	      	   if(result == 'Success') {
	      		   console.log("수정완료!");
	      		   callReplyList();
	      	   }
	         }
	       });
	  };
	  
function deleteReply() {
   		  let no = $("#deleteNo").val();
   		  
   			$.ajax({
		         method: "DELETE",
		         url: "/replies/" + no,
		         headers : { // 요청 하는 데이터의 헤더에 전송
		      	   "content-Type" : "application/json",
		      	   "X-HTTP-Method-Override" : "POST"
		         },
		         dataType: "text", // 응답 받는 데이터 타입
		         data : JSON.stringify({ // 보내는 데이터
		      	   no : no,
		         }),
		         success : function(result) {
		      	   if(result == 'Success') {
		      		   console.log("삭제완료!");
		      		   callReplyList();
		      	   }
		         }
	       	});
   	  }

 $(function(){
    
      callReplyList();
      
      $("#replyAddBtn").click(function() {
      let replyer = $("#newReplyWriter").val();
      let replyText = $("#newReplyText").val();
      let bno = ${param.no};
      
      $.ajax({
           method: "post",
           url: "/replies",
           headers : { // 요청 하는 데이터의 헤더에 전송
        	   "content-Type" : "application/json",
        	   "X-HTTP-Method-Override" : "POST"
           },
           dataType: "text", // 응답 받는 데이터 타입
           data : JSON.stringify({ // 보내는 데이터
        	   bno : bno,
        	   replyer : replyer,
        	   replyText : replyText
           }),
           success : function(result) {
        	   if(result == 'Success') {
        		   callReplyList();
        	   }
           }
         });
  	 });
   });
   
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

   <%@ include file="../templetHeader.jsp"%>
   <%@ include file="../templetSidebar.jsp"%>
   <div class="content-wrapper">
      <h1>게시판 글조회 페이지</h1>
      <hr />


      <div class="form-group">
         <label class="control-label col-sm-2" for="writer">글번호 :</label>
         <div class="col-sm-10">${board.no }</div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-2" for="writer">작성자 :</label>
         <div class="col-sm-10">${board.writer }</div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-2" for="writer">조회수 :</label>
         <div class="col-sm-10">${board.viewcnt }</div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-2" for="writer">작성일 :</label>
         <div class="col-sm-10">
            <fmt:formatDate value="${board.regdate }" type="both"
               pattern="yyyy-MM-dd HH:mm:ss" />
         </div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-2" for="title">제 목 :</label>
         <div class="col-sm-10">${board.title }</div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-2" for="content">내 용 :</label>
         <div class="col-sm-10">${board.content }</div>
      </div>

      <div class="box-footer">

         <button type="button" class="btn btn-success" id="rewriteBoard"
            onclick="location.href='/board/modi?no=${board.no}'">수정하기</button>
         <button type="button" class="btn btn-info" id="deleteBoard"
            onclick="location.href='/board/remove?no=${board.no}'">삭제하기</button>
         <button type="button" class="btn btn-primary"
            onclick="location.href='/board/listCri?page=${param.page}'">리스트페이지로</button>
         <button type="button" class="btn btn-success" onclick="showReplyBox();">댓글달기</button> 
      </div>
      <div id="modifyBox">
   		<div>댓글 수정</div>
   		<div>
   			<input type="hidden" id="replyNo"/>
   			<input type="text" id="replyText" />
   			<button type="button" id="replyModBtn" onclick="modi();">수정</button>
   			<button type="button" id="replyModClose" onclick="modiBoxClose();">닫기</button>
   		</div>
   	  </div>
   	  
   	  <script>   	  

   	  </script>
   	  
   	  <div id="deleteBox">
   		<div>정말 삭제하시겠습니까?</div>
   		<div>
   			<input type="hidden" id="deleteNo"/>
   			<button type="button" id="replyDelBtn" onclick="deleteReply();">네</button>
   			<button type="button" id="replyDelClose" onclick="deleteBoxClose();">아니오</button>
   		</div>
   	  </div>
      <div id="inputReplyBox" style="margin:15px; border:1px dotted gray;display: none;" >
         <div>
            작성자 : <input type="text" name="replyer" id="newReplyWriter" />
            
         </div>
         <div>
            댓글 입력 : <input type="text" name="replytext" id="newReplyText" />
            
         </div>
         <div>
            <button type="button" class="btn btn-info" id="replyAddBtn">ADD Reply</button>
         </div>
      </div>
      <div id="replyBox" style="padding : 10px; border-bottom : 1px solid gray;">
         
      </div>

   </div>
   
   <%@ include file="../templetFooter.jsp"%>





   <!-- jQuery -->
   <script src="resources/plugins/jquery/jquery.min.js"></script>
   <!-- jQuery UI 1.11.4 -->
   <script src="resources/plugins/jquery-ui/jquery-ui.min.js"></script>
   <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
   <script>
      $.widget.bridge('uibutton', $.ui.button)
   </script>
   <!-- Bootstrap 4 -->
   <script src="resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
   <!-- ChartJS -->
   <script src="resources/plugins/chart.js/Chart.min.js"></script>
   <!-- Sparkline -->
   <script src="resources/plugins/sparklines/sparkline.js"></script>
   <!-- JQVMap -->
   <script src="resources/plugins/jqvmap/jquery.vmap.min.js"></script>
   <script src="resources/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
   <!-- jQuery Knob Chart -->
   <script src="resources/plugins/jquery-knob/jquery.knob.min.js"></script>
   <!-- daterangepicker -->
   <script src="resources/plugins/moment/moment.min.js"></script>
   <script src="resources/plugins/daterangepicker/daterangepicker.js"></script>
   <!-- Tempusdominus Bootstrap 4 -->
   <script
      src="resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
   <!-- Summernote -->
   <script src="resources/plugins/summernote/summernote-bs4.min.js"></script>
   <!-- overlayScrollbars -->
   <script
      src="resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
   <!-- AdminLTE App -->
   <script src="resources/dist/js/adminlte.js"></script>
   <!-- AdminLTE for demo purposes -->
   <script src="resources/dist/js/demo.js"></script>
   <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
   <script src="resources/dist/js/pages/dashboard.js"></script>
</body>
</html>
  