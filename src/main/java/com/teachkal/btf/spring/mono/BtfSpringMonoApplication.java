package com.teachkal.btf.spring.mono;

import com.teachkal.btf.spring.mono.model.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BtfSpringMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtfSpringMonoApplication.class, args);
	}


	// run after the app context is loaded
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Logger.info("APP STARTED");
		};
	}

}
