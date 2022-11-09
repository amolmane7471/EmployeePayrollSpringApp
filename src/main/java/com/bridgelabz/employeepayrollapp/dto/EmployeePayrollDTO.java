package com.bridgelabz.employeepayrollapp.dto;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;
//@Data
public @ToString class EmployeePayrollDTO {
    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Salary should be more than 500")
    public long salary;
    @Pattern(regexp = "male|female",message = "Gender Needs to be Male or Female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date Should not be Empty")
    @PastOrPresent(message = "Start Date Should be past or present Date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile Pic should not be Empty")
    public String profilePic;

    @NotNull(message = "Department should not be Empty")
    public List<String> department;


}
