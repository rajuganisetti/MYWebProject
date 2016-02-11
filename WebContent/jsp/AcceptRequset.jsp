<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>

<%
String username=request.getParameter("username");
String friend_name=request.getParameter("friend_name");
String action=request.getParameter("action");

if(action == "confirm"){

	try{
	Class.forName("com.mysql.jdbc.Driver"); 
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","rr"); 
	Statement st= con.createStatement(); 
	String query="update Friends set status=2 where(user="+username+" AND friend_name="+friend_name; 
	int count=st.executeUpdate(query);

    PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into Friends values(?,?,?)");
    ps.setString(1, friend_name);
    ps.setString(2, username);
    ps.setInt(3, 2);
	}
	 catch(Exception e)
	  {
	    out.println("Could not connect");
	  }
}

%>