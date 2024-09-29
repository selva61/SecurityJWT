package com.selva.securityjwt;

import org.springframework.boot.SpringApplication;

public class TestSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.from(SecurityJwtApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
