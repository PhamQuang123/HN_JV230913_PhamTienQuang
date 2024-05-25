package ra.springmvc_hibernate_jpa_student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "img_url", columnDefinition = "varchar(255)")
    private String imgUrl;
    @Column(columnDefinition = "varchar(100)")
    private String studentName;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(columnDefinition = "varchar(15)")
    private String phoneNumber;
    @Column(columnDefinition = "1")
    private Boolean gender;

    public String test() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(birthday);
        return today;
    }
}
