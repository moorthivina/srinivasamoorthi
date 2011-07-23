<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function submit(a){
		document.getElementById("indexForm").action = "listfiles.html"
		indexForm.submit();
	}
</script>
</head>
<body>
<form id="indexForm">
<h1>Welcome</h1>
<input type="button" value="List Files" onclick="submit(1);">
</form>
</body>
</html>