package com.Admin.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<Object> handleNoContentException(NoContentException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("Error", "No Data found");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleNotUniqueException(SQLIntegrityConstraintViolationException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("Error", "Username already exists, try a different name");
		return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
	}
}