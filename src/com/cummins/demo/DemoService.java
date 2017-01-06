package com.cummins.demo;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.SectorDB;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//@EnableWebMvc

public class DemoService {
	 
	static DataBaseConn conn =new DataBaseConn();
	
	 @RequestMapping( value="/sectorDisplay",method=RequestMethod.GET,produces="application/json")
	 public @ResponseBody String getSector()
	 {
		
		 SectorDB sectors=new SectorDB();
		
		 ObjectMapper mapper = new ObjectMapper();

		 //Object to JSON in String
		 String jsonInString=new String();
		try {
			jsonInString = mapper.writeValueAsString(sectors.getSectors(conn));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service called");
		 return jsonInString;
	 }
	 
	 @RequestMapping( value="/securityDisplay",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	 public @ResponseBody String getSecurity( @RequestBody Sector sector )
	 {
		 System.out.println(sector.getSymbol());
		if(sector.getSymbol().equalsIgnoreCase("auto"))
		{
			 SecurityDB securitydb=new SecurityDB();
		
		 ObjectMapper mapper = new ObjectMapper();

		 //Object to JSON in String
		 String jsonInString=new String();
		try {
			jsonInString = mapper.writeValueAsString(securitydb.returnJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service return  called");
		 return jsonInString;
		}
		else
		{
			return "not valid value";
		}
	 }
	 
	 @RequestMapping( value="/Login",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	 public @ResponseBody  void loginDetails( @RequestBody LoginCheck login )
	 {
		 System.out.println(login.getUserName());
//		if(sector.getSymbol().equalsIgnoreCase("auto"))
//		{
//			 SecurityDB securitydb=new SecurityDB();
//		
//		 ObjectMapper mapper = new ObjectMapper();
//
//		 //Object to JSON in String
//		 String jsonInString=new String();
//		try {
//			jsonInString = mapper.writeValueAsString(securitydb.returnJson());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("service return  called");
//		 return jsonInString;
//		}
//		else
//		{
//			return "not valid value";
//		}
	}
	 
	
}
