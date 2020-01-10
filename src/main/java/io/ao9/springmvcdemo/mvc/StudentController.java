package io.ao9.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;

@Controller
public class StudentController{
    @Value("#{countryOptions}")
    private HashMap<String, String> countryOptions;
    @Value("#{favoriteLanguages}")
    private HashMap<String, String> favoriteLanguages;
    
    @RequestMapping("/showStudentForm")
    public String showStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("countryOptions", countryOptions);
        model.addAttribute("favoriteLanguages", favoriteLanguages);
        
        return "studentForm";
    }

    @RequestMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){
        // System.out.println(student.getFirstName()+" "+student.getLastName());
        // System.out.println(student.getCountry());
        return "studentInfo";
    }
}