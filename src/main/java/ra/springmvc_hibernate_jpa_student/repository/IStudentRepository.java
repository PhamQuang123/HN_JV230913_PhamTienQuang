package ra.springmvc_hibernate_jpa_student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springmvc_hibernate_jpa_student.model.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentByStudentName(String studentName);
}
