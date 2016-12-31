package com.cummins.demo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//@EnableWebMvc

public class DemoService {

	
	
	 
	 @RequestMapping( value="/sectorDisplay",method=RequestMethod.GET)//,produces="application/json")


	 public 	 @ResponseBody String getvalue()
	 {
		 SectorDB sector=new SectorDB();
		 ObjectMapper mapper = new ObjectMapper();


		 //Object to JSON in file
		 try {
			mapper.writeValue(new File("file.json"), sector.returnJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 //Object to JSON in String
		 String jsonInString=new String();
		try {
			jsonInString = mapper.writeValueAsString(sector.returnJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service called");
		 return jsonInString;
	 }
	 
	
}
