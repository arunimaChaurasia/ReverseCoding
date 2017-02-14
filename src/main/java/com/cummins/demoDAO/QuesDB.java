package com.cummins.demoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cummins.questions.Question;




public class QuesDB {
	ArrayList<Question> question15=new ArrayList<Question>();   
	
	public QuesDB(DataBaseConn connection ,int level)
	{
		 
		
		ArrayList<Integer> randNo=new ArrayList<Integer>();
		String query="select * from questions where qid=";
		for(int i=0;i<14;i++)
		{
			query.concat("?,");
		}
		query.concat("?");
		try {
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
			
			if(level==1)
			{
				for(int i=0;i<15;i++)
				{
					int numb;
					numb=(int)(62*Math.random());
					if(!randNo.contains(numb))
					{
						randNo.add(numb);
						statement.setInt(i, numb);
						
					}
				}
			}
			else
			{
				for(int i=0;i<15;i++)
				{
					int numb;
					numb=(int)(62*Math.random())+101;
					if(!randNo.contains(numb))
					{
						randNo.add(numb);
						statement.setInt(i, numb);
						
					}
				}
			}
			
			
			ResultSet rst= statement.executeQuery();
			int count=0;
			while(rst.next())
			{
				Question temp=new Question();
				temp.setQid(rst.getInt("qid"));
				temp.setQuestion(rst.getString("question"));
				temp.setOption1("option1");
				temp.setOption2("option2");
				temp.setOption3("option3");
				temp.setOption4("option4");
				question15.add(count, temp);
				count++;
			}
			rst.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public ArrayList<Question> returnQuestion()
	{
		System.out.println(question15);
		return question15;
	}
}
