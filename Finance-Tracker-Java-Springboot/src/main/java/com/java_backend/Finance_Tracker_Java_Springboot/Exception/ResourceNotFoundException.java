package com.java_backend.Finance_Tracker_Java_Springboot.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
