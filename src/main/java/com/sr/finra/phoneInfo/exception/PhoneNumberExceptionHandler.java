package com.sr.finra.phoneInfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhoneNumberExceptionHandler {
	
	/**
	 *
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity exceptionHandler(Exception ex) {
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}