package com.fns.product.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories(basePackages = {
		"com.fns.product.service.dataaccess.product.repository",
})
@EntityScan(basePackages = {
		"com.fns.product.service.dataaccess.product.entity",
})
@SpringBootApplication(scanBasePackages = "com.fns")
public class 	ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@GetMapping("/world")
	public String world(){
		return  "Hello World kfs;";
	}

}
