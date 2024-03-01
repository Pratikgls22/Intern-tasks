package org.example.projection_springboot.enums;

import lombok.Getter;


@Getter
public enum CommonEnums {
    EXCEPTION_MSG("User Not Found");
    private String errors;

    CommonEnums(String errors) {
        this.errors = errors;
    }

}
