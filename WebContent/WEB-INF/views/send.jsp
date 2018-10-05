<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button type="button" onclick="send()";>AJAX(POST)</button>
	<button type="button" onclick="send2()";>AJAX(POST)</button>
	<script>
		/*
			AJAX get 은 주소뒹에 ?키=값&키=값 이렇게 해서 보내고, parameter로만 뽑힘
					
			AJAX post는 JSON 문자열로 보내서 requestBody 처리하는 방식과
			
			?키=값&키=값 의 형태의 문자열을 보내면서 , header 설정해주고 parameter로 처리
		*/
		var send = function(){
			var xhr = new XMLHttpRequest();
			xhr.open("post", "${pageContext.servletContext.contextPath}/study/13ajax.do", true);
			var param={
					"talker" : "saan",
					"mode" : 1,
					"ment" : "ajax의 Post요청은 send시 문자열을 데이터를 설정해서 전송"
					
			};
			xhr.send(JSON.stringify(param));
			
		}		
		
		var send2 = function(){
			var xhr = new XMLHttpRequest();
			xhr.open("post", "${pageContext.servletContext.contextPath}/study/13ajax.do", true);
			var param="talker=saan";
			param += "&mode = 1";
			param += "ment = ajax의 Post요청은 send시 문자열을 데이터를 설정해서 전송"
					
			xhr.send(JSON.stringify(param));
			
		}		
	
	
	</script>
</body>
</html>