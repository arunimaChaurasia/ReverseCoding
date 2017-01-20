package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.UserDetails.AccountDetail;

public class SaveDetailDB {

	private int entry_id;
	public void getSaveDetailDB(DataBaseConn connection,AccountDetail acc_detail)
	{
		String query_id="select max(entry_id)  from account_details";
		PreparedStatement statement = null;
		int i=0;
		Statement result_stmt=null;
		String query = "insert into account_details values (?,?,?,?,?,?,?,?)";
		
		try {
			result_stmt=connection.getConnection().createStatement();
			ResultSet rst=result_stmt.executeQuery(query_id);
			while (rst.next()) {
				entry_id=rst.getInt("max(entry_id)");
				
			}
//			entry_id=5;
			entry_id ++;
			System.out.println(entry_id);
			statement = connection.getConnection().prepareStatement(query);
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
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
