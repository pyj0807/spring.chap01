<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST</title>
</head>
<body>
	<h1>WebSocket</h1>
	<p>
		웹소켓은 ws 프로토콜 기반으로 작동하는 기술로,
		서버와 클라이언트가 연결을 유지한채로 데이터를 주고받고자 할때 사용되게 된다.
	</p>
	<p>
		스크립트로 객체 생성을 하면 되고, 연결하고자 하는 서버측의 주소를 설정해두면 된다.<br/> 
		이걸 받아서 처리할 서버가 필요한데, tomcat은 이 http요청 외에 ws 프로토콜도 받을수 있고,<br/>
		일반적인 웹 어플에서는 ws 프로토콜을 처리하기 위해선 
		ws프로토콜 처리용 프로그램을 따로 설정을 해야 되는데,<br/>
		Spring 은 별도로 따로 만들지 않더라도, http와 같이 처리가 가능하다. 
	</p>
	<p>
		maven 에서 Spring websocket 를 찾아서 연동.
	</p>
	<button type="button" onclick="dataSend();">websocket에 데이터 전송</button>
	<script>
		console.log(location.host);
		var ws = new WebSocket("ws://"+ location.host +"${pageContext.servletContext.contextPath}/conn.do");
		
		ws.onmessage = function(got) {	// 매개변수설정하면
			// 받은 내용에 관련된 객체를 넘겨주면서 콜이 일어나고,
			//console.log(got);
			console.log(got.data);
			var obj = JSON.parse(got.data);
			switch(obj.mode){
			case "welcome" :
				break;
			case "login" :
				break;
			}
		};
		
		
		var dataSend = function() {
			var data = {"mode": 1, "text" : "웹소켓으로 데이터 전송"};
			ws.send(JSON.stringify(data));
		}
		
		
	</script>
</body>
</html>