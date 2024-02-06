package org.example.swaggeruispringboot.swaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class SwaggerCongif {
    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(
                new Info().title("test").description("test").version("0.0.")).servers(List.of(new Server().url("/")));
    }
}
