package com.martinezsoft.gotthat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.martinezsoft.com")
public class GotThatApp {
    public static void main (String[] args){
        SpringApplication.run(GotThatApp.class, args);
    }
}
