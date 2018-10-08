<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiPart</title>
</head>
<body>
		<h1>MultipartREsolver</h1>
	<p>
		같은 이름으로 여러개의 파일을 설정해서 넘길수 있게 뷰 구현을
		해두었다면 MultipartFilep[] 로 받아서 처리를 하면 된다.
		<br/>
		같은 이름으로 파일여러개가 넘어온다면, 배열로 받아야되는데
		파일이 실제 하나도 언넘어오다라도, 이건 legnth=1 하나가 넘아와도 length=1 / isEmpty체크
		<br/>
		29.do 컨트롤러 작성하는데, 여기에서 파일 몇개 넘어온건지 개수먼sysout
	</p>
	<form action="29.do" method="post" enctype="multipart/form-data">
		첨부 : <input type="file" name="attach"/><br/>
		첨부 : <input type="file" name="attach"/><br/>
		첨부 : <input type="file" name="attach"/><br/>
		첨부 : <input type="file" name="attach"/><br/>
		<button type="submit">업로드</button>
	</form>
	
	<h2>다중업로드#예2</h2>
	<small>업로드하고자 하는 파일(들)을 선택해주세요</small>
	<form action="29.do" method="post" enctype="multipart/form-data">
		첨부 : <input type="file" name="attach" multiple onchange="check(this);"/><br/>
		<button type="submit">업로드</button>
	</form>
	<script>
		var check = function(target){
			console.log(target.files.length);
			for (var i = 0; i < target.length; i++) {
				console.log(target.files[i].name);
			}
		}
	</script>
</body>
</html>