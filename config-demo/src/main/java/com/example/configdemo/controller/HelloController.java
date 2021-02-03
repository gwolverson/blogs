package com.example.configdemo.controller;

import static java.lang.System.getenv;

import com.example.configdemo.config.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final DemoProperties properties;

  @Autowired
  public HelloController(DemoProperties properties) {
    this.properties = properties;
  }

  @GetMapping("/hello")
  public String hello() {
    System.out.println("DB URL: " + properties.getUrl());
    System.out.println("DB Username: " + getenv("DB_USERNAME"));
    System.out.println("DB Password: " + getenv("DB_PASSWORD"));

    return "Hello World!";
  }
}

