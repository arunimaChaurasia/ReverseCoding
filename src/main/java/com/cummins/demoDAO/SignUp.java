package com.cummins.demoDAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.UserDetails.Userdetail;

public class SignUp implements Serializable {
 
	private static  int user_id;
	public SignUp(DataBaseConn connection,Userdetail signup)
	{
		
		
		String query_id="select max(uid) as user_id1 from userdetails";
		String query = "insert into userdetails  (uid,emailid,password,points) values (?,?,?,?)";
		
		try {
			Statement result_stmt=connection.getConnection().createStatement();
			ResultSet rst=result_stmt.executeQuery(query_id);
			while (rst.next()) {
				user_id=rst.getInt("user_id1");
				
			}
			user_id++;
			System.out.println(user_id);
			PreparedStatement  statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1,user_id);
			statement.setString(2, signup.getEmail_id());
			statement.setString(3,signup.getPassword());
			statement.setInt(4,0);
			statement.executeUpdate();
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
