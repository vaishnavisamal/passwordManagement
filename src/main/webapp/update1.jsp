<%@page import="dto.PasswordData" %>
<%@page import="dao.PasswordDataDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>


<% int id= Integer.parseInt(request.getParameter("id"));
  PasswordDataDao dao=new PasswordDataDao();
  PasswordData data= dao.getPasswordDataById(id);
%>

<form action="updateuser" method="post">
Id: <%=data.getId()%><input type="hidden" value="<%= data.getId() %>" name="id" ><br>
Name: <input type="text" value="<%= data.getName() %>" name="name" ><br>
Email: <input type="text" value="<%= data.getEmail() %>" name="email" ><br>
password: <input type="text" value="<%= data.getPassword() %>" name="email" ><br>
fb_password: <input type="text" value="<%= data.getFb_password() %>" name="fb_password" ><br>
gmail_password: <input type="text" value="<%= data.getGmail_password() %>" name="email_password" ><br>
insta_password: <input type="text" value="<%= data.getInsta_password() %>" name="insta_password" ><br>
linkedin_password: <input type="text" value="<%= data.getLinkedin_password() %>" name="linkedin_password" ><br>
phone: <input type="number" value="<%= data.getPhone_num() %>" name="phone" ><br>
role:<%=data.getRole() %>
      <input type="submit">
</form>

</body>
</html>