package com.login;


import java.io.File;
import java.io.IOException;import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
	      String username = request.getParameter("usernamesignup");
	      String password = request.getParameter("passwordsignup");
	      String email = request.getParameter("emailsignup");   
	      
	  try{
	        	
		  //Getting database object
		  Connection conn = new Database().dbconnection();

          PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into Users values(?,?,?)");
	         
	         ps.setString(1, username);
	         ps.setString(2, email);
	         ps.setString(3, password);
	         ps.executeUpdate();
	         out.println("Registration completed succesfully");	         
	         conn.close();
	         String curdir=System.getProperty("user.dir")+"/workstation/MYWebProject/Users/";
	        
	         String dir=curdir+username;
	       
	 		 new Foldercreate().FolderCreation(dir);
	         RequestDispatcher view = request.getRequestDispatcher("/login.html");
	    	  
	    	 view.forward(request, response);
	         
	  }
	  catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }
	  
	}

}
