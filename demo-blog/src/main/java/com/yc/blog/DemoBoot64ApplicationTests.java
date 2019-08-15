package com.yc.blog;

import java.util.Date;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@Controller
@MapperScan("com.yc")
public class DemoBoot64ApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(DemoBoot64ApplicationTests.class, args);
	}

	@GetMapping("hello")
	public String Hello() {
		return "hello";
	}
	
	@GetMapping("world")
	public String World() {
		return "forward:hello";
	}
	@Bean
	public Date getNow() {
		
		return new Date();
	}
}
