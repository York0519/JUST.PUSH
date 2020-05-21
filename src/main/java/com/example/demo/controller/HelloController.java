package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @author: Yuqiang Wu
 * @date: 2019/9/11 011 13:00
 * @version: V1.0
 */
@RestController
public class HelloController {

  @RequestMapping("/")
  public String get() {
    return "hello world";
  }

}
