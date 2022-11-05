package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    /**
     * Method for All Employee Payroll data List
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    /**
     * Method for get an employee data by id
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.get(empId-1);
    }

    /**
     * Method to Create an Employee Payroll data
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    /**
     * Method to Update an Employee Payroll data
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId-1, empData);
        return empData;
    }

    /**
     * Method to Delete an Employee Payroll data
     */
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}