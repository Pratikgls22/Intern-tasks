package org.example.spring_profiles;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProfilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesApplication.class, args);
    }

    @Bean
    public ModelMapper modeMapper(){
        return new ModelMapper();
    }
}
