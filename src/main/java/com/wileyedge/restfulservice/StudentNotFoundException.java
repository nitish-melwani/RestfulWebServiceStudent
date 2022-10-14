package com.wileyedge.restfulservice;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND) //error 404
public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
