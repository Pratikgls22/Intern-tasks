package org.example.resttemplate.enums;

public enum CommonEnums {
    EXCEPTION_MSG("Employee not found by this Id !!");

    private String message;

    CommonEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
