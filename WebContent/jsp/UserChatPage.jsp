<!DOCTYPE html>
<html>
<head>
<title>UserPage</title>
</head>
<%
// Grab the variables from the form.
  String friend_name =  request.getParameter("friend_name") ;
%>
<body bgcolor="#F5F5DC">

<h1> <%=friend_name %> </h1> 
	<div style="position: relative">
            <textarea rows="4" cols="100" style="position: fixed; bottom: 0; width:100%; text-align: left" placeholder=":) enter text here">
            </textarea>
	</div>

</body>
</html>