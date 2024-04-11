package com.example.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class RuntimeExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse handleResourceNotFound(final RuntimeException exception, final HttpServletRequest request) {
		log.error(exception.getMessage());

		ExceptionResponse error = new ExceptionResponse();
		error.setMessage(exception.getMessage());
		error.setUrl(request.getRequestURI());
		error.setStatus(HttpStatus.BAD_REQUEST.value());

		return error;
	}
}
