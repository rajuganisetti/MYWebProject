package com.login;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class AcceptRequest
 */
@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String friend_name=request.getParameter("friend_name");
		String action=request.getParameter("action");
		String button = "confirm";
		
		if(action.equals("confirm")){
			
			try{
			Connection con = new Database().dbconnection();
			java.sql.Statement st=con.createStatement();
			String updatet="update Friends set status=2 where(user = ? AND friend_name = ?)";
			
			//out.println(action);
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(updatet);
			ps.setString(1, username);
		    ps.setString(2, friend_name);
		    ps.executeUpdate();
		    out.println(action);
		    
			//String query="update Friends set status=2 where(user="+username+" AND friend_name="+friend_name+")"; 
			//out.println(action);
			//out.println(query);
			//int count=st.executeUpdate(query);
			
		    PreparedStatement ps2 = (PreparedStatement) con.prepareStatement("insert into Friends values(?,?,?)");
		    ps2.setString(1, friend_name);
		    ps2.setString(2, username);
		    ps2.setInt(3, 2);
		    ps2.executeUpdate();
		    out.println("successfully added to your Friends_list");
			}
			 catch(Exception e)
			  {
			    out.println("Could not connect");
			  }
		}else 
			out.println("Friend request deleted");

	}

}
