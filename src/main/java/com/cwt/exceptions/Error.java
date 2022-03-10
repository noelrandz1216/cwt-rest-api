package com.cwt.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Error {
	private final HttpStatus httpStatus;
	private final String message;

}
