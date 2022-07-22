package ru.igor.metroproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.igor.metroproject.service.RoutService;
import ru.igor.metroproject.util.RoutTestData;

@SpringBootApplication
public class MetroProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetroProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            RoutService routService = context.getBean("routService", RoutService.class);
            RoutTestData.getRouts().forEach(rout -> routService.save(rout));
        };
    }

}
