<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend Request Form</title>
</head>
<body bgcolor="#F8F8F8">

<%
// Grab the variables from the form.
  String newcontact=request.getParameter("newcontact");
  String username=request.getParameter("username");  
%>

<h1>Sending Friend Request</h1>
<br/>
	<div>
            <textarea rows="4" cols="40">Hi <%=newcontact %>, I'd like to add you as a contact. This is <%=username %>
            </textarea>
	</div>
<br/><br/>

	<div align="right">
    	<form action = "../searchnew" method="POST">
    	<input type=text name="contacts" style="visibility:hidden" value="<%=newcontact %>"> 
    	<input type=text name="username" id="username" style="visibility:hidden" value="<%=username %>"> 
		<input type="submit" value="send"> 
		</form>
	</div>

</body>
</html>