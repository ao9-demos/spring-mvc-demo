package io.ao9.springmvcdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class Customer {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    
    @Min(value=1, message = "must be >= 1")
    @Max(value=10, message = "must be <= 10")
    private int passNum;

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
    
    public int getPassNum(){
        return this.passNum;
    }
    
    public void setPassNum(int passNum){
        this.passNum = passNum;
    }

}