package io.ao9.springmvcdemo.mvc;

import org.springframework.stereotype.Component;

@Component
public class Student{
    private String firstName;
    private String lastName;
    private String country;
    private String favLang;
    
    public Student() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getFavLang(){
        return this.favLang;
    }
    
    public void setFavLang(String favLang){
        this.favLang = favLang;
    }
}