<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/plugins/jquery/jquery.min.js"></script>
<script>
	$(function() {
			let bno = 2;
			$.getJSON("/replies/all/" + bno, function(data) {
				console.log(data);
			});
	});
</script>
</head>
<body>
	<h2>Ajax Test Page</h2>
</body>
</html>