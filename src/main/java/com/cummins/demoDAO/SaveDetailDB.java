package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.Userdetail;

public class SaveDetailDB {

	private int entry_id;
	private int user_map;
	public void getSaveDetailDB(DataBaseConn connection,AccountDetail acc_detail,Userdetail login)
	{
		int user_id = 0;
		String query_id="select max(entry_id)  from account_details";
		String query_id_map="select max(user_acc_map_id)  from user_account_map";
		String query_user = "select user_id where email_id=?";
	
		int i=0;
		 
		String query = "insert into account_details values (?,?,?,?,?,?,?,?)";
		String query_map="insert into user_account_map values (?,?,?)";
		
		try {
			Statement	result_stmt=connection.getConnection().createStatement();
			ResultSet rst=result_stmt.executeQuery(query_id);
			while (rst.next()) {
				entry_id=rst.getInt("max(entry_id)");
	
			}
//			entry_id=5;
			entry_id ++;
			System.out.println(entry_id);
			PreparedStatement  statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1,entry_id);
			statement.setString(2, acc_detail.getSecurityCode());
			statement.setString(3,acc_detail.getStatus());
			statement.setInt(4,acc_detail.getCurr_price());
			statement.setInt(5,acc_detail.getVolume());
			statement.setDate(6,acc_detail.getLast_update_date());
			statement.setDate(7,acc_detail.getSell_date());
			statement.setDate(8,acc_detail.getBuy_date());
			statement.executeQuery();
			rst.close();
			
			
		 rst=result_stmt.executeQuery(query_id_map);
			while (rst.next()) {
				user_map=rst.getInt("max(user_acc_map)");
				
			}
//			entry_id=5;
			user_map ++;
			PreparedStatement user_statement = connection.getConnection().prepareStatement(query_user);
			statement.setString(1, login.getEmail_id());

		 rst = statement.executeQuery();
		 while (rst.next()) {
				 user_id = rst.getInt("user_id");
				
			}

			PreparedStatement  map_statement = connection.getConnection().prepareStatement(query_map);
			map_statement.setInt(1,user_map);
			map_statement.setInt(2,user_id);
			map_statement.setInt(3,entry_id);
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
