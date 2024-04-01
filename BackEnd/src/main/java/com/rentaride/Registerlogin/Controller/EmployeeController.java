package com.rentaride.Registerlogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rentaride.Registerlogin.Dto.EmployeeDTO;
import com.rentaride.Registerlogin.Dto.LoginDTO;
import com.rentaride.Registerlogin.Response.LoginResponse;
import com.rentaride.Registerlogin.Service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/save")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		String id = employeeService.addEmployee(employeeDTO);
		return id;
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
		LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}