package com.cummins.UserDetails;

import java.sql.Connection;
import java.util.ArrayList;

import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.AccountDetaillDB;
import com.cummins.demoDAO.UserDetailsDB;
import com.cummins.questions.Question;

public class UserFactory {
	Userdetail login;
	Question ans;
	public UserFactory()
	{
		
	}
	public UserFactory(DataBaseConn conn,	Userdetail log) {
		login=log;
		UserDetailsDB userDetail=new UserDetailsDB();
		userDetail.getUserDetails(conn, login);
		
	}
	public Userdetail getLogin() {
		return login;
	}
	public void setLogin(Userdetail login) {
		this.login = login;
	}
	public Question getAns() {
		return ans;
	}
	public void setAns(Question ans) {
		this.ans = ans;
	}
	
}
