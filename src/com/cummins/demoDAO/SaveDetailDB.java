package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cummins.UserDetails.AccountDetail;

public class SaveDetailDB {

	private static int entry_id=0;
	public SaveDetailDB(DataBaseConn connection,AccountDetail acc_detail)
	{
		entry_id++;
		PreparedStatement statement = null;
		int i=0;
		String query = "insert into account_details values (?,?,?,?,?,?,?,?)";
		
		try {
			statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1,entry_id);
			statement.setString(2, acc_detail.getSecurity_code());
			statement.setString(3,acc_detail.getStatus());
			statement.setInt(4,acc_detail.getCurr_price());
			statement.setInt(5,acc_detail.getVolume());
			statement.setDate(6,acc_detail.getLast_update_date());
			statement.setDate(7,acc_detail.getSell_date());
			statement.setDate(8,acc_detail.getBuy_date());
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
