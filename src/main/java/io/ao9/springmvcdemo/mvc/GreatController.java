package io.ao9.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/great")
public class GreatController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    
    @RequestMapping("/processFormV2")
    public String processFormShout(HttpServletRequest request, Model model){
        String name = request.getParameter("studentname");
        
        name = name.toUpperCase();
        
        model.addAttribute("message", "Yo! "+name);
        
        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentname") String name, Model model){      
        name = name.toUpperCase();
        
        model.addAttribute("message", "Ah ha! "+name);
        
        return "helloworld";
    }
}