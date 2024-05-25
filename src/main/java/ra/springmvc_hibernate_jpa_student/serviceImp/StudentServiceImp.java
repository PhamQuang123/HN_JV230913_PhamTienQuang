package ra.springmvc_hibernate_jpa_student.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import ra.springmvc_hibernate_jpa_student.dto.request.CreateStudentRequest;
import ra.springmvc_hibernate_jpa_student.mapper.CreateStudentmapper;
import ra.springmvc_hibernate_jpa_student.model.Student;
import ra.springmvc_hibernate_jpa_student.repository.IStudentRepository;
import ra.springmvc_hibernate_jpa_student.service.IStudentService;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class StudentServiceImp implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private CreateStudentmapper createStudentmapper;
    private static final String uploadPath ="G:\\Rikkei\\MD4-CSDL-MySQL\\springMVC_hibernate_jpa_student\\src\\main\\webapp\\upload";

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(CreateStudentRequest request) {

        return studentRepository.save(createStudentmapper.mapperRequestToEntity(request));
    }

    @Override
    public Student update(CreateStudentRequest request) {

        Student oldStudent = findbyId(request.getStudentId());
        if (oldStudent == null){
            throw new RuntimeException("Khong ton tai student");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = sdf.parse(request.getBirthday());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        MultipartFile file = request.getImgUrl();
        if (file.getSize() !=0){
            String fileName = file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes(),new File(uploadPath+File.separator+fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            oldStudent.setImgUrl(fileName);

        }
        oldStudent.setStudentName(request.getStudentName());
        oldStudent.setBirthday(birth);
        oldStudent.setAddress(request.getAddress());
        oldStudent.setPhoneNumber(request.getPhoneNumber());
        oldStudent.setGender(request.getGender());
        return studentRepository.save(oldStudent);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findbyId(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findStudentByStudentName(String studentName) {
        return studentRepository.findStudentByStudentName(studentName);
    }
}
