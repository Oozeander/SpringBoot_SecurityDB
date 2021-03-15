package com.oozeander;

import com.oozeander.model.User;
import com.oozeander.model.auth.Role;
import com.oozeander.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SpringSecurityDatabaseAuthApplication {
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SpringSecurityDatabaseAuthApplication(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDatabaseAuthApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			userService.saveAll(List.of(
					new User("Oozeander", "billel.ketrouci@gmail.com", passwordEncoder.encode("Ashura"), Role.ADMIN, Role.ADMIN.getPermissions(), true),
					new User("bketrouci", "billel.ketrouci@outlook.fr", passwordEncoder.encode("1234"), Role.USER, Role.USER.getPermissions(), true)
			));
		};
	}
}