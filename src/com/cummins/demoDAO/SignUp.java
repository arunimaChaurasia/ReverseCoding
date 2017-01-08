package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cummins.UserDetails.Userdetail;

public class SignUp {
 
	private static int user_id=0;
	public SignUp(DataBaseConn connection,Userdetail signup)
	{
		user_id ++;
		//String password = new String();
		PreparedStatement statement = null;
		int i=0;
		String query = "insert into user_details values (user_id,first_name,last_name,phone_no,email_id,password) (?,?,?,?,?,?)";
		
		try {
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1,user_id);
			statement.setString(2, signup.getFirst_name());
			statement.setString(3,signup.getLast_name());
			statement.setLong(4,signup.getPhn_no());
			statement.setString(5,signup.getEmail_id());
			statement.setString(6,signup.getPassword());
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
