package org.example.keyclock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/home")
    public String home(OAuth2AuthenticationToken authentication) {
       try {
           if (authentication != null) {
               OAuth2AuthorizedClient authorizedClient =
                       this.authorizedClientService.loadAuthorizedClient(
                               authentication.getAuthorizedClientRegistrationId(),
                               authentication.getName());

               OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

               log.info("accessToken = " + accessToken);
               log.info("accessToken.getTokenValue() = \n Your Token=" + accessToken.getTokenValue());
           } else {
               return "You don't have Bearer Code !!";
           }
       }catch (Exception e) {
           // Handle the exception
           return "An error occurred: " + e.getMessage();
       }
        return "Welcome to Home Page !!";
    }
}
