<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ServletContext sc=getServletContext();
java.sql.Connection con=(java.sql.Connection)sc.getAttribute("oracle");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from gym");
ResultSetMetaData rm=rs.getMetaData();

int n=rm.getColumnCount();
%>
<%for(int i=1;i<=n;i++)
{
	%><%=rm.getColumnName(i)%>&nbsp<%
} %><br>
<% 
while(rs.next())
{
	for(int i=1;i<=n;i++)
	{    
		%>
		<span><%=rs.getString(i) %></span>
		<% 
	}%><br><% 
}
%>

<%
HttpSession s=request.getSession();
String s1=(String)s.getAttribute("username");
out.println(s1);
%>
<h1><%=s1 %></h1>

</body>
</html>