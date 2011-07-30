<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/my-app/j_spring_security_check" method="post">
<table>
<tr>
	<td>User Name</td>
	<td><input type="text" name="j_username"></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="j_password"></td>
</tr>
<tr ><td colspan="2"><input type="submit" value="login"></td></tr>
</table>


<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
id="MyPanels" width="100%" height="100%"
codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
<param name="movie" value="http://localhost:8080/my-app/my-app-ria-1.0-SNAPSHOT.swf" />
<param name="quality" value="high" />
<param name="bgcolor" value="#ababab" />
<param name="allowScriptAccess" value="sameDomain" />
<param name="src" value="http://localhost:8080/my-app/my-app-ria-1.0-SNAPSHOT.swf" />
<embed src="http://localhost:8080/my-app/my-app-ria-1.0-SNAPSHOT.swf" quality="high" bgcolor="#ababab"
width="100%" height="100%" name="MyPanels" align="middle"
play="true"
loop="false"
quality="high"
allowScriptAccess="sameDomain"
type="application/x-shockwave-flash"
pluginspage="http://www.adobe.com/go/getflashplayer">
</embed>
</object>
</form>
</body>
</html>