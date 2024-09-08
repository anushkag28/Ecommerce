package com.example.scm.config;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.scm.Mapper.ProductMapper;
import com.example.scm.services.impl.UserServiceImpl;


@Configuration
@ComponentScan


public class ProductConfig {
   


@Bean
public UserServiceImpl userServiceImpl(){
        return new UserServiceImpl();
}

    @Bean
    public ProductMapper productMapper(){
        return  new ProductMapper();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
