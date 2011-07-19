<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/xml" prefix="x" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
List files
<table border="2">
<c:forEach items="${list}" var="x">
  <tr><td><c:out value="${x.id}"/></td>
      <td><c:out value="${x.filePath}"/></td>
      <td><c:out value="${x.updatetime}"/></td>
      <td><c:out value="${x.fileName}"/></td>
  </tr>
</c:forEach>
</table>
</body>
</html>