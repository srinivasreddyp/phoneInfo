package com.sr.finra.phoneInfo.model;

public class PhoneNumberResponse {

	private Integer id;
	private String phoneNumber;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "PhoneNumberResponse [id=" + id + ", phoneNumber=" + phoneNumber + "]";
	}	

}
