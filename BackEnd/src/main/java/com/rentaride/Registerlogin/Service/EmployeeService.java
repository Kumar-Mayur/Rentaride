package com.rentaride.Registerlogin.Service;

import com.rentaride.Registerlogin.Dto.EmployeeDTO;
import com.rentaride.Registerlogin.Dto.LoginDTO;
import com.rentaride.Registerlogin.Response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);

}