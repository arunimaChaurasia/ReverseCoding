package com.cummins.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	    public void contact() throws Exception {
	        
	        mockMvc.perform(get("/sectorDisplay").accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is(500));
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
