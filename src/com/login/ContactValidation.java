package com.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ContactValidation {

	public int contactCheck(){
		 String username ="";
		 String username_check ="";
		    try {
		        Connection conn = new Database().dbconnection(); 
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select username from Users where username= ?");
			    ps.setString(1, username);
			    ResultSet rs = ps.executeQuery();
			    while(rs.next()){
			    				 username_check=rs.getString("username");
			    				 
			                   }
		       }
		      catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		    
	
	if(username_check.equals(username)){
		return 1;
	}
	else 
		return 0;
	}
	
}
