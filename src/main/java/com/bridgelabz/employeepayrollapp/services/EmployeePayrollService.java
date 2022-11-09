package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;
   // private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    /**
     * Method for All Employee Payroll data List
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }

    /**
     * Method for get an employee data by id
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee With employee id "+empId+" does not exists..!"));
    }

    /**
     * Method to Create an Employee Payroll data
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        log.debug(("Emp Data: "+employeePayrollData.toString()));
        return employeePayrollRepository.save(employeePayrollData);
    }


    /**
     * Method to Update an Employee Payroll data
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    /**
     * Method to Delete an Employee Payroll data
     */
    @Override
    public void deleteEmployeePayrollData(int empId)
    {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(employeePayrollData);
    }
}