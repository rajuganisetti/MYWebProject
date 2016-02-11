<!DOCTYPE html>
<html></body>

<%
// Grab the variables from the form.
  String username =  request.getParameter("username") ;
%>
 
	<frameset  cols="20%,80%">
  		<frame src="jsp/UserPage.jsp?username=<%=username%>" name="UsersPart">
  		<frame src="jsp/UserPage2.jsp?username=<%=username%>" name="ChatPart">
	</frameset>

<body>
</html>

