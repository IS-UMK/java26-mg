package org.example.mvc_demo.exception;


import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlers {


    public GlobalExceptionHandlers(){

    }

    public int add(int a,int b){

        return a+b;
    }




}
