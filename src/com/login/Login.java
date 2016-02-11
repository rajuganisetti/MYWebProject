package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
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
	      String username = request.getParameter("username");
	      String password = request.getParameter("password");
	      String dbPassword = "";
	      try {
	        Connection conn = new Database().dbconnection(); 
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select password from Users where username= ?");
		    ps.setString(1, username);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()){
		    				 dbPassword=rs.getString("password");
		    				 
		                   }
	       }
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	      
	      
	      if(password.equals(dbPassword)){
	    	  
	    	  RequestDispatcher view = request.getRequestDispatcher("/jsp/UserStartPage.jsp");
	    	  request.setAttribute("username", username);
	    	  view.forward(request, response);
	      }
	      
	    	  
	     
	}

}
