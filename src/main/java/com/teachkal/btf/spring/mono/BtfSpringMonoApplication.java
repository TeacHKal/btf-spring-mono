package com.teachkal.btf.spring.mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BtfSpringMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtfSpringMonoApplication.class, args);
	}

}
