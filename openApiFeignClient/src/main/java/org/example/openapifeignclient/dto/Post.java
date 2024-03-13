package org.example.openapifeignclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private Integer userId;

    private Integer id;

    private String title;

    private String body;
}