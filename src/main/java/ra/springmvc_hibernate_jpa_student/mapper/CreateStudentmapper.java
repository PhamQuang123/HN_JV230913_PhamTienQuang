package ra.springmvc_hibernate_jpa_student.mapper;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import ra.springmvc_hibernate_jpa_student.dto.request.CreateStudentRequest;
import ra.springmvc_hibernate_jpa_student.model.Student;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CreateStudentmapper implements GenerricMapper<CreateStudentRequest, Student, Student> {
    private static final String uploadPath ="G:\\Rikkei\\MD4-CSDL-MySQL\\springMVC_hibernate_jpa_student\\src\\main\\webapp\\upload";
    @Override
    public Student mapperRequestToEntity(CreateStudentRequest createStudentRequest) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = sdf.parse(createStudentRequest.getBirthday());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (createStudentRequest.getImgUrl() != null){
            try {
                FileCopyUtils.copy(createStudentRequest.getImgUrl().getBytes(), new File(
                        uploadPath+File.separator+createStudentRequest.getImgUrl().getOriginalFilename()
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        Student student = Student.builder().studentName(createStudentRequest.getStudentName())
                .address(createStudentRequest.getAddress())
                .birthday(birth)
                .imgUrl(createStudentRequest.getImgUrl().getOriginalFilename())
                .gender(createStudentRequest.getGender())
                .phoneNumber(createStudentRequest.getPhoneNumber()).build();
        return student;
    }

    @Override
    public Student mapperEntityToReponse(Student student) {

        return null;
    }
}
