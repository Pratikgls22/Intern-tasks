package org.example.springdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(SpringDiApplication.class, args);
        Student student = context.getBean(Student.class);
        student.setId(78689);
        System.out.println(student.getId());
    }

}
