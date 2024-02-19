package org.example.auth2server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "active")
    private int active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns =
    @JoinColumn(name = "user_id"), inverseJoinColumns =
    @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Users() {
    }

    public Users(Users users) {
        this.active = users.active;
        this.email = users.email;
        this.id = users.id;
        this.name = users.name;
        this.lastName = users.lastName;
        this.password = users.password;
        this.roles = users.roles;
    }
}
