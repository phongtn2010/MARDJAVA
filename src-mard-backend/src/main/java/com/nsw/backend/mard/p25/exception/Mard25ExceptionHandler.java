package com.nsw.backend.mard.p25.exception;

import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class Mard25ExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(Mard25ExceptionHandler.class);

    @ExceptionHandler(value = {NSWException.class})
    public ResponseEntity<ResponseJson> handleNSWException(HttpServletRequest request, NSWException e) {
        log.debug("Exception Caught: {}", e.getMessage());
        log.debug("", e);
        return ResponseEntity.ok(new ResponseJson(false, null, e.getMessage()));
    }
}
