package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SendRequest
 */
@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequest() {
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
	      String username = request.getParameter("reciver");
	      String friend_name = request.getParameter("sender");
	      
	      
	      try {
		        Connection conn = new Database().dbconnection(); 
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into Friends values(?,?,?)");
			    ps.setString(1, username);
			    ps.setString(2, friend_name);
			    ps.setInt(3,1);
			    ps.executeUpdate();
		        out.println("Friend Request sent");
		        conn.close();
			    
		       }
		      catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
	      
	     
	}

}
