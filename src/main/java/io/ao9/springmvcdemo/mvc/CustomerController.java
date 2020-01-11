package io.ao9.springmvcdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController{
    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        theModel.addAttribute("theCustomer", new Customer());
        return "customerForm";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("theCustomer") Customer theCustomer, BindingResult theBindingResult){
        if(theBindingResult.hasErrors()) return "customerForm";
        else return "customerInfo";
    }
}