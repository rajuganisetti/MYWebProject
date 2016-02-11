<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>


<html>
<head>
<title>Userform</title>
<script>

function FriendRequest() {
	var newcontact = document.getElementById('newcontact').value;
	var username = document.getElementById('username').value;
	window.open("./FriendRequest1.jsp?newcontact="+newcontact+"&username="+username,"mywindow","width=400, height=250");
}

function previewFile(){
    var preview = document.querySelector('img'); //selects the query named img
    var file    = document.querySelector('input[type=file]').files[0]; //sames as here
    var reader  = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
    }

    if (file) {
        reader.readAsDataURL(file); //reads the data as a URL
    } else {
        preview.src = "";
    }
}

previewFile();  //calls the function named previewFile()

</script>


</head>
<body bgcolor="#F5F5DC" onload="readData()">

<%
// Grab the variables from the form.
  String username=request.getParameter("username");  
%>


<img src = '../images/profile.jpg' align='middle' height=100 width=150 alt="Image preview...">
<input type="file" onchange="previewFile()" alt="Alt text"><br>

<h3> <%=username %> </h3>  
contacts <br/>

<input type=text name="username" id="username" style="visibility:hidden" value="<%=username %>"> 
<input type = "text" name='newcontact' id="newcontact" size="15">
<button onclick="FriendRequest()">search</button>
	
<hr/>
<%
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","rr"); 
Statement st= con.createStatement(); 
ResultSet rs=st.executeQuery("SELECT *  FROM Friends LEFT JOIN Users ON Users.username = Friends.user where Users.username='"+username+"'"+"AND Friends.status=2"); 
while(rs.next()) 
{ 
//a href="/download/{{filelocation}}/{{file}}
String test= "<a href="+"./UserChatPage.jsp?friend_name="+rs.getString("friend_name")+" target='ChatPart' "+" > " +rs.getString("friend_name") + "</a>"  ;	
out.println(test);
out.println(" <br/><br/>");
}  

%>

</body>
</html>