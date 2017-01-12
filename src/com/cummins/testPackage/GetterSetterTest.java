package com.cummins.testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cummins.Stocks.Stock;
import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.Userdetail;

public class GetterSetterTest{

	@Test
	    public void testSetOpen() {
	        Stock stock = new Stock();
	        stock.setOpen("134.14");
	        assertTrue(stock.getOpen() == "134.14");
	    }
	@Test
		public void testSetEps(){
		Stock stock = new Stock();
        stock.setEps("587.73");
        assertTrue(stock.getEps() == "587.73");
	}
	@Test
	public void testSetSecurityCode(){
		AccountDetail accountdetail=new AccountDetail();
		accountdetail.setSecurityCode("BHEL");
		 assertTrue(accountdetail.getSecurityCode() == "BHEL");
		}
	@Test
	public void testSetDetailUser(){
		Userdetail userdetail=new Userdetail();
		userdetail.setFirst_name("Sakshi");
		 assertTrue(userdetail.getFirst_name() == "Sakshi");
		}
	

}
