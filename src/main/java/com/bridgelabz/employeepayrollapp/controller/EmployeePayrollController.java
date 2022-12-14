package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empDataList);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     * Displaying Employee data by id using get method
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData empPayrollData = null;
        empPayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successfully!", empPayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    /**
     * Getting Department wise employee list using department
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getDepartmentById(@PathVariable("department") String department){
        List<EmployeePayrollData> empDataList = null;
        empDataList =employeePayrollService.getEmployeePayrollDataByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("Get call success", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Creating employee data using Body by Post mapping
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
       log.debug("Employee DTO :"+empPayrollDTO.toString());
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully!", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Updating employee data using path variable and request body by put method
     */
    @PutMapping(path = "/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @Valid @RequestBody EmployeePayrollDTO empPayrollDTO){

        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", empPayrollDTO);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }
    /**
     * Deleting employee data using path variable by delete method
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " +empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}