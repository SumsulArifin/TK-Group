package com.tkgroupbd.pusti.api.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.logging.Logger;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

    @ExceptionHandler(Exception.class)
    public String generalExceptionHandler(Exception e) {
        logger.info("Global Exception Handler Invoked ! " + e.getMessage());
        e.printStackTrace();
        return "redirect:/error/500";
    }
}
