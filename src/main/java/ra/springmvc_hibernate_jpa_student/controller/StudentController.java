package ra.springmvc_hibernate_jpa_student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_hibernate_jpa_student.dto.request.CreateStudentRequest;
import ra.springmvc_hibernate_jpa_student.model.Student;
import ra.springmvc_hibernate_jpa_student.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping({"/findAll","/"})
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView("student");
        List<Student> listStudent = studentService.findAll();
        mav.addObject("listStudent", listStudent);
        return mav;
    }
    @GetMapping("/add")
    public String add(){
        return "newStudent";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute CreateStudentRequest createStudentRequest){
        studentService.save(createStudentRequest);
        return "redirect:/findAll";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("studentId") Integer id){
        studentService.deleteById(id);
        return "redirect:/findAll";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer studentId, Model model){
        Student student = studentService.findbyId(studentId);
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("student") CreateStudentRequest request){

        studentService.update(request);
        return "redirect:findAll";
    }
    @GetMapping("/search")
    public ModelAndView findStudentByName(@RequestParam String studentName){
        ModelAndView mav = new ModelAndView("student");
        mav.addObject("listStudent",studentService.findStudentByStudentName(studentName));
        return mav;
    }

}
