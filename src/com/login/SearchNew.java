package com.login;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.FREE_MEM;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SearchNew
 */
@WebServlet("/SearchNew")
public class SearchNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNew() {
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
	    String username = request.getParameter("contacts");
	    
	    String username_check ="";
	    try {
	        Connection conn = new Database().dbconnection(); 
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select username from Users where username= ?");
		    ps.setString(1, username);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()){
		    				 username_check=rs.getString("username");
		    				 
		                   }
		    conn.close();
	       }
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	    
	    if(username_check.equals(username) && username!="" && username!=null){
	    	  
	    	String sender=request.getParameter("username");
	    	RequestDispatcher friendRequest = request.getRequestDispatcher("/jsp/FriendRequestOut.jsp?sender="+sender+"&reciver="+username);
	    	 
	    	friendRequest.forward(request, response);
	        
	    	  
	      }
	    else
	    	
	    	out.println("User is not registered");
	   
	    
	}
	

}
