package org.example.config;

import org.example.model.Student;
import org.example.model.Subject;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        return args -> {
            // Add some test students
            System.out.println("Populating database with students...");
            studentRepository.save(new Student(null, "John", "Doe", "john.doe@school.com", null));
            studentRepository.save(new Student(null, "Mary", "Smith", "mary.smith@school.com", null));
            studentRepository.save(new Student(null, "Andrew", "Jones", "andrew.j@school.com", null));

            // Add some subjects
            System.out.println("Populating database with subjects...");
            subjectRepository.save(new Subject(null, "Mathematics", null));
            subjectRepository.save(new Subject(null, "Computer Science", null));
            subjectRepository.save(new Subject(null, "English Literature", null));
            
            System.out.println("Database is ready!");
        };
    }
}
