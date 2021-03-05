<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".fDrop").on("dragenter dragover", function(evt){
			evt.preventDefault(); // 이벤트 전파를 막음 (파일이 웹브라우저에서 열리는 것을 방지)
		});
		
		$(".fDrop").on("drop", function(evt){
			evt.preventDefault();
			
			let files = evt.originalEvent.dataTransfer.files; // 드래그 이벤트의 파일 데이터 전송 기능은 처리되도록
			let file = files[0];
			
			console.log(file);
			
			let formData = new FormData();
			formData.append("file", file); // "file"(key)이란 이름으로, file(value)을 전송
			
			$.ajax({
				url: '/uploadAjax',
				data : formData,
				dataType : 'text', // 응답 받을 형식
				type : 'post',
				processData : false, // 전송 데이터를 쿼리 스트링 형태로 변환하는지를 결정
				contentType : false, // 기본 값 : application/x-www-form-urlencoded (form 태그의 인코딩 기본값)
				success : function(result) {
					let output = '';
					if(checkImgType(result)) {
						// 이미지 파일이면,
						output += "<div>" + "<img src='displayFile?fileName=" + result + "'/>" + getImgLink(result);
						output += "<span id='" + result + "' onclick='deleteFile(this)'>X</span>"; 
						output += "</div>";
					} else {
						output += "<div><a href='displayFile?fileName=" + result + "'>" + getOriginalFileName(result) + "</a></div>"
					}
					
					$(".fDropList").append(output);
				},
				fail : function(result) {
					alert(result);
				}
			});
		});
	});
	
	function getImgLink(fileName) {
		if(!checkImgType(fileName)) {
			return;
		} 
		
		let underScorePos = fileName.lastIndexOf("_") + 1;
		return fileName.substr(underScorePos);
	}
	
	function getOriginalFileName(fileName) {
		if(checkImgType(fileName)) {
			return;s
		} 
		
		let underScorePos = fileName.indexOf('_') + 1;
		return fileName.substr(underScorePos);
	}
	
	// 파일 이름을 넘겨 받아 확장자가 패턴에 있는지 없는지 참/거짓 반환
	function checkImgType(fileName) {
		let imgPattern = /jpg$|gif$|png$|jpeg$/i; // /i = 앞의 것이면 무엇이든
		
		return fileName.match(imgPattern);
	}
	
	function deleteFile(obj) {
		let fileName = $(obj).attr('id');
		console.log(fileName);
		
		$.ajax({
			url: '/deleteFile',
			data : {"fileName" : fileName},
			dataType : 'text', // 응답 받을 형식
			type : 'post',
			success : function(result) {
				if(result == 'success') {
					alert("삭제 성공!");
				}
			},
			fail : function(result) {
				alert(result);
			}
		});
		
	}
</script>
<style>
	.fDrop {
		width : 100%;
		height :200px;
		border : 1px dotted blue;
	}
	
	small {
		margin-left : 3px;
		font-weight : bold;
		color : gray;
	}
</style>
<body>
	<h3>Ajax File Upload Test</h3>
	
	<div class="fDrop"></div>
	<div class="fDropList"></div>
</body>
</html>