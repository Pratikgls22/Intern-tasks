package org.example.testcasesspringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "your name is empty, feel it")
    @NotNull(message = "your name is null, fill it")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "you city is empty, feel it")
    @NotNull(message = "your city is null, fill it")
    @Column(name = "city")
    private String city;

    @NotEmpty(message = "you phone is empty, feel it")
    @NotNull(message = "your phone is null, fill it")
    @Size(min = 10,max = 10)
    @Column(name = "phone")
    private String phone;
}
