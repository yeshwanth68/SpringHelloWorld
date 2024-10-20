package com.example.demo.controller;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Greetings;

@RestController
public class MainController {
	
	
	@GetMapping("/hello")
	public String getname()
	{
		return "Hello world";
	}
	
	@GetMapping("/hello1")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

	
	@GetMapping("/json")
	public Greetings getjson() {
		Greetings user = new Greetings();
		user.setId(1);
		user.setName("Yeshwanth");
		return user;
	}
	
	@PostMapping("/request")
	public String request(@RequestBody Greetings greetings) {
		
		return greetings.getName();
		
		
	}
	
	@PostMapping("/add")
	public int request1(@RequestBody Greetings greet) {
		return greet.getNum1()+greet.getNum2();
	}
	
	
	@PostMapping("/calculator")
	public int calculator(@RequestBody Greetings greet) {
		
		String symbol = greet.getSymbol();
		int value = 0;
		
		if(symbol.equals("+")) {
			value = greet.getNum1()+greet.getNum2();
		}
		if(symbol.equals("-")) {
			value = greet.getNum1()-greet.getNum2();
		}
		if(symbol.equals("*")) {
			value = greet.getNum1()*greet.getNum2();
		}
		if(symbol.equals("/")) {
			value = greet.getNum1()/greet.getNum2();
		}
		if(symbol.equals("%")) {
			value = greet.getNum1()%greet.getNum2();
		}
		return value;	
	}
	
	
	
	
	
}
