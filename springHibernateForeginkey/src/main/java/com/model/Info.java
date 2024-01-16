package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userInfoTable")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Info_Id")
    private int userInfoId;
    @Column(name = "Age")
    private int userAge;
    @Column(name = "City")
    private String userCity;

    @Override
    public String toString() {
        return "Info{" +
                "userInfoId=" + userInfoId +
                ", userAge=" + userAge +
                ", userCity='" + userCity + '\'' +
                '}';
    }
}
