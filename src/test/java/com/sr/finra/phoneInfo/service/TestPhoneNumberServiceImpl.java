package com.sr.finra.phoneInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sr.finra.phoneInfo.model.PhoneNumberResponse;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPhoneNumberServiceImpl {
	
	@Autowired
	PhoneNumberService phoneNumberService;

	@Test
	public void testGeneratePhoneNumbers_HappyPath() throws Exception {
		List<PhoneNumberResponse> phoneNumberResponseList = phoneNumberService.generatePhoneNumbers("123456789");
		Assert.assertEquals(4, phoneNumberResponseList.size());
	}
	
	@Test
	public void testGeneratePhoneNumbers_HappyPath_Verify_Values() throws Exception {
		List<PhoneNumberResponse> expectedPhoneNumberResponseList = new ArrayList<PhoneNumberResponse>();
		PhoneNumberResponse phoneNumber1 = new PhoneNumberResponse();
		phoneNumber1.setId(1);
		phoneNumber1.setPhoneNumber("12345678W");
		expectedPhoneNumberResponseList.add(phoneNumber1);
		PhoneNumberResponse phoneNumber2 = new PhoneNumberResponse();
		phoneNumber2.setId(2);
		phoneNumber2.setPhoneNumber("12345678X");
		expectedPhoneNumberResponseList.add(phoneNumber2);
		PhoneNumberResponse phoneNumber3 = new PhoneNumberResponse();
		phoneNumber3.setId(3);
		phoneNumber3.setPhoneNumber("12345678Y");
		expectedPhoneNumberResponseList.add(phoneNumber3);
		PhoneNumberResponse phoneNumber4 = new PhoneNumberResponse();
		phoneNumber4.setId(4);
		phoneNumber4.setPhoneNumber("12345678Z");
		expectedPhoneNumberResponseList.add(phoneNumber4);
		//
		List<PhoneNumberResponse> actualPhoneNumberResponseList = phoneNumberService.generatePhoneNumbers("123456789");
		Assert.assertEquals(4, actualPhoneNumberResponseList.size());
		Assert.assertEquals(expectedPhoneNumberResponseList.get(0).getPhoneNumber(), actualPhoneNumberResponseList.get(0).getPhoneNumber());
		Assert.assertEquals(expectedPhoneNumberResponseList.get(3).getPhoneNumber(), actualPhoneNumberResponseList.get(3).getPhoneNumber());
	}
	
	@Test
	public void testGeneratePhoneNumbers_EmptyList() throws Exception {
		List<PhoneNumberResponse> phoneNumberResponseList = phoneNumberService.generatePhoneNumbers("");
		Assert.assertEquals(0, phoneNumberResponseList.size());
	}

	@Test
	public void testGeneratePhoneNumbers_EmptyList_Null() throws Exception {
		List<PhoneNumberResponse> phoneNumberResponseList = phoneNumberService.generatePhoneNumbers(null);
		Assert.assertEquals(0, phoneNumberResponseList.size());
	}

}
