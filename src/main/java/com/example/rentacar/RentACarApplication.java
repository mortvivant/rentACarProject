package com.example.rentacar;

import com.example.rentacar.core.utilities.exceptions.BusinessException;
import com.example.rentacar.core.utilities.exceptions.ProblemDetails;
import com.example.rentacar.core.utilities.exceptions.ValidationProblem;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException){
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        ValidationProblem validationProblem = new ValidationProblem();
        validationProblem.setMessage("VALIDATION.EXCEPTİON");
        validationProblem.setValidations(new HashMap<String,String>());

        for(FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationProblem.getValidations().put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        return validationProblem;
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
