package com.shyamlearning;

import com.shyamlearning.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class SpringBootExampleApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootExampleApplication.class, args);


//		String [] beanDef = context.getBeanDefinitionNames();
//
//		for(String b:  beanDef){
//			System.out.println(b);
//		}
	}

	@Bean
	public Foo getFoo(){
		return new Foo("bar");
	}
	record Foo(String name){}

}
