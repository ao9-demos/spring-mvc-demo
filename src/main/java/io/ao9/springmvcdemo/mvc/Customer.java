package io.ao9.springmvcdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import io.ao9.springmvcdemo.mvc.validation.CourseCode;

public class Customer {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    
    @Min(value=1, message = "must be >= 1")
    @Max(value=10, message = "must be <= 10")
    private Integer passNum;
    
    @Pattern(regexp = "^\\w{5}$", message = "only 5 chars/digits")
    private String post;
    
    @CourseCode(value = "DA", message = "must start with DA")
    private String courseCode;

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
    
    public Integer getPassNum(){
        return this.passNum;
    }
    
    public void setPassNum(Integer passNum){
        this.passNum = passNum;
    }
    
    public String getPost(){
        return this.post;
    }
    
    public void setPost(String post){
        this.post = post;
    }
    
    public String getCourseCode(){
        return this.courseCode;
    }
    
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }
}