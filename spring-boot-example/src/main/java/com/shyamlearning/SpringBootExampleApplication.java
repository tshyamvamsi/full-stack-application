package com.shyamlearning;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.shyamlearning.customer.Customer;
import com.shyamlearning.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
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
import java.util.Random;

@SpringBootApplication
public class SpringBootExampleApplication {
	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(SpringBootExampleApplication.class, args);

		SpringApplication.run(SpringBootExampleApplication.class, args);

//		String [] beanDef = context.getBeanDefinitionNames();
//
//		for(String b:  beanDef){
//			System.out.println(b);
//		}

	}



	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository) {
		return args -> {

			var faker = new Faker();
			Random random = new Random();
			Name name = faker.name();
			String firstName = name.firstName();
			String lastName = name.lastName();
			String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@shyamlearning.com";
			int age = random.nextInt(16, 99);

			Customer customer = new Customer(firstName + " "+ lastName,
					email,
					age);

			customerRepository.save(customer);
		};
	}

	@Bean
	public Foo getFoo(){
		return new Foo("bar");
	}
	record Foo(String name){}




}
