package com.foodDelivery.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails {

    private LocalDateTime localDateTime;
    private String message;
    private String description;

    public MyErrorDetails() {
    }

    public MyErrorDetails(LocalDateTime localDateTime, String message, String description) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
