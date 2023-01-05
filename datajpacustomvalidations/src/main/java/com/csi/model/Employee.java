package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    @Size(min = 2, message = "Employee First Name should be atleast 2 character")
    private String empFirstName;

    @Pattern(regexp="[A-Za-z]*", message="Last name should not contain space and special characters")
    private String empLastName;

    private double empSalary;

    private long empContactNumber;

    @Email(message = "Email Id must be valid")
    private String empEmailId;

    @Size(min = 4, message = "Password atleast 4 character")
    private String empPassword;


}
