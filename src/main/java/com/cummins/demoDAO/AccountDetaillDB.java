package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.Userdetail;

public class AccountDetaillDB {
	
	public void getUser(DataBaseConn connection, Userdetail login,ArrayList<AccountDetail> savedetail) {
		
		
		int i=0;
		String query_id="select entry_id from user_account_map where user_id =(select user_id from user_details where email_id=?)";
		String query = "select * from account_details where entry_id IN (select entry_id from user_account_map where user_id =(select user_id from user_details where email_id=?))";
		try {
			PreparedStatement valid_state=connection.getConnection().prepareStatement(query_id);
			valid_state.setString(1,login.getEmail_id());
			ResultSet rst = valid_state.executeQuery();
			
			if(!rst.next())
			{
				savedetail=null;
				rst.close();
				valid_state.close();
	
			}
			else{
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, login.getEmail_id());

			 rst = statement.executeQuery();

				while (rst.next()) {
					savedetail.get(i).setSecurityCode(rst.getString("security_code"));
					savedetail.get(i).setStatus(rst.getString("status"));
					savedetail.get(i).setCurr_price(rst.getInt("current_price"));
					savedetail.get(i).setVolume(rst.getInt("volume"));
					savedetail.get(i).setBuy_date(rst.getDate("buy_date"));
					savedetail.get(i).setSell_date(rst.getDate("sell_date"));
					
				}
				rst.close();
				statement.close();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
	


}
