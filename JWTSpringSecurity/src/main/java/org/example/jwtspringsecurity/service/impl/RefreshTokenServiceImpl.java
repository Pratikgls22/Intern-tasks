//package org.example.jwtspringsecurity.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.example.jwtspringsecurity.dto.JwtResponse;
//import org.example.jwtspringsecurity.model.RefreshToken;
//import org.example.jwtspringsecurity.repositry.RefreshTokenDao;
//import org.example.jwtspringsecurity.repositry.UserDao;
//import org.example.jwtspringsecurity.service.RefreshTokenService;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class RefreshTokenServiceImpl implements RefreshTokenService {
//
//    private final RefreshTokenDao refreshTokenDao;
//    private final UserDao userDao;
//
////    public RefreshToken createRefreshToken(String username){
////
////
////
////        return refreshTokenDao.save(refreshToken);
////    }
//
////    @Override
////    public JwtResponse createToken(String username) {
////        RefreshToken createToken = RefreshToken.builder()
////                .users(userDao.findByName(username).get())
////                .token(UUID.randomUUID().toString())
////                .expiryDate(Instant.now().plusMillis(6000000))
////                .build();
////
////        RefreshToken refreshToken = RefreshToken.builder()
////                .users(userDao.findByName(username).get())
////                .token(UUID.randomUUID().toString())
////                .expiryDate(Instant.now().plusMillis(10000000 ))
////                .build();
////
////        return new JwtResponse(createToken,refreshToken);
////    }
//
////    public Optional<RefreshToken> findByToken(String token){
////        return refreshTokenDao.findByToken(token);
////    }
////
////    public RefreshToken verifyExpiration(RefreshToken token){
////        if (token.getExpiryDate().compareTo(Instant.now())<0){
////            refreshTokenDao.delete(token);
////            throw new RuntimeException(token.getToken()+"Refresh Token was expired, Please make a new signin request!!");
////        }
////        return token;
////    }
//
//
//}
