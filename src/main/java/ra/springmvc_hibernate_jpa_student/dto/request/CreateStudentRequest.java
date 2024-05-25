package ra.springmvc_hibernate_jpa_student.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateStudentRequest {
    private Integer studentId;
    private MultipartFile imgUrl;
    private String studentName;
    private String address;
    private String birthday;
    private String phoneNumber;
    private Boolean gender;
}
