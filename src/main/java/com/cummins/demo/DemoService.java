package com.cummins.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import com.cummins.UserDetails.UserFactory;
import com.cummins.UserDetails.Userdetail;
import com.cummins.demoDAO.AccountDetaillDB;
import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.QuesDB;
import com.cummins.demoDAO.SaveDetailDB;
import com.cummins.demoDAO.SignUp;
import com.cummins.demoDAO.UserDetailsDB;
import com.cummins.demoDAO.UserValidation;
import com.cummins.questions.Question;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@EnableWebMvc

public class DemoService {

	
	static DataBaseConn conn = new DataBaseConn();
	

	@RequestMapping(value = "/requestQuestion", method = RequestMethod.POST, produces = "application/json",consumes ="application/json")
	public @ResponseBody String requestQuestion(@RequestBody Question ques) {

		int level= ques.getLevel();
		QuesDB quesDB = new QuesDB(conn, level);
		

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in String
		String jsonInString = new String();
		try {
			jsonInString = mapper.writeValueAsString(quesDB.returnQuestion());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service called");
		return jsonInString;
	}

//	@RequestMapping(value = "/Login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//	public @ResponseBody String loginDetails(@RequestBody Userdetail login) {
//		System.out.println(login.getEmail_id());
//		int status;
//		UserValidation user = new UserValidation();
//		status = user.getUser(conn, login);
//		String invalid = new String();
//		ObjectMapper mapper = new ObjectMapper();
//
//
//		if (status == 1) {
//			// ArrayList<SavedDetails> savedetail = new
//			// ArrayList<SavedDetails>();
//			UserFactory userfactory = new UserFactory(conn, login);
//			
//			// Object to JSON in String
//			String jsonInString = new String();
//			try {
//				jsonInString = mapper.writeValueAsString(userfactory);
//				// jsonInSell= mapper.writeValueAsString(predictStocks.)
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("service return  called");
//			return jsonInString;
//		} else {
//			try {
//				invalid = mapper.writeValueAsString("invalid username or password");
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return null
//					;
//		}
//
//	}
//
	@RequestMapping(value = "/SignUp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SignUpDetails(@RequestBody Userdetail signup) {
		System.out.println(signup.getEmail_id());
		int status;
		UserValidation user = new UserValidation();
		status = user.getUser(conn, signup);
		String invalid = new String();
		ObjectMapper mapper = new ObjectMapper();


		if (status == 1) {
			
			try {
				invalid = mapper.writeValueAsString("User Already exists Cannot signup!!");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return invalid;
			
		} else {
			SignUp signIn=new SignUp(conn,signup);
			try {
				invalid = mapper.writeValueAsString("1");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return invalid;
			
		}
	}
	
	@RequestMapping(value = "/Savenew", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SaveDetails(@RequestBody UserFactory savedetails) {
		//System.out.println(signup.getUserName());
	SaveDetailDB save=new	SaveDetailDB();
	int ans_value=save.getSaveDetailDB(conn, savedetails.getAns());
	String details=new String();
	ObjectMapper mapper = new ObjectMapper();
	try {
		
		AccountDetaillDB user=new AccountDetaillDB();
		user.getUser(conn, savedetails.getLogin(), ans_value);
		details = mapper.writeValueAsString(savedetails.getLogin());
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return details;
		

	}

	@RequestMapping(value = "/Submit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SaveDetails(@RequestBody Userdetail details) {
		//System.out.println(signup.getUserName());
	UserDetailsDB user=new UserDetailsDB();
	user.getUserDetails(conn, details);
	String value=new String();
	ObjectMapper mapper = new ObjectMapper();
	try {
		
		
		value = mapper.writeValueAsString(details);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return value;
		

	}

}
 