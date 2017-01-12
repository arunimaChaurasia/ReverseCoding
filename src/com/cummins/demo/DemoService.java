package com.cummins.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cummins.PredictionModel.Prediction;
import com.cummins.StockDownloader.StockFactory;
import com.cummins.Stocks.Security;
import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.UserFactory;
import com.cummins.UserDetails.Userdetail;
import com.cummins.demoDAO.AccountDetaillDB;
import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.SaveDetailDB;
import com.cummins.demoDAO.SectorDB;
import com.cummins.demoDAO.SecurityDB;
import com.cummins.demoDAO.SignUp;
import com.cummins.demoDAO.UserDetailsDB;
import com.cummins.demoDAO.UserValidation;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
// @EnableWebMvc

public class DemoService {

	static DataBaseConn conn = new DataBaseConn();

	@RequestMapping(value = "/sectorDisplay", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getSector() {

		SectorDB sectors = new SectorDB();

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in String
		String jsonInString = new String();
		try {
			jsonInString = mapper.writeValueAsString(sectors.getSectors(conn));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service called");
		return jsonInString;
	}

	@RequestMapping(value = "/securityDisplay", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String getSecurity(@RequestBody Security security) {

		System.out.println(security.getSymbol());
		SecurityDB securitydb = new SecurityDB(conn, security.getSymbol());
		StockFactory stockfactory = new StockFactory();
		stockfactory.stockFactory(securitydb.returnStocks());
		Prediction predictStocks = new Prediction(securitydb.returnStocks());

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in String
		String jsonInString = new String();
		try {
			jsonInString = mapper.writeValueAsString(predictStocks);
			// jsonInSell= mapper.writeValueAsString(predictStocks.)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service return  called");
		return jsonInString;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String loginDetails(@RequestBody Userdetail login) {
		System.out.println(login.getEmail_id());
		int status;
		UserValidation user = new UserValidation();
		status = user.getUser(conn, login);

		if (status == 1) {
			// ArrayList<SavedDetails> savedetail = new
			// ArrayList<SavedDetails>();
			UserFactory userfactory = new UserFactory(conn, login);
			ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in String
			String jsonInString = new String();
			try {
				jsonInString = mapper.writeValueAsString(userfactory);
				// jsonInSell= mapper.writeValueAsString(predictStocks.)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("service return  called");
			return jsonInString;
		} else {
			return "Invalid UserName or Password";
		}

	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SignUpDetails(@RequestBody Userdetail signup) {
		System.out.println(signup.getEmail_id());
		int status;
		UserValidation user = new UserValidation();
		status = user.getUser(conn, signup);

		if (status == 1) {
			return "User Already exists Cannot signup!!";
		} else {
			SignUp signIn=new SignUp(conn,signup);
			return "SignUp Successfull !!! Congratulations";
		}

	}
	
	@RequestMapping(value = "/Savenew", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SaveDetails(@RequestBody AccountDetail savedetails) {
		//System.out.println(signup.getUserName());
	SaveDetailDB save=new	SaveDetailDB();
	save.getSaveDetailDB(conn,savedetails);
		return "Details are saved";

	}

}
 