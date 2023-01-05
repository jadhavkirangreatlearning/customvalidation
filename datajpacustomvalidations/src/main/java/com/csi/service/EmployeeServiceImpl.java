package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee saveData(Employee employee){
        return employeeDaoImpl.saveData(employee);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId){
        employeeDaoImpl.deleteDataById(empId);
    }
}
