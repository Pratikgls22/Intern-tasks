package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int userId;
    @Column(name = "Name")
    private String userName;
    @Column(name = "Email")
    private String userEmail;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Info_Id")
    private Info info;



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmil='" + userEmail + '\'' +
                '}';
    }
}
