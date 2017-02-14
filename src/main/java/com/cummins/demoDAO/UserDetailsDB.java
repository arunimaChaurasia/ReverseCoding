package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cummins.UserDetails.Userdetail;

public class UserDetailsDB {
	//Userdetail userDetail=new Userdetail();
	public void getUserDetails(DataBaseConn connection, Userdetail user) {
		//String password = new String();
		 
		

		String query = "select points from userdetails where emailid=?";
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, user.getEmail_id());

			ResultSet rst = statement.executeQuery();

			while (rst.next()) {
				user.setPoints(rst.getInt("Points"));
			}
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
