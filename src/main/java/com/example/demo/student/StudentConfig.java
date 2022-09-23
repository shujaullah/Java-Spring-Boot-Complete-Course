package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
            Student marium = new Student(
                    "marium",
                    "marium.jamal@gamil.com",
                    LocalDate.of(2000, Month.JANUARY, 5 ));
            Student hamza = new Student(
                    "hamza",
                    "hamza.aziz@gamil.com",
                    LocalDate.of(1998, Month.MAY, 23));

            repository.saveAll(List.of(marium, hamza));
        };
    }
}
