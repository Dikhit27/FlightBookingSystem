package com.fbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalHandlerException {
	 

//	    @ExceptionHandler(NotFoundException.class)
//
//	    public ResponseEntity<String> handlerNotFoundException(Exception e){
//
//	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);    
//
//	    }


	    @ExceptionHandler(FlightNotFoundException.class)

	    public ResponseEntity<String> handlerFlightNotFoundException(Exception e){

	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);    

	    }


//	    @ExceptionHandler(AlreadyPresentException.class)
//
//	    public ResponseEntity<String> handlerAlreadyPresentException(Exception e){
//
//	        return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);    
//
//	    }


	
}
