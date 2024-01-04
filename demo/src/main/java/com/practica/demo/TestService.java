package com.practica.demo;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@Slf4j
@AllArgsConstructor
public class TestService {

    public Object validate(Object object){
        if(Objects.nonNull(object)){
            log.info("Datos validos");
        }else{
            throw new RuntimeException("Datos no validos");
        }
        return new Object();
    }
}
