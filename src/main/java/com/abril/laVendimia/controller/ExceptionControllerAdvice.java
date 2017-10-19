package com.abril.laVendimia.controller;

import com.concredito.exceptionsSpring.BusinessRuleException;
import com.concredito.exceptionsSpring.ContractViolationException;
import org.springframework.data.repository.support.QueryMethodParameterConversionException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionControllerAdvice {
    private Logger logger = Logger.getLogger(ExceptionControllerAdvice.class.getName());

    private HashMap<String, String> createBody(Exception ex ) {
        this.logger.log( Level.SEVERE, ex.getMessage() );
        HashMap<String, String> mapResult = new HashMap<>();
        mapResult.put("message", ex.getMessage());
        return mapResult;
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(BusinessRuleException ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(IOException ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(ResourceNotFoundException ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContractViolationException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(ContractViolationException ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(SQLException ex) {
        HashMap<String, String> body = this.createBody(ex);
        this.logger.log( Level.SEVERE, ex.getSQLState() );
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(IllegalAccessException ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(Exception ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(NullPointerException ex) {
        ex.getLocalizedMessage();
        this.logger.log( Level.SEVERE, ex.getLocalizedMessage() );
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(QueryMethodParameterConversionException.class)
    public ResponseEntity<HashMap<String, String>> exceptionHandler(QueryMethodParameterConversionException ex) {
        HashMap<String, String> body = this.createBody(ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
