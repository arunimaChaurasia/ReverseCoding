package com.cummins.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cummins.Stocks.Sector;
import com.cummins.UserDetails.Userdetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class DemoServiceTest {
	   
	 
	    @Autowired
	    private WebApplicationContext ctx;
	 
	    private MockMvc mockMvc;
	 
	    @Before
	    public void setUp() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	    }
	 
	    @Test
	    public void displaysector() throws Exception {
	        
	        mockMvc.perform(get("/sectorDisplay").accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is(500));
	    }
	    @Test
	    public void displaysecurity() throws Exception {
	    	Sector sector=new Sector();
	    	sector.setName("Media And Entertainment");
	    	sector.setSymbol("MEDIA");
	    	ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in String
			String jsonInString = new String();
			try {
				jsonInString = mapper.writeValueAsString(sector);
				// jsonInSell= mapper.writeValueAsString(predictStocks.)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	  mockMvc.perform(post("/securityDisplay",jsonInString).accept(MediaType.APPLICATION_JSON))
	    	         .andExpect(status().isOk())
	    	         .andExpect(content().contentType("application/json;charset=UTF-8"))
	    	         .andExpect(jsonPath("symbol").value("ZEEL"));
	    }
	    @Test
	    public void logintest() throws Exception {
	    	Userdetail userdetail=new Userdetail();
	    	userdetail.setEmail_id("harrypotter@hogwarts.com");
	    	userdetail.setPassword("Magic@1Maker");
	    	ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in String
			String jsonInString = new String();
			try {
				jsonInString = mapper.writeValueAsString(userdetail);
				// jsonInSell= mapper.writeValueAsString(predictStocks.)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	  mockMvc.perform(post("/Login",jsonInString).accept(MediaType.APPLICATION_JSON))
	    	         .andExpect(status().isOk())
	    	         .andExpect(content().contentType("application/json;charset=UTF-8"))
	    	         .andExpect(jsonPath("password").value("Magic@1Maker"));
	    }
	    @Test
	    public void logintestNotOk() throws Exception {
	    	Userdetail userdetail=new Userdetail();
	    	userdetail.setEmail_id("harrypotter@hogwarts.com");
	    	userdetail.setPassword("harryPotter");
	    	ObjectMapper mapper = new ObjectMapper();

			// Object to JSON in String
			String jsonInString = new String();
			try {
				jsonInString = mapper.writeValueAsString(userdetail);
				// jsonInSell= mapper.writeValueAsString(predictStocks.)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	  mockMvc.perform(post("/Login",jsonInString).accept(MediaType.APPLICATION_JSON))
	    	         .andExpect(status().isOk())
	    	         .andExpect(content().contentType("application/json;charset=UTF-8"))
	    	         .andExpect(jsonPath("password").value("Invalid UserName or Password"));
	    }
	    
	 
	    @Configuration
	    @EnableWebMvc
	    public static class TestConfiguration {
	 
	        @Bean
	        public DemoService demoService() {
	            return new DemoService();
	        }
	 
	    }
	}
