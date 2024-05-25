package ra.springmvc_hibernate_jpa_student.service;

import ra.springmvc_hibernate_jpa_student.dto.request.CreateStudentRequest;
import ra.springmvc_hibernate_jpa_student.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student save(CreateStudentRequest request);

    Student update( CreateStudentRequest request);
    void deleteById(Integer id);

    Student findbyId(Integer id);

    List<Student> findStudentByStudentName(String studentName);

}
