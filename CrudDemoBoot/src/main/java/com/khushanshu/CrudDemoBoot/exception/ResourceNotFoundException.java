package com.khushanshu.CrudDemoBoot.exception;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String message) {
        super(message);
    }
}
