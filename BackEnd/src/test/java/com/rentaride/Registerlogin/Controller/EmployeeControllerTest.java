package com.rentaride.Registerlogin.Controller;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.rentaride.Registerlogin.Dto.EmployeeDTO;
import com.rentaride.Registerlogin.Dto.LoginDTO;
import com.rentaride.Registerlogin.Response.LoginResponse;
import com.rentaride.Registerlogin.Service.EmployeeService;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        when(employeeService.addEmployee(employeeDTO)).thenReturn("12345");

        String result = employeeController.saveEmployee(employeeDTO);

        assertEquals("12345", result);
    }

    private void assertEquals(String string, String result) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testLoginEmployee() {
        LoginDTO loginDTO = new LoginDTO();
        LoginResponse loginResponse = new LoginResponse();
        when(employeeService.loginEmployee(loginDTO)).thenReturn(loginResponse);

        ResponseEntity<?> responseEntity = employeeController.loginEmployee(loginDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(loginResponse, responseEntity.getBody());
    }

	private void assertEquals(LoginResponse loginResponse, Object body) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(HttpStatus ok, HttpStatusCode statusCode) {
		// TODO Auto-generated method stub
		
	}
}
