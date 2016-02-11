<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend Request Form</title>
<SCRIPT LANGUAGE="JavaScript">
        
        function button(objbutton)
        {
            action = objbutton.value;
            
        } 
        
    </SCRIPT>

</head>
<body bgcolor="#F8F8F8">

<%
// Grab the variables from the form.
  String username=request.getParameter("username");
  String  friend_name=request.getParameter("friend_name");
%>

<h1>New Friend Request</h1>
<br/>
	<div>
            Hi <%=username %>, <%=friend_name %> sent you friend request
            
	</div>
<br/><br/>

	<div align="right">
	<form action="../AcceptRequest" method="POST">	
			
		    	<input type=text name="username" id="username" style="visibility:hidden" value="<%=username %>">
		    	<input type=text name="friend_name" id="friend_name" style="visibility:hidden" value="<%=friend_name %>">
				<input type="submit" name="action" value="confirm"> 
				<input type="submit" name="action" value="delete"> 
		
	</form>	
	</div>
	
</body>
</html>