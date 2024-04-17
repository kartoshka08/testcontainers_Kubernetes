package com.example.testcontainersKubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestcontainersKubernetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcontainersKubernetesApplication.class, args);
	}

    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
    @RestController
    @RequestMapping("/")
    public class ProfileController {
        private SystemProfile profile;

        public ProfileController(SystemProfile profile) {
            this.profile = profile;
        }

        @GetMapping("profile")
        public String getProfile() {
            return profile.getProfile();
        }
    }
}

