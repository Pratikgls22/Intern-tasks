package com.model;

import javax.persistence.*;

@Entity
@Table(name = "sprindMvcTable")
public class RegVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Reg_id")
    private int id;
    @Column(name = "Reg_firstname")
    private String firstname;
    @Column(name = "Reg_lastname")
    private String lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
