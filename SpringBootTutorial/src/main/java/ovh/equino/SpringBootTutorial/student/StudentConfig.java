package ovh.equino.SpringBootTutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student johnS = new Student("John S", "js@equino.ovh", LocalDate.of(2000, 1, 2));
            Student adamB = new Student("Adam B", "ab@equino.ovh", LocalDate.of(2003, 2, 1));
            studentRepository.saveAll(List.of(johnS, adamB));
        };
    }
}
