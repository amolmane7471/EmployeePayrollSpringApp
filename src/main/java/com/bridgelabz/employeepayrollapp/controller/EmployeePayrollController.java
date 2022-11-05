package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("get call success", HttpStatus.OK);
    }

    /**
     * Displaying Employee data by id using get method
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("get call success for id: "+empId, HttpStatus.OK);
    }

    /**
     * Creating employee data using Body by Post mapping
     */
    @PostMapping(path = "/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        return new ResponseEntity<String>("created employee payroll data for: "+empPayrollDTO, HttpStatus.OK);
    }

    /**
     * Updating employee data using path variable and request body by put method
     */
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO empPayrollDTO) {
         return new ResponseEntity<String>("Updated employee payroll data for: "+empPayrollDTO, HttpStatus.OK);
    }

    /**
     * Deleting employee data using path variable by delete method
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("delete call success for id: "+empId, HttpStatus.OK);
    }

}