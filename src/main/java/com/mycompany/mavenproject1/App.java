package com.mycompany.mavenproject1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karo
 */
@SpringBootApplication
public class App {
      public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
      
        @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
