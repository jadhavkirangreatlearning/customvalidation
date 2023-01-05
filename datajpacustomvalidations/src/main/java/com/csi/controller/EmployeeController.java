package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImpl.saveData(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @Valid @RequestBody Employee employee){
        //
        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id Does not exist"));

        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpLastName(employee.getEmpLastName());

        return new ResponseEntity<>(employeeServiceImpl.updateData(employee1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
