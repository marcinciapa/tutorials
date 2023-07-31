package ovh.equino.SpringBootTutorial.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if(!studentExists) {
            throw new IllegalStateException("Student does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, Student updatedStudent) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()) {
            throw new IllegalStateException("Student does not exist");
        }
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(updatedStudent.getEmail());
        if (studentByEmail.isPresent() && !Objects.equals(studentByEmail.get().getId(), studentId)) {
            throw new IllegalStateException("Email taken");
        }
        student.get().setName(updatedStudent.getName());
        student.get().setEmail(updatedStudent.getEmail());
    }
}
