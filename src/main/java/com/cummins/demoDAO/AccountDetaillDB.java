package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cummins.UserDetails.Userdetail;
/*
 * This is the class which fetches the details of  user account from database oracle 11g xe
 * */

public class AccountDetaillDB {
	
	public void getUser(DataBaseConn connection, Userdetail login,int value) {
		
		
		int i=0;
		String query_ins = "update userdetails  set points=? where emailid=?";
		
		String query = "select points from userdetails where emailid=?";
		try {
			PreparedStatement valid_state=connection.getConnection().prepareStatement(query);
			valid_state.setString(1,login.getEmail_id());
			ResultSet rst = valid_state.executeQuery();
			//rst.next();
			
			
				while (rst.next()) {
					login.setPoints(rst.getInt("points"));
				}
				
				if(value==1)
				{
					login.setPoints(login.getPoints()+4);
				}
				else
				{
					login.setPoints(login.getPoints()-1);
				}
			rst.close();
				valid_state.close();
				
				PreparedStatement  statement = connection.getConnection().prepareStatement(query_ins);
				statement.setInt(1,login.getPoints());
				statement.setString(2, login.getEmail_id());
				statement.executeQuery();
				rst.close();
				statement.close();
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
	


}
