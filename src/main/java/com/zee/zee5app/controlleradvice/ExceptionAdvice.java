package com.zee.zee5app.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.apierror.ApiError;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsException(AlreadyExistsException e) {
		Map<String, String> map = new HashMap<>();
		map.put("string", "record already exists " + e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}

//	@ExceptionHandler(IdNotFoundException.class)
//	public ResponseEntity<?> idnotFoundException(IdNotFoundException e)
//	{
//		Map<String,String> map=new HashMap<>();
//		map.put("string", "id was not found "+e.getMessage());
//		return ResponseEntity.badRequest().body(map);
//	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e) {
		Map<String, String> map = new HashMap<>();
		map.put("string", "unknown exception " + e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
//				Customization of validate
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation Error");
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError)
	{
		return new ResponseEntity<>(apiError,apiError.getHttpStatus());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<?> handleConstraintViolation(){
		return null;
	}
}
