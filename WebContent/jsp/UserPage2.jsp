
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>UserPage</title>
</head>

<script>
function FriendRequest() {
	
	var username = document.getElementById('username').value;
	var friend_name = document.getElementById('friend_name').value; 
	window.open("./RqstNotification.jsp?username="+username+"&friend_name="+friend_name,"mywindow","width=400, height=250",location,'_blank','top=0');
}
</script>

<%
// Grab the variables from the form.
  String username=request.getParameter("username");  
%>
<body bgcolor="#F5F5DC">

	<h1>Welcome To Chat Application</h1>

	<div style="position: relative">
            <textarea rows="4" cols="100" style="position: fixed; bottom: 0; width:100%; text-align: left" placeholder=":) enter text here">
            </textarea>
	</div>
<input type=text name="username" id="username" style="visibility:hidden" value="<%=username %>"> 
<%
String friend_name = "";
int status;
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","rr"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("SELECT *  FROM Friends LEFT JOIN Users ON Users.username = Friends.user where Users.username='"+username+"'"); 
while(rs.next()) 
{ 
//a href="/download/{{filelocation}}/{{file}}
friend_name = rs.getString("friend_name");
status = rs.getInt("status");
if (status == 1){%>
	<input type=text name="friend_name" id="friend_name" style="visibility:hidden" value="<%=friend_name %>"> 
	<script type="text/javascript">
	FriendRequest();
 </script>
<%	
    out.println(" <br/><br/>");
}
}  

%>

</body>
</html>