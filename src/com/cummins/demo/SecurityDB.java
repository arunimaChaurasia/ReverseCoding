package com.cummins.demo;

import java.util.ArrayList;

public class SecurityDB {
	ArrayList<Security> security   = new ArrayList<Security>();
	public SecurityDB()
	{
		//ArrayList<Sector> sectors    = new ArrayList<Sector>();
		Security newSecurity=new Security();
		Security newSecurity1=new Security();
		Security newSecurity3=new Security();
		
		newSecurity1.setCompany("Tata Motors");
		newSecurity1.setStatus("Buy");
		security.add(newSecurity1);
		
			newSecurity.setCompany("Bosch");;
			newSecurity.setStatus("buy");;
			security.add(newSecurity);
			newSecurity3.setCompany("M&M");
			newSecurity3.setStatus("sell");
			security.add(newSecurity3);
		
	}
	public ArrayList<Security> returnJson()
	{
		return security;
	}
}
