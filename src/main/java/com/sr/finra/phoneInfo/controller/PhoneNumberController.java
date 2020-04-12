package com.sr.finra.phoneInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sr.finra.phoneInfo.model.PhoneNumberResponse;
import com.sr.finra.phoneInfo.service.PhoneNumberService;

@RestController
public class PhoneNumberController {

	@Autowired
	PhoneNumberService phoneNumberService;
	
	/**
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/getPhoneNumbers")
	public List<PhoneNumberResponse> getGeneratedPhoneNumbers(@RequestParam (value="phoneNumber") String phoneNumber) throws Exception {
		return phoneNumberService.generatePhoneNumbers(phoneNumber);
	}
}
