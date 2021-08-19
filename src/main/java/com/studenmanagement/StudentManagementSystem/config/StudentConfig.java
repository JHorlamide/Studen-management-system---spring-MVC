package com.studenmanagement.StudentManagementSystem.config;

import com.studenmanagement.StudentManagementSystem.entity.Student;
import com.studenmanagement.StudentManagementSystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student1 = new Student(
                    "Olamide",
                    "Jubril",
                    "olamide.jubril@outlook.com"
            );

            Student student2 = new Student(
                    "JHorlamide",
                    "Muiz",
                    "jhorlamide@gmail.com"
            );

            Student student3 = new Student(
                    "Horlamide",
                    "Jubril",
                    "horlamide@yahoo.com"
            );

            studentRepository.saveAll(List.of(student1, student2, student3));
        };
    }
}
