package com.cummins.UserDetails;

import java.sql.Connection;
import java.util.ArrayList;

import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.SavedDetailDB;
import com.cummins.demoDAO.UserDetailsDB;

public class UserFactory {
	Userdetail login;
	ArrayList<SavedDetails> savedetail;
	public UserFactory(DataBaseConn conn,	Userdetail log) {
		login=log;
		UserDetailsDB userDetail=new UserDetailsDB();
		userDetail.getUserDetails(conn, login);
		SavedDetailDB savedb=new SavedDetailDB();
		savedb.getUser(conn, login, savedetail);
	}
	public Userdetail getLogin() {
		return login;
	}
	public void setLogin(Userdetail login) {
		this.login = login;
	}
	public ArrayList<SavedDetails> getSavedetail() {
		return savedetail;
	}
	public void setSavedetail(ArrayList<SavedDetails> savedetail) {
		this.savedetail = savedetail;
	}
}
