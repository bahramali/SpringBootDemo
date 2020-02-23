package se.telenor.springbootdemo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PathIsNotYetImplementedException.class)
    public String handlePathIsNotYetImplementedException(PathIsNotYetImplementedException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }

    @ExceptionHandler(IdNotNegativeException.class)
    public String handelIdNotNegativeException(IdNotNegativeException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }

    @ExceptionHandler(WrongTypeException.class)
    public String handelWrongTypeException(WrongTypeException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
