package com.sr.finra.phoneInfo.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sr.finra.phoneInfo.PhoneInfoApplication;


@ContextConfiguration(classes = PhoneInfoApplication.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPhoneNumberController {

private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void testGetGeneratedPhoneNumbers_HappyPath() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getPhoneNumbers?phoneNumber=1234565").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(3))).andDo(print());
	}
	
	@Test
	public void testGetGeneratedPhoneNumbers_HappyPath_PQRS() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getPhoneNumbers?phoneNumber=1234567").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}
	
	@Test
	public void testGetGeneratedPhoneNumbers_HappyPath_WXYZ() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getPhoneNumbers?phoneNumber=1234569").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}
	
	@Test
	public void testGetGeneratedPhoneNumbers_Empty_Array_For_Zero_And_One() throws Exception {
		// test case for phone number ending with 0, no alphabets to generate combinations.
		mockMvc.perform(MockMvcRequestBuilders.get("/getPhoneNumbers?phoneNumber=1234567890").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(0))).andDo(print());
		// test case for phone number ending with 1, no alphabets to generate combinations.
		mockMvc.perform(MockMvcRequestBuilders.get("/getPhoneNumbers?phoneNumber=1234567891").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(0))).andDo(print());
	}
}
