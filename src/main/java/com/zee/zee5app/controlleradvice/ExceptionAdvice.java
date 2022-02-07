package com.zee.zee5app.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsException(AlreadyExistsException e)
	{
		Map<String,String> map=new HashMap<>();
		map.put("string", "record already exists "+e.getMessage());
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
	public ResponseEntity<?> exceptionHandler(Exception e)
	{
		Map<String,String> map=new HashMap<>();
		map.put("string", "unknown exception "+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
}
