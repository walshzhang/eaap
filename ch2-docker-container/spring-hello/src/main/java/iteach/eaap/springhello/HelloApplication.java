package iteach.eaap.springhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("*")
@SpringBootApplication
public class HelloApplication {

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return String.format("Hello, %s!", name);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
