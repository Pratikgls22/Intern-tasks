package org.example.jwtspringsecurity.enums;

public enum CommonEnums {
    EXCEPTION_MSG("USER NOT FOUND !!");
    private String errors;

    CommonEnums(String errors) {
        this.errors = errors;
    }
}
