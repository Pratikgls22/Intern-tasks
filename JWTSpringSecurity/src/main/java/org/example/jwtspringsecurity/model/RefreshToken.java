//package org.example.jwtspringsecurity.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.Instant;
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Builder
//public class RefreshToken {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String token;
//    private Instant expiryDate;
//    @OneToOne
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    private Users users;
//}
