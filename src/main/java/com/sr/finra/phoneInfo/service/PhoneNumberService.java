package com.sr.finra.phoneInfo.service;

import java.util.List;

import com.sr.finra.phoneInfo.model.PhoneNumberResponse;

/**
 * 
 * @author Srinivas Reddy Patlolla
 *
 */
public interface PhoneNumberService {
	public List<PhoneNumberResponse> generatePhoneNumbers(String phoneNumber) throws Exception;
}
