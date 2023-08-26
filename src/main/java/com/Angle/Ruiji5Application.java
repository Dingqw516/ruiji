package com.Angle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@SpringBootApplication
@ServletComponentScan
public class Ruiji5Application {
    public static void main(String[] args) {
      SpringApplication.run(Ruiji5Application.class,args);
        log.info("注解都能写错位置，不是废物是啥？？");
    }
}