<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend Request Form</title>
</head>
<body bgcolor="#F8F8F8">

<%
// Grab the variables from the form.
  String sender=request.getParameter("sender");
  String  reciver=request.getParameter("reciver");
%>

<h1>Sending Friend Request</h1>
<br/>
	<div>
            <textarea rows="4" cols="40">Hi <%=reciver %>, I'd like to add you as a contact. From <%=sender %>
            </textarea>
	</div>
<br/><br/>

	<div align="right">
		<form action = "./SendRequest" method="POST">
			
		    	<input type=text name="sender" id="sender" style="visibility:hidden" value="<%=sender %>">
		    	<input type=text name="reciver" id="reciver" style="visibility:hidden" value="<%=reciver %>">
				<input type="submit" value="Confirmation"> 
		
		</form>
	</div>
	
</body>
</html>