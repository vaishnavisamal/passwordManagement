<%@page import="dto.PasswordData" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table align="center" cellpadding="20px" border="1px">

<% List<PasswordData> data=(List<PasswordData>)request.getAttribute("listdata");
%>

<tr align="center">
<th> id </th>
<th> name </th>
<th> email </th>
<th> password </th>
<th> fb_password </th>
<th> gamil_password </th>
<th> insta_password </th>
<th> linkedin_password </th>
<th> phone </th>
<th> role </th>
<th> delete </th>
<th> update </th>
</tr>
<% for(PasswordData data2: data){ %>

<tr align="center">
<td><%=data2.getId() %></td>
<td><%=data2.getName() %></td>
<td><%=data2.getEmail() %></td>
<td><%=data2.getPassword() %></td>
<td><%=data2.getFb_password() %></td>
<td><%=data2.getGmail_password() %></td>
<td><%=data2.getInsta_password() %></td>
<td><%=data2.getLinkedin_password() %></td>
<td><%=data2.getPhone_num() %></td>
<td><%=data2.getRole() %></td>
<td><a href="delete?id=<%= data2.getId() %>>">delete</a></td>
<td><a href="update.jsp?id=<%= data2.getId() %>>">update</a></td>
</tr>

<%} %>

</table>
</body>
</html>