package com.sr.finra.phoneInfo.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Srinivas Reddy Patlolla
 *
 */
public class PhoneNumberUtil {

	private static final HashMap<String, List<String>> phoneNumberKeyMap = new HashMap<>();
	
	static {
		phoneNumberKeyMap.put("2", Arrays.asList("A","B","C"));
		phoneNumberKeyMap.put("3", Arrays.asList("D","E","F"));
		phoneNumberKeyMap.put("4", Arrays.asList("G","H","I"));
		phoneNumberKeyMap.put("5", Arrays.asList("J","K","L"));
		phoneNumberKeyMap.put("6", Arrays.asList("M","N","O"));
		phoneNumberKeyMap.put("7", Arrays.asList("P","Q","R","S"));
		phoneNumberKeyMap.put("8", Arrays.asList("T","U","V"));
		phoneNumberKeyMap.put("9", Arrays.asList("W","X","Y","Z"));
	}
	
	public static HashMap<String, List<String>> getPhoneNumberKeyMap(){
		return phoneNumberKeyMap;
	}
}
