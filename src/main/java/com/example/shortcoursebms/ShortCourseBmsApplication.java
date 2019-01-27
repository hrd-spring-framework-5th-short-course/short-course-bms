package com.example.shortcoursebms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Base64;

@SpringBootApplication
@EnableSwagger2
public class ShortCourseBmsApplication implements ApplicationRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ShortCourseBmsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(passwordEncoder.encode("123123"));

        System.out.println(Base64.getUrlEncoder().encodeToString("sida:123123".getBytes()));
    }
}
