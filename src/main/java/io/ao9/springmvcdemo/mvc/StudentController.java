package io.ao9.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController{
    
    @RequestMapping("/showStudentForm")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @RequestMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){
        System.out.println(student.getFirstName()+" "+student.getLastName());
        return "studentInfo";
    }
}