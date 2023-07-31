package ovh.equino.SpringBootDataTutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDataTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataTutorialApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student maria = new Student(
					"Maria",
					"Alvarez",
					"ma@equino.ovh",
					21
			);
			studentRepository.save(maria);
		};
	}
}
