package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cummins.UserDetails.Userdetail;
import com.cummins.questions.Question;

public class TopDAO {

	ArrayList<Userdetail> top10ser = new ArrayList<Userdetail>();

	public ArrayList<Userdetail> getTop10ser() {
		return top10ser;
	}

	public void setTop10ser(ArrayList<Userdetail> top10ser) {
		this.top10ser = top10ser;
	}
	public TopDAO(DataBaseConn connection)
	{
		 
		
		
		String query="select * from userdetails order by points desc limit 10;";
		
		try {
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
	
//			
//			
			ResultSet rst= statement.executeQuery();
			int count=0;
			while(rst.next())
			{
				Userdetail temp=new Userdetail();
				temp.setEmail_id(rst.getString("emailid"));
				temp.setPoints(rst.getInt("points"));
				top10ser.add(count,temp);
				
				
				count++;
			}
			rst.close();
			statement.close();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	

}
