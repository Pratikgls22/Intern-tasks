package org.example.openapifeignclient.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nonapi.io.github.classgraph.json.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
}
