package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cummins.UserDetails.Userdetail;


public class UserValidation {
	public int getUser(DataBaseConn connection, Userdetail login) {
		String password = new String();
		PreparedStatement statement = null;


		String query = "select password from user_details where email_id=?";
		try {
			statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, login.getUserName());

			ResultSet rst = statement.executeQuery();

			while (rst.next()) {
				password = rst.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (password.equals(login.getPassword())) {
			return 1;
		} else {
			return 0;
		}

	}
	

}
