<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
    <h1>Chao mung den voi JSP </h1>
    

   </div>
   <div class="content">
   <%
   // viet ma Java o day
    String message = " Hello, JSP!";
   out.print("<p>" + message + "</p>");
   %>
   </div>
   <a href="menu"> Den menu Chuc Nag</a>
   <div class="footer">
   <p>&copy;2024 Trang Web cua ban </p>  
   </div>

</body>
</html>