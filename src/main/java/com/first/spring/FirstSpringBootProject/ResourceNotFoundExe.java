package com.first.spring.FirstSpringBootProject;

public class ResourceNotFoundExe extends RuntimeException{
    public ResourceNotFoundExe(){
        super("Resource not found on server!!");
    }

    public ResourceNotFoundExe(String message){
        super(message);
    }
}
