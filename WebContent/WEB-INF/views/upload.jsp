<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiPart/form-data</title>
</head>
<body>
	<h1>Multipart/form-data</h1>
	<p>
		파일데이터와 같이 전송시키려면
		method="post" enctype를 multipart/form-data 로 설정해야한다.
	</p>
	<a href="<c:url value="/storage/18-sub.SQL Log"/>" download>다운</a>
	<form action="27.do" method="post" enctype="multipart/form-data">
		TEXT : <input type="text" name="info"/>
		ATTACH : <input type="file" name="attach"/>
		<br/>
		<button type="submit">전송</button>
	</form>
		<h1>MultipartREsolver</h1>
	<p>
		같은 이름으로 여러개의 파일을 설정해서 넘길수 있게 뷰 구현을
		해두었다면 MultipartFilep[] 로 받아서 처리를 하면 된다.
		<br/>
		같은 이름으로 파일여러개가 넘어온다면, 배열로 받아야되는데
		파일이 실제 하나도 언넘어오다라도, 이건 legnth=1 하나가 넘아와도 length=1 / isEmpty체크
		<br/>
		29.do 컨트롤러 작성하는데, 여기에서 파일 몇개 넘어온건지 개수먼sysouy
	</p>
	<form action="29.do" method="post" enctype="multipart/form-data">
		첨부 : <input type="file" name="attach"/><br/>
		첨부 : <input type="file" name="attach"/><br/>
		첨부 : <input type="file" name="attach"/><br/>
		첨부 : <input type="file" name="attach"/><br/>
		<button type="submit">업로드</button>
	</form>
	</body>
</html>