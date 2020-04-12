package com.sr.finra.phoneInfo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sr.finra.phoneInfo.model.PhoneNumberResponse;
import com.sr.finra.phoneInfo.util.PhoneNumberUtil;

/**
 * 
 * @author Srinivas Reddy Patlolla
 *
 */
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	
	@Override
	public List<PhoneNumberResponse> generatePhoneNumbers(String phoneNumber) throws Exception {
		List<PhoneNumberResponse> phoneNumberList = new ArrayList<PhoneNumberResponse>();
		if(!StringUtils.isEmpty(phoneNumber)) {
			AtomicInteger id = new AtomicInteger();
			HashMap<String, List<String>> phoneNumberKeyMap = PhoneNumberUtil.getPhoneNumberKeyMap();
			String phoneNumberSubstitute = phoneNumber.substring(0, phoneNumber.length() - 1);
			Integer phoneNumberLastDigit = Integer.parseInt(phoneNumber.substring(phoneNumber.length() - 1));
			//
			if(phoneNumberLastDigit > 1 && phoneNumberLastDigit < 10) {
				String phoneKey = phoneNumber.substring(phoneNumber.length() - 1);
				phoneNumberKeyMap.get(phoneKey)
				.stream()
				.forEach(p -> {
					PhoneNumberResponse response = new PhoneNumberResponse();
					response.setId(id.incrementAndGet());
					response.setPhoneNumber(phoneNumberSubstitute + p);
					phoneNumberList.add(response);
				});
			} 
		}
		return phoneNumberList;
	}
	
}
