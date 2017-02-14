package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.cummins.UserDetails.Userdetail;
import com.cummins.questions.Question;

public class SaveDetailDB {

	String correctAns;
	public int getSaveDetailDB(DataBaseConn connection,Question ans) //value to be sent by correct ans by ui
	{
		
		String query = "select CorrectAns from questions where qid=?";
		
		try {
					PreparedStatement  statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1,ans.getQid());
			ResultSet rst=statement.executeQuery();
			
			
			while (rst.next()) {
				correctAns=rst.getString("CorrectAns");
				
			}
			rst.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		if(correctAns.compareTo(ans.getCorrectAns())==0)
		{
			return 1;
		}
		else 
			return 0;
	}
}
